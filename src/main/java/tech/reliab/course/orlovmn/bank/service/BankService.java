package tech.reliab.course.orlovmn.bank.service;
import tech.reliab.course.orlovmn.bank.entity.Bank;

public interface BankService {
    Bank create(String name);
    Bank read();
    void update(Bank bank);
    void delete(Bank bank);
}
