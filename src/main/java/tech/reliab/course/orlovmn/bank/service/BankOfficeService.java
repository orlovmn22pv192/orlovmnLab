package tech.reliab.course.orlovmn.bank.service;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.entity.BankOffice;
import tech.reliab.course.orlovmn.bank.exceptions.DeletingNotExistentObjectException;
import tech.reliab.course.orlovmn.bank.exceptions.IdException;

import java.util.List;

public interface BankOfficeService {
    /**
     *
     * @param name - имя офиса
     * @param bank - банк офиса
     * @param address - адрес офиса
     * @param rent - стоимость аренды офиса
     * @return - возвращает созданный объект офис
     */
    BankOffice create(String name, Bank bank, String address, double rent);

    /**
     *
     * @return возвращает список всех офисов
     */
    List<BankOffice> findAll();

    /**
     * добавляет офис в коллекцию
     * @param office - офис
     */
    void addOffice(BankOffice office);

    /**
     *
     * @param id - id офиса
     * @return возвращает офис с данным id или null
     */
    BankOffice getOfficeById(Long id) throws IdException;

    /**
     * удаляет офис по id
     * @param id - id офиса
     */
    void delOfficeById(Long id) throws DeletingNotExistentObjectException;

    /**
     *
     * @param bankId - id банка
     * @return - возвращает все офисы принадлежащие банку с данным id
     */
    List<BankOffice> getAllOfficesByBankId(Long bankId);
}
