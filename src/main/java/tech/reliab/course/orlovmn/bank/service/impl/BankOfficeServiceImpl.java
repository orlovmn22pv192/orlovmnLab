package tech.reliab.course.orlovmn.bank.service.impl;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.entity.BankOffice;
import tech.reliab.course.orlovmn.bank.service.BankOfficeService;

public class BankOfficeServiceImpl implements BankOfficeService {

    private BankOffice bankOffice;

    /**
     *
     * @param name - имя офиса
     * @param bank - банк офиса
     * @param address - адрес офиса
     * @param rent - стоимость аренды офиса
     * @return - возвращает созданный объект офис
     */
    @Override
    public BankOffice create(String name, Bank bank, String address, double rent){
        bankOffice = new BankOffice(
                bank,
                name,
                address,
                true,
                true,
                bank.getNumberOfAtms(),
                true,
                true,
                true,
                bank.getMoneyAmount(),
                rent
        );
        return bankOffice;
    }

    /**
     *
     * @return - возвращает объект офис
     */
    @Override
    public BankOffice read(){
        return bankOffice;
    }

    /**
     * обновляет поля количество банкоматов и количество денег
     *
     */
    @Override
    public void update(){
        this.bankOffice.setAtmNumber(this.bankOffice.getBank().getNumberOfAtms());
        this.bankOffice.setMoneyAmount(this.bankOffice.getBank().getMoneyAmount());
    }

    /**
     *
     * @param bankOffice - новый объект
     */
    @Override
    public  void update(BankOffice bankOffice){
        this.bankOffice = bankOffice;
    }

    /**
     *
     * @param bankOffice - офис для удалеия
     */
    @Override
    public void delete(BankOffice bankOffice){
        if(bankOffice == this.bankOffice){
            this.bankOffice = null;
        }
    }
}
