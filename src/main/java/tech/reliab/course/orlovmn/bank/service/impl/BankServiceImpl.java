package tech.reliab.course.orlovmn.bank.service.impl;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.exceptions.DeletingNotExistentObjectException;
import tech.reliab.course.orlovmn.bank.exceptions.IdException;
import tech.reliab.course.orlovmn.bank.service.BankService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

/**
 *  Singleton
 */
public class BankServiceImpl implements BankService {

    private static  BankServiceImpl INSTANCE;

    private BankServiceImpl(){}

    public static BankServiceImpl getInstance(){
        if (INSTANCE==null){
            INSTANCE = new BankServiceImpl();
        }
        return INSTANCE;
    }

    private Long id = 0L;
    private static Random random = new Random();
    private LinkedHashMap<Long, Bank> banks = new LinkedHashMap<Long, Bank>();

    @Override
    public Bank create(String name){
        int rating = random.nextInt(100);
        int money = random.nextInt(200000);
        double rate = (20 - (20 * rating)/100.0);
        var bank = new Bank(
                ++id,
                name,
                0,
                0,
                0,
                0,
                rating,
                money,
                rate
        );

        return bank;
    }

    @Override
    public List<Bank> findAll(){
        return banks.values().stream().toList();
    }

    @Override
    public void addBank(Bank bank){
        banks.put(bank.getId(), bank);
    }

    @Override
    public Bank getBankById(Long id) throws IdException {
        var bank = banks.get(id);
        if(bank == null){
            throw new IdException();
        }
        return bank;
    }

    @Override
    public void delBankById(Long id) throws DeletingNotExistentObjectException {
        if(banks.get(id) == null){
            throw new DeletingNotExistentObjectException();
        }
        banks.remove(id);
    }

    @Override
    public void outputBankInfo(Long id){
        if(banks.containsKey(id)){
            System.out.println("Bank:");
            try {
                System.out.println("\t" + getBankById(id));
            } catch (IdException e) {
                throw new RuntimeException(e);
            }
            var offices = BankOfficeServiceImpl.getInstance().findAll().stream()
                    .filter(office -> office.getBank().getId().compareTo(id) == 0).toList();
            System.out.println("\tOfficese:");
            for(var office : offices){
                System.out.println("\t\t" + office);
                var employees = EmployeeServiceImpl.getInstance().findAll().stream()
                    .filter(employee -> employee.getBankOffice().getId()
                    .compareTo(office.getId())==0).toList();
                System.out.println("\t\tEmployees:");
                for(var employee : employees){
                    System.out.println("\t\t\t" + employee);
                }
            }
            System.out.println("\tAtms:");
            var atms = BankAtmServiceImpl.getInstance().findAll().stream()
                    .filter(atm -> atm.getBank().getId().compareTo(id)==0).toList();
            for(var atm : atms){
                System.out.println("\t\t" + atm);
            }
            System.out.println("\tUsers:");
            var users = UserServiceImpl.getInstance().findAll().stream()
                    .filter(user -> user.getBanks().get(0).getId().compareTo(id)==0).toList();
            for(var user : users){
                UserServiceImpl.getInstance().outputUserInfo(user.getId());
            }
        }else {
            System.out.println("Not found bank with id:" + id);
        }
    }
}
