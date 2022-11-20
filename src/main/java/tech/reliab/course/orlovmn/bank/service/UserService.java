package tech.reliab.course.orlovmn.bank.service;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.entity.User;
import tech.reliab.course.orlovmn.bank.exceptions.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

public interface UserService {
    /**
     *
     * @param firstName - имя
     * @param lastName - фамилия
     * @param birthDate - дата рождения клиента
     * @param job - место работы
     * @param bank - банк
     * @return - возвращает созданный объект клиент
     */
    User create(String firstName, String lastName, LocalDate birthDate, String job, Bank bank);
    /**
     *
     * @param firstName - имя
     * @param lastName - фамилия
     * @param patronymic - отчество
     * @param birthDate - дата рождения клиента
     * @param job - место работы
     * @param bank - банк
     * @return - возвращает созданный объект клиент
     */
    User create(String firstName, String lastName, String patronymic, LocalDate birthDate, String job, Bank bank);

    /**
     *
     * @return возвращает список пользователей
     */
    List<User> findAll();

    /**
     * добавляет пользователя в коллекцию
     * @param user - пользователь
     */
    void addUser(User user);

    /**
     *
     * @param id - id пользователя
     * @return возвращает пользователя с данным id
     */
    User getUserById(Long id) throws IdException;

    /**
     * удаляет пользователя с данным id
     * @param id - id пользователя
     */
    void delUserById(Long id) throws DeletingNotExistentObjectException;

    /**
     * выводит на экран информацию о пользователе
     * @param id - id пользователя
     */
    void outputUserInfo(Long id);

    /**
     *
     * @param userId - id пользователя
     * @param sum - сумма кредита
     * @return - возвращает id кредитного счета, если кредит выдан, иначе возвращает null
     */
    Long getCredit(Long userId, double sum) throws NotEnoughMoneyException, NegativeSumException, IdException, LendingTermsException;
}
