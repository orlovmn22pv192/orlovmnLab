package tech.reliab.course.toropchinda.bank.service.impl;
import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.service.BankService;

public class BankImpl extends Bank implements BankService {
    public BankImpl(int id){
        this.id = id;
    }
    public int get_id(){
        return id;
    }
    public void set_id(int id){
        this.id = id;
    }

}
