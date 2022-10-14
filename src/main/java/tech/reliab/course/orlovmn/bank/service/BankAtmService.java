package tech.reliab.course.orlovmn.bank.service;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.entity.BankAtm;
import tech.reliab.course.orlovmn.bank.entity.BankOffice;
import tech.reliab.course.orlovmn.bank.entity.Employee;

public interface BankAtmService {
    BankAtm create(String name, Bank bank, BankOffice bankOffice, Employee employee, double maintenance);
    BankAtm read();
    void update();
    void update(BankAtm bankAtm);
    void delete(BankAtm bankAtm);
}
