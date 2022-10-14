package tech.reliab.course.orlovmn.bank.service;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.entity.User;

import java.util.Date;

public interface UserService {
    User create(String fullName, Date birthDate, String job, Bank bank);
    User read();
    void update(User user);
    void delete(User user);
}
