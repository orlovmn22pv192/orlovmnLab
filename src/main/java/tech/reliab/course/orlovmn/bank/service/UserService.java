package tech.reliab.course.orlovmn.bank.service;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.entity.User;

import java.io.IOException;
import java.time.LocalDate;

public interface UserService {
    /**
     *
     * @param firstName - имя
     * @param lastName - фамилия
     * @param birthDate - дата рождения клиента
     * @param job - место работы
     * @return - возвращает созданный объект клиент
     */
    User create(String firstName, String lastName, LocalDate birthDate, String job);
    /**
     *
     * @param firstName - имя
     * @param lastName - фамилия
     * @param patronymic - отчество
     * @param birthDate - дата рождения клиента
     * @param job - место работы
     * @return - возвращает созданный объект клиент
     */
    User create(String firstName, String lastName, String patronymic, LocalDate birthDate, String job);

    /**
     * выводит на экран информацию о пользователе
     * @param user - id пользователя
     */
    void outputUserInfo(User user);

    /**
     * Добавляет банк в список банков, которыми пользуется клиент
     * @param user - клиент
     * @param bank - банк
     */
    void addBank(User user, Bank bank);

    /**
     * Удаляет банк из списка банков, которыми пользуется клиент
     * @param user - клиент
     * @param bank - банк
     */
    void deleteBank(User user, Bank bank);

    /**
     * Выводит всех счетов пользователя в txt файл, по конкретному банку
     * @param user - пользователь
     * @param bank - банк
     * @param fileName - имя файла
     */
    void outputUserAccountsToFile(User user, Bank bank, String fileName) throws IOException;

}
