package tech.reliab.course.orlovmn.bank.service;
import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.exceptions.DeletingNotExistentObjectException;
import tech.reliab.course.orlovmn.bank.exceptions.IdException;

import java.util.List;

public interface BankService {
    /**
     *
     * @param name - имя банка
     * @return - возвращает созданный объект банк
     */
    Bank create(String name);

    /**
     *
     * @return возвращает список всех банков
     */
    List<Bank> findAll();

    /**
     * добавляет банк в коллекцию
     * @param bank - банк
     */
    void addBank(Bank bank);

    /**
     *
     * @param id - id банка
     * @return возвращает банк с данным id или null
     */
    Bank getBankById(Long id) throws IdException;

    /**
     * удаляет банк по id
     * @param id - id банка
     */
    void delBankById(Long id) throws DeletingNotExistentObjectException;

    /**
     * выводит на экран информацию о банке с данным id
     * @param id - id банка
     */
    void outputBankInfo(Long id);
}
