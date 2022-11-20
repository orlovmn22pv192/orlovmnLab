package tech.reliab.course.orlovmn.bank.service.impl;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.entity.BankOffice;
import tech.reliab.course.orlovmn.bank.exceptions.DeletingNotExistentObjectException;
import tech.reliab.course.orlovmn.bank.exceptions.IdException;
import tech.reliab.course.orlovmn.bank.service.BankOfficeService;

import java.util.LinkedHashMap;
import java.util.List;

/**
 *  Singleton
 */
public class BankOfficeServiceImpl implements BankOfficeService {

    private static  BankOfficeServiceImpl INSTANCE;

    private BankOfficeServiceImpl(){}

    public static BankOfficeServiceImpl getInstance(){
        if (INSTANCE==null){
            INSTANCE = new BankOfficeServiceImpl();
        }
        return INSTANCE;
    }

    Long id = 0L;
    private LinkedHashMap<Long, BankOffice> offices = new LinkedHashMap<Long, BankOffice>();

    @Override
    public BankOffice create(String name, Bank bank, String address, double rent){
        var bankOffice = new BankOffice(
                ++id,
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
        bank.setNumberOfOffices(bank.getNumberOfOffices()+1);
        return bankOffice;
    }

    @Override
    public List<BankOffice> findAll(){
        return offices.values().stream().toList();
    }

    @Override
    public void addOffice(BankOffice office){
        offices.put(office.getId(), office);
    }

    @Override
    public BankOffice getOfficeById(Long id) throws IdException {
        var office = offices.get(id);
        if(office == null){
            throw new IdException();
        }
        return office;
    }

    @Override
    public void delOfficeById(Long id) throws DeletingNotExistentObjectException {
        if(offices.get(id)==null){
            throw new DeletingNotExistentObjectException();
        }
        offices.remove(id);
    }

    @Override
    public List<BankOffice> getAllOfficesByBankId(Long bankId) {
        return findAll().stream().filter(office->office.getBank().getId().compareTo(bankId)==0).toList();
    }
}
