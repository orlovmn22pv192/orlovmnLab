package tech.reliab.course.orlovmn.bank.service.impl;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.entity.PaymentAccount;
import tech.reliab.course.orlovmn.bank.entity.User;
import tech.reliab.course.orlovmn.bank.exceptions.DeletingNotExistentObjectException;
import tech.reliab.course.orlovmn.bank.exceptions.IdException;
import tech.reliab.course.orlovmn.bank.service.PaymentAccountService;

import java.util.LinkedHashMap;
import java.util.List;

/**
 *  Singleton
 */
public class PaymentAccountServiceImpl implements PaymentAccountService {
    private static  PaymentAccountServiceImpl INSTANCE;

    private PaymentAccountServiceImpl(){}

    public static PaymentAccountServiceImpl getInstance(){
        if (INSTANCE==null){
            INSTANCE = new PaymentAccountServiceImpl();
        }
        return INSTANCE;
    }

    private Long id = 0L;
    private LinkedHashMap<Long, PaymentAccount> paymentAccounts = new LinkedHashMap<Long, PaymentAccount>();


    @Override
    public PaymentAccount create(User user, Bank bank){
        var paymentAccount = new PaymentAccount(
                ++id,
                user,
                bank,
                0
        );
        if(!user.getBanks().contains(bank)){
            user.addBank(bank);
        }
        return paymentAccount;
    }

    @Override
    public List<PaymentAccount> findAll(){
        return paymentAccounts.values().stream().toList();
    }

    @Override
    public void addPaymentAccount(PaymentAccount paymentAccount) {
        paymentAccounts.put(paymentAccount.getId(), paymentAccount);
    }

    @Override
    public PaymentAccount getPaymentAccountById(Long id) throws IdException {
        var paymentAccount = paymentAccounts.get(id);
        if(paymentAccount == null){
            throw new IdException();
        }
        return paymentAccount;
    }

    @Override
    public void delPaymentAccountById(Long id) throws DeletingNotExistentObjectException {
        if(paymentAccounts.get(id) == null){
            throw new DeletingNotExistentObjectException();
        }
        paymentAccounts.remove(id);
    }


}
