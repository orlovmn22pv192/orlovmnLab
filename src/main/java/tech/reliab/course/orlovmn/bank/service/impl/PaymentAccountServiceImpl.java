package tech.reliab.course.orlovmn.bank.service.impl;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.entity.PaymentAccount;
import tech.reliab.course.orlovmn.bank.entity.User;
import tech.reliab.course.orlovmn.bank.service.PaymentAccountService;

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
        user.getPaymentAccounts().add(paymentAccount);
        return paymentAccount;
    }




}
