package tech.reliab.course.toropchinda;

import tech.reliab.course.toropchinda.bank.service.BankService;
import tech.reliab.course.toropchinda.bank.service.impl.BankImpl;

public class Main {
    public static void main(String[] args) {
        BankService bank = new BankImpl(1);
        bank.set_id(2);
        System.out.println(bank.get_id());
    }
}