package tech.reliab.course.orlovmn.bank.service;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.entity.PaymentAccount;
import tech.reliab.course.orlovmn.bank.entity.User;
import tech.reliab.course.orlovmn.bank.exceptions.DeletingNotExistentObjectException;
import tech.reliab.course.orlovmn.bank.exceptions.IdException;

import java.util.List;


public interface PaymentAccountService {
    /**
     *
     * @param user - клиент
     * @param bank -  банка
     * @return - возвращает созданный объект платежный счет
     */
    PaymentAccount create(User user, Bank bank);

    /**
     *
     * @return возвращает список платежных счетов
     */
    List<PaymentAccount> findAll();

    /**
     * добавляет платежный счет в коллекцию
     * @param paymentAccount - платежный счет
     */
    void addPaymentAccount(PaymentAccount paymentAccount);

    /**
     *
     * @param id - id платежного счета
     * @return возвращает платежный счет с данным id
     */
    PaymentAccount getPaymentAccountById(Long id) throws IdException;

    /**
     * удаляет платежный счет с данным id
     * @param id - id платежного счета
     */
    void delPaymentAccountById(Long id) throws DeletingNotExistentObjectException;
}
