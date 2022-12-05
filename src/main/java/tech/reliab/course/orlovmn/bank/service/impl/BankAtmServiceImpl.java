package tech.reliab.course.orlovmn.bank.service.impl;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.entity.BankAtm;
import tech.reliab.course.orlovmn.bank.entity.BankOffice;
import tech.reliab.course.orlovmn.bank.entity.Employee;
import tech.reliab.course.orlovmn.bank.enums.AtmStatus;
import tech.reliab.course.orlovmn.bank.exceptions.NegativeSumException;
import tech.reliab.course.orlovmn.bank.exceptions.NotEnoughMoneyException;
import tech.reliab.course.orlovmn.bank.service.BankAtmService;

/**
 *  Singleton
 */
public class BankAtmServiceImpl implements BankAtmService {
    private static  BankAtmServiceImpl INSTANCE;

    private BankAtmServiceImpl(){}

    public static BankAtmServiceImpl getInstance(){
        if (INSTANCE==null){
            INSTANCE = new BankAtmServiceImpl();
        }
        return INSTANCE;
    }

    private Long id = 0L;


    @Override
    public BankAtm create(String name, Bank bank, BankOffice bankOffice, Employee employee, double maintenance){
        var bankAtm = new BankAtm(
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
        bank.getAtms().add(bankAtm);
        bankOffice.getAtms().add(bankAtm);
        return bankAtm;
    }

    @Override
    public void withdrawMoney(BankAtm atm, double sum){
        if(atm.getMoneyAmount()<sum){
            throw new NotEnoughMoneyException();
        }
        if(sum < 0){
            throw new NegativeSumException();
        }
        atm.setMoneyAmount(atm.getMoneyAmount()-sum);
    }


}


