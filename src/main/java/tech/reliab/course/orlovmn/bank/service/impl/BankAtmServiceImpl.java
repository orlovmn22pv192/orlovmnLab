package tech.reliab.course.orlovmn.bank.service.impl;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.entity.BankAtm;
import tech.reliab.course.orlovmn.bank.entity.BankOffice;
import tech.reliab.course.orlovmn.bank.entity.Employee;
import tech.reliab.course.orlovmn.bank.enums.AtmStatus;
import tech.reliab.course.orlovmn.bank.exceptions.DeletingNotExistentObjectException;
import tech.reliab.course.orlovmn.bank.exceptions.IdException;
import tech.reliab.course.orlovmn.bank.exceptions.NegativeSumException;
import tech.reliab.course.orlovmn.bank.exceptions.NotEnoughMoneyException;
import tech.reliab.course.orlovmn.bank.service.BankAtmService;

import java.util.LinkedHashMap;
import java.util.List;

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
    private LinkedHashMap<Long, BankAtm> atms = new LinkedHashMap<Long, BankAtm>();


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
        bank.setNumberOfAtms(bank.getNumberOfAtms()+1);
        bankOffice.setAtmNumber(bankOffice.getAtmNumber()+1);
        return bankAtm;
    }

    @Override
    public List<BankAtm> findAll(){
        return atms.values().stream().toList();
    }

    @Override
    public void addBankAtm(BankAtm atm){
        atms.put(atm.getId(), atm);
    }

    @Override
    public BankAtm getBankAtmById(Long id) throws IdException {
        var atm = atms.get(id);
        if(atm == null){
            throw new IdException();
        }
        return atm;
    }

    @Override
    public void delBankAtmById(Long id) throws DeletingNotExistentObjectException {
        if(atms.get(id) == null){
            throw new DeletingNotExistentObjectException();
        }
        atms.remove(id);
    }

    @Override
    public List<BankAtm> getAllAtmsByOfficeId(Long officeId){
        return findAll().stream().filter(atm->atm.getBankOffice().getId().compareTo(officeId)==0).toList();
    }

    @Override
    public void withdrawMoney(BankAtm atm, double sum) throws NotEnoughMoneyException, NegativeSumException {
        if(atm.getMoneyAmount()<sum){
            throw new NotEnoughMoneyException();
        }
        if(sum < 0){
            throw new NegativeSumException();
        }
        atm.setMoneyAmount(atm.getMoneyAmount()-sum);
    }


}


