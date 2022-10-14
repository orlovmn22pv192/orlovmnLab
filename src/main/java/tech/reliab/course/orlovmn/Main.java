package tech.reliab.course.orlovmn;

import tech.reliab.course.orlovmn.bank.entity.*;
import tech.reliab.course.orlovmn.bank.service.*;
import tech.reliab.course.orlovmn.bank.service.impl.*;

import java.time.Instant;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //Сервисы
        BankService bankService = new BankServiceImpl();
        BankOfficeServiceImpl officeService = new BankOfficeServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        BankAtmService atmService = new BankAtmServiceImpl();
        UserService userService = new UserServiceImpl();
        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        CreditAccountService creditAccountService = new CreditAccountServiceImpl();

        //Объекты

        //создаем банк
        Bank bank = bankService.create("MyBank");
        //создаем офис
        BankOffice office = officeService.create("MyOffice", bank, "MyAddress", 1000.);
        //создаем сотрудника
        Employee employee = employeeService.create(
                "name",
                Date.from(Instant.now()),
                "job",
                bank,
                office,
                15000.
        );
        //создаем банкомат
        BankAtm atm = atmService.create("atm", bank, office, employee, 1000.);
        //создаем клиента
        User user = userService.create("user",Date.from(Instant.now()),"job",bank);
        //создаем платежный счет
        PaymentAccount paymentAccount = paymentAccountService.create(user, bank.getName());
        //создаем кредитный счет
        CreditAccount creditAccount = creditAccountService.create(
                user,
                bank,
                Date.from(Instant.now()),
                Date.from(Instant.now()),
                12,
                12,
                1,
                employee,
                paymentAccount
        );

        officeService.update();
        System.out.println(bank);
        System.out.println(office);
        System.out.println(employee);
        System.out.println(atm);
        System.out.println(user);
        System.out.println(paymentAccount);
        System.out.println(creditAccount);

        bankService.delete(bank);
        officeService.delete(office);
        employeeService.delete(employee);
        atmService.delete(atm);
        userService.delete(user);
        paymentAccountService.delete(paymentAccount);
        creditAccountService.delete(creditAccount);
    }
}