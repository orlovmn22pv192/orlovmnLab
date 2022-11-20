package tech.reliab.course.orlovmn.bank.service;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.entity.BankOffice;
import tech.reliab.course.orlovmn.bank.entity.Employee;
import tech.reliab.course.orlovmn.bank.exceptions.DeletingNotExistentObjectException;
import tech.reliab.course.orlovmn.bank.exceptions.IdException;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {
    /**
     *
     * @param firstName - имя
     * @param lastName - фамилия
     * @param birthDate - дата рождения сотрудника
     * @param job - должность
     * @param bank - банк
     * @param bankOffice - офис банка
     * @param salary - зарплата
     * @return - возвращает созданный объект сотрудника
     */
    Employee create(String firstName, String lastName, LocalDate birthDate, String job,
                    Bank bank, BankOffice bankOffice, double salary
    );

    /**
     *
     * @param firstName - имя
     * @param lastName - фамилия
     * @param patronymic - отчество
     * @param birthDate - дата рождения сотрудника
     * @param job - должность
     * @param bank - банк
     * @param bankOffice - офис банка
     * @param salary - зарплата
     * @return - возвращает созданный объект сотрудника
     */
    Employee create(String firstName, String lastName, String patronymic, LocalDate birthDate,
                String job, Bank bank, BankOffice bankOffice, double salary
    );

    /**
     *
     * @return возвращает список сотрудников
     */
    List<Employee> findAll();

    /**
     * добавляет сотрудника в коллекцию
     * @param employee
     */
    void addEmployee(Employee employee);

    /**
     *
     * @param id - id сотрудника
     * @return возвращает сотрудника с данным id
     */
    Employee getEmployeeById(Long id) throws IdException;

    /**
     * удаляет сотрудника с данным id
     * @param id - id сотрудника
     */
    void delEmployeeById(Long id) throws DeletingNotExistentObjectException;

    /**
     *
     * @param officeId - id офиса
     * @return возвращает всех сотрудников офиса с данным id
     */
    List<Employee> getAllEmployeesByOfficeId(Long officeId);
}
