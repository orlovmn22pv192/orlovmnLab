package tech.reliab.course.orlovmn.bank.service;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.entity.BankOffice;
import tech.reliab.course.orlovmn.bank.entity.Employee;

import java.time.LocalDate;

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

}
