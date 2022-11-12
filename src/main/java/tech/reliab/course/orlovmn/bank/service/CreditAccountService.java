package tech.reliab.course.orlovmn.bank.service;

import tech.reliab.course.orlovmn.bank.entity.*;

import java.time.LocalDate;

public interface CreditAccountService {
    CreditAccount create(User user,
                         Bank bank,
                         LocalDate start,
                         LocalDate end,
                         int month,
                         double sum,
                         double monthPayment,
                         Employee employee,
                         PaymentAccount paymentAccount
    );
    CreditAccount read();
    void update(CreditAccount creditAccount);
    void delete(CreditAccount creditAccount);
}
