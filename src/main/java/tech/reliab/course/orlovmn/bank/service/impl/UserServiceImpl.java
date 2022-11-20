package tech.reliab.course.orlovmn.bank.service.impl;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.entity.BankAtm;
import tech.reliab.course.orlovmn.bank.entity.Employee;
import tech.reliab.course.orlovmn.bank.entity.User;
import tech.reliab.course.orlovmn.bank.exceptions.*;
import tech.reliab.course.orlovmn.bank.service.CreditAccountService;
import tech.reliab.course.orlovmn.bank.service.PaymentAccountService;
import tech.reliab.course.orlovmn.bank.service.UserService;
import tech.reliab.course.orlovmn.bank.utils.BankComparator;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

/**
 *  Singleton
 */
public class UserServiceImpl implements UserService {

    private static  UserServiceImpl INSTANCE;

    private UserServiceImpl(){}

    public static UserServiceImpl getInstance(){
        if (INSTANCE==null){
            INSTANCE = new UserServiceImpl();
        }
        return INSTANCE;
    }
    private Long id = 0L;
    private Random random = new Random();
    private LinkedHashMap<Long, User> users = new LinkedHashMap<Long, User>();

    @Override
    public User create(String firstName, String lastName, LocalDate birthDate, String job, Bank bank){
        double salary = random.nextInt(100000);
        var user = new User(
                ++id,
                firstName,
                lastName,
                birthDate,
                job,
                salary,
                bank,
                salary / 10
        );
        bank.setNumberOfClients(bank.getNumberOfClients()+1);
        return user;
    }

    @Override
    public User create(String firstName, String lastName, String patronymic, LocalDate birthDate, String job, Bank bank){
        double salary = random.nextInt(10000);
        var user = new User(
                ++id,
                firstName,
                lastName,
                patronymic,
                birthDate,
                job,
                salary,
                bank,
                salary / 10
        );
        bank.setNumberOfClients(bank.getNumberOfClients()+1);
        return user;
    }

    @Override
    public List<User> findAll() {
        return users.values().stream().toList();
    }

    @Override
    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User getUserById(Long id) throws IdException {
        var user = users.get(id);
        if(user == null){
            throw new IdException();
        }
        return user;
    }

    @Override
    public void delUserById(Long id) throws DeletingNotExistentObjectException {
        if(users.get(id) == null){
            throw new DeletingNotExistentObjectException();
        }
        users.remove(id);
    }

    @Override
    public void outputUserInfo(Long id) {
        System.out.println("User:");
        System.out.println(users.get(id));
        var pays = PaymentAccountServiceImpl.getInstance().findAll().stream()
                .filter(pay -> pay.getUser().getId().compareTo(id)==0).toList();
        System.out.println("\tPaymentAccounts:");
        for(var pay : pays){
            System.out.println("\t\t"+pay);
        }
        var credits = CreditAccountServiceImpl.getInstance().findAll().stream()
                .filter(pay -> pay.getUser().getId().compareTo(id)==0).toList();
        System.out.println("\tCreditAccounts:");
        for(var credit : credits){
            System.out.println("\t\t"+credit);
        }
    }

    @Override
    public Long getCredit(Long userId, double sum) throws NotEnoughMoneyException, NegativeSumException, IdException, LendingTermsException {
        var user = getUserById(userId);
        if(sum < 0){
            throw new NegativeSumException();
        }
        var banks = BankServiceImpl.getInstance().findAll().stream().sorted(new BankComparator()).toList();
        for(int i=banks.size()-1; i>=0; i--){
            var bankId = banks.get(i).getId();
            if(banks.get(i).getRating() > 50 && user.getCreditRating() < 500){
                continue;
            }
            var offices = BankOfficeServiceImpl.getInstance().getAllOfficesByBankId(bankId);
            for(int j=0; j<offices.size(); j++){
                if(!offices.get(j).isCanApplyLoan() || offices.get(j).getMoneyAmount() < sum){
                    continue;
                }
                var employee = EmployeeServiceImpl.getInstance().
                        getAllEmployeesByOfficeId(offices.get(j).getId())
                        .stream().filter(Employee::isCanApplyLoan).toList().get(0);
                if(employee == null){
                    continue;
                }
                var atms = BankAtmServiceImpl.getInstance().getAllAtmsByOfficeId(offices.get(j).getId());

                for(int k=0; k<atms.size(); k++){
                    if(!atms.get(k).isCanPaymentOfMoney() && atms.get(k).getMoneyAmount() < sum){
                        continue;
                    }
                    PaymentAccountService paymentAccountService = PaymentAccountServiceImpl.getInstance();
                    CreditAccountService creditAccountService = CreditAccountServiceImpl.getInstance();
                    if(!user.getBanks().contains(banks.get(i))){
                        paymentAccountService.addPaymentAccount(paymentAccountService.create(user, banks.get(i)));
                    }
                    int month = Math.toIntExact(Math.round(sum / user.getSalary()));
                    if(month < 6){
                        month = 6;
                    }
                    double monthPayment = sum/month;

                    var paymentAccount = paymentAccountService.findAll()
                            .stream().filter(
                                pay->pay.getUser().getId().compareTo(userId)==0 && pay.getBank().getId().compareTo(bankId)==0
                            ).toList().get(0);
                    var creditAccount = creditAccountService.create(
                            user,
                            banks.get(i),
                            LocalDate.now(),
                            LocalDate.now().plusMonths(month),
                            month,
                            sum,
                            monthPayment,
                            employee,
                            paymentAccount
                    );
                    creditAccountService.addCreditAccount(creditAccount);
                    BankAtmServiceImpl.getInstance().withdrawMoney(atms.get(k), sum);
                    return creditAccount.getId();
                }
            }
        }
        throw new LendingTermsException();
    }


}
