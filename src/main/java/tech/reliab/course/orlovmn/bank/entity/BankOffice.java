package tech.reliab.course.orlovmn.bank.entity;

import java.math.BigDecimal;

public class BankOffice {
    Long id;
    String name;
    String address;
    boolean isWorking;
    boolean isPossiblePlaceAtm;
    int atmNumber = 0;
    boolean canApplyLoan;
    boolean canPaymentOfMoney;
    boolean canDepositMoney;
    BigDecimal moneyAmount;
    BigDecimal rent;

    public BankOffice() {}

    public BankOffice(Long id, String name, String address, boolean isWorking,
                      boolean isPossiblePlaceAtm, int atmNumber, boolean canApplyLoan,
                      boolean canPaymentOfMoney, boolean canDepositMoney, BigDecimal moneyAmount,
                      BigDecimal rent) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.isWorking = isWorking;
        this.isPossiblePlaceAtm = isPossiblePlaceAtm;
        this.atmNumber = atmNumber;
        this.canApplyLoan = canApplyLoan;
        this.canPaymentOfMoney = canPaymentOfMoney;
        this.canDepositMoney = canDepositMoney;
        this.moneyAmount = moneyAmount;
        this.rent = rent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public boolean isPossiblePlaceAtm() {
        return isPossiblePlaceAtm;
    }

    public void setPossiblePlaceAtm(boolean possiblePlaceAtm) {
        isPossiblePlaceAtm = possiblePlaceAtm;
    }

    public int getAtmNumber() {
        return atmNumber;
    }

    public void setAtmNumber(int atmNumber) {
        this.atmNumber = atmNumber;
    }

    public boolean isCanApplyLoan() {
        return canApplyLoan;
    }

    public void setCanApplyLoan(boolean canApplyLoan) {
        this.canApplyLoan = canApplyLoan;
    }

    public boolean isCanPaymentOfMoney() {
        return canPaymentOfMoney;
    }

    public void setCanPaymentOfMoney(boolean canPaymentOfMoney) {
        this.canPaymentOfMoney = canPaymentOfMoney;
    }

    public boolean isCanDepositMoney() {
        return canDepositMoney;
    }

    public void setCanDepositMoney(boolean canDepositMoney) {
        this.canDepositMoney = canDepositMoney;
    }

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(BigDecimal moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "BankOffice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", isWorking=" + isWorking +
                ", isPossiblePlaceAtm=" + isPossiblePlaceAtm +
                ", atmNumber=" + atmNumber +
                ", canApplyLoan=" + canApplyLoan +
                ", canPaymentOfMoney=" + canPaymentOfMoney +
                ", canDepositMoney=" + canDepositMoney +
                ", moneyAmount=" + moneyAmount +
                ", rent=" + rent +
                '}';
    }
}