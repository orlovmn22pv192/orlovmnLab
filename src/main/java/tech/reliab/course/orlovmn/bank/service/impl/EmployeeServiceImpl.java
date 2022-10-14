package tech.reliab.course.orlovmn.bank.service.impl;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.entity.BankOffice;
import tech.reliab.course.orlovmn.bank.entity.Employee;
import tech.reliab.course.orlovmn.bank.service.EmployeeService;

import java.util.Date;

public class EmployeeServiceImpl implements EmployeeService {

    private Long id = 0L;
    private Employee employee;

    /**
     *
     * @param fullName - ФИО сотрудника
     * @param birthDate - дата рождения сотрудника
     * @param job - должность
     * @param bank - банк
     * @param bankOffice - офис банка
     * @param salary - зарплата
     * @return - возвращает созданный объект сотрудника
     */
    @Override
    public Employee create(String fullName, Date birthDate, String job, Bank bank, BankOffice bankOffice, double salary){
        employee = new Employee(
                ++id,
                fullName,
                birthDate,
                job,
                bank,
                true,
                bankOffice,
                true,
                salary
        );
        return employee;
    }

    /**
     *
     * @return - возвращает объект сотрудник
     */
    @Override
    public Employee read(){
        return employee;
    }

    /**
     *
     * @param employee - новый сотрудник
     */
    @Override
    public void update(Employee employee){
        this.employee = employee;
    }

    /**
     *
     * @param employee - сотрудник для удаления
     */
    @Override
    public void delete(Employee employee){
        if(this.employee == employee){
            this.employee = null;
        }
    }

}
