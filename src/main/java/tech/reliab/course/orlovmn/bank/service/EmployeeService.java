package tech.reliab.course.orlovmn.bank.service;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.entity.BankOffice;
import tech.reliab.course.orlovmn.bank.entity.Employee;

import java.util.Date;

public interface EmployeeService {
    Employee create(String fullName, Date birthDate, String job, Bank bank, BankOffice bankOffice, double salary);
    Employee read();
    void update(Employee employee);
    void delete(Employee employee);
}
