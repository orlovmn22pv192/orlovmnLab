package tech.reliab.course.orlovmn.bank.service;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.entity.BankOffice;

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
     * @return список всех офисов
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
     * @return офис с данным id или null
     */
    BankOffice getOfficeById(Long id);

    /**
     * удаляет офис по id
     * @param id - id офиса
     */
    void delOfficeById(Long id);
}
