package tech.reliab.course.orlovmn.bank.utils;

import tech.reliab.course.orlovmn.bank.entity.Bank;

import java.util.Comparator;

public class BankComparator implements Comparator<Bank> {
    @Override
    public int compare(Bank left, Bank right){
        if(!((left.getInterestRate() - right.getInterestRate()) < 0.00001)){
            return left.getInterestRate() < right.getInterestRate() ? 1: -1;
        }

        if(left.getRating() != right.getRating()){
            return left.getRating() > right.getRating() ? 1: -1;
        }

        if(left.getNumberOfClients() != right.getNumberOfClients()){
            return  left.getNumberOfClients() > right.getNumberOfClients() ? 1: -1;
        }

        if(left.getNumberOfOffices() != right.getNumberOfOffices()){
            return left.getNumberOfOffices() > right.getNumberOfOffices() ? 1: -1;
        }

        if(left.getNumberOfAtms() != right.getNumberOfAtms()){
            return left.getNumberOfAtms() > right.getNumberOfAtms() ? 1: -1;
        }

        if(left.getNumberOfEmployees() != right.getNumberOfEmployees()){
            return left.getNumberOfEmployees() > right.getNumberOfEmployees() ? 1: -1;
        }

        return  0;
    }
}
