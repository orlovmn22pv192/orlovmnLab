package tech.reliab.course.orlovmn.bank.service;

import tech.reliab.course.orlovmn.bank.entity.PaymentAccount;
import tech.reliab.course.orlovmn.bank.entity.User;


public interface PaymentAccountService {
    PaymentAccount create(User user, String bankName);
    PaymentAccount read();
    void update(PaymentAccount paymentAccount);
    void delete(PaymentAccount paymentAccount);
}
