package tech.reliab.course.orlovmn.bank.service;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.entity.BankAtm;
import tech.reliab.course.orlovmn.bank.entity.BankOffice;
import tech.reliab.course.orlovmn.bank.entity.Employee;
import tech.reliab.course.orlovmn.bank.exceptions.DeletingNotExistentObjectException;
import tech.reliab.course.orlovmn.bank.exceptions.IdException;
import tech.reliab.course.orlovmn.bank.exceptions.NegativeSumException;
import tech.reliab.course.orlovmn.bank.exceptions.NotEnoughMoneyException;

import java.util.List;

public interface BankAtmService {
    /**
     *
     * @param name - назание банкомата
     * @param bank - банк
     * @param bankOffice - офис банка
     * @param employee - обслуживающий сотрудник
     * @param maintenance - стоимость обслуживания
     * @return - возвращает созданный объект банкомат
     */
    BankAtm create(String name, Bank bank, BankOffice bankOffice, Employee employee, double maintenance);

    /**
     *
     * @return возвращает список всех банкоматов
     */
    List<BankAtm> findAll();

    /**
     * добавляет банкомат в коллекцию
     * @param atm - банкомат
     */
    void addBankAtm(BankAtm atm);

    /**
     *
     * @param id - id банкомата
     * @return возвращает банкомат с данным id или null
     */
    BankAtm getBankAtmById(Long id) throws IdException;

    /**
     * удаляет банкомат по id
     * @param id - id банкомата
     */
    void delBankAtmById(Long id) throws DeletingNotExistentObjectException;

    /**
     *
     * @param officeId - id офиса
     * @return - возвращает все банкоматы офиса с данным id
     */
    List<BankAtm> getAllAtmsByOfficeId(Long officeId);

    /**
     * Снятие денег в банкомате
     * @param atm - банкомат
     * @param sum - сумма снятия
     */
    void withdrawMoney(BankAtm atm, double sum) throws NotEnoughMoneyException, NegativeSumException;
}
