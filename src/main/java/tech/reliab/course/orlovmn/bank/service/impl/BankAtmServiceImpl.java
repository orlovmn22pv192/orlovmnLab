package tech.reliab.course.orlovmn.bank.service.impl;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.entity.BankAtm;
import tech.reliab.course.orlovmn.bank.entity.BankOffice;
import tech.reliab.course.orlovmn.bank.entity.Employee;
import tech.reliab.course.orlovmn.bank.service.BankAtmService;
import tech.reliab.course.orlovmn.bank.utils.AtmStatus;

public class BankAtmServiceImpl implements BankAtmService {

    private Long id = 0L;
    private BankAtm bankAtm;

    /**
     *
     * @param name - назание банкомата
     * @param bank - банк
     * @param bankOffice - офис банка
     * @param employee - обслуживающий сотрудник
     * @param maintenance - стоимость обслуживания
     * @return - возвращает созданный объект банкомат
     */
    @Override
    public BankAtm create(String name, Bank bank, BankOffice bankOffice, Employee employee, double maintenance){
        bankAtm = new BankAtm(
                ++id,
                name,
                AtmStatus.WORKING,
                bankOffice.getAddress(),
                bank,
                bankOffice,
                employee,
                true,
                true,
                bank.getMoneyAmount(),
                maintenance
        );
        bank.setNumberOfAtms(bank.getNumberOfAtms()+1);
        return bankAtm;
    }

    /**
     *
     * @return - возвращает банкомат
     */
    @Override
    public BankAtm read(){
        return bankAtm;
    }

    /**
     *  обновляет поля адрес и количество денег
     */
    @Override
    public void update(){
        this.bankAtm.setAddress(this.bankAtm.getBankOffice().getAddress());
        this.bankAtm.setMoneyAmount(this.bankAtm.getBank().getMoneyAmount());
    }

    /**
     *
     * @param bankAtm - новый объект банкомат
     */
    @Override
    public void update(BankAtm bankAtm){
        this.bankAtm = bankAtm;
    }

    /**
     *
     * @param bankAtm - банкомат для удаления
     */
    @Override
    public void delete(BankAtm bankAtm){
        if(this.bankAtm == bankAtm){
            this.bankAtm = null;
        }
    }

}


