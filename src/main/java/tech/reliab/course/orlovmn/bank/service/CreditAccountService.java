package tech.reliab.course.orlovmn.bank.service;

import tech.reliab.course.orlovmn.bank.entity.*;
import tech.reliab.course.orlovmn.bank.exceptions.DeletingNotExistentObjectException;
import tech.reliab.course.orlovmn.bank.exceptions.IdException;

import java.time.LocalDate;
import java.util.List;

public interface CreditAccountService {
    /**
     *
     * @param user - клиент
     * @param bank - банк
     * @param start - дата начала кредита
     * @param end - дата окончания кредита
     * @param month - кол-во месяцев
     * @param sum - сумма кредита
     * @param monthPayment - ежемесячный платеж
     * @param employee - сотрудник выдавший кредит
     * @param paymentAccount - платежный счет
     * @return - возвращает созданный кредитный счет
     */
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

    /**
     *
     * @return возвращает список всех кредитных аккаунтов
     */
    List<CreditAccount> findAll();

    /**
     * добавляет кредитный аккаун в коллекцию
     * @param creditAccount - кредитный аккаун
     */
    void addCreditAccount(CreditAccount creditAccount);

    /**
     *
     * @param id - id кредитного аккаунта
     * @return возвращает кредитный аккаун с данным id или null
     */
    CreditAccount getCreditAccountById(Long id) throws IdException;

    /**
     * удаляет кредитный аккаун по id
     * @param id - id кредитного аккаунта
     */
    void delCreditAccountById(Long id) throws DeletingNotExistentObjectException;
}
