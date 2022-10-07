package tech.reliab.course.orlovmn.bank.entity;
import tech.reliab.course.orlovmn.bank.utils.AtmStatus;

import java.math.BigDecimal;


public class BankAtm {
    Long id;
    String name;
    AtmStatus status;
    String address;
    BankOffice bankOffice;
    Employee employee;
    boolean canPaymentOfMoney;
    boolean canDepositMoney;
    BigDecimal moneyAmount;
    BigDecimal maintenance;

    public BankAtm() {}

    public BankAtm(Long id, String name, AtmStatus status, String address,
                   BankOffice bankOffice, Employee employee, boolean canPaymentOfMoney,
                   boolean canDepositMoney, BigDecimal moneyAmount, BigDecimal maintenance) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.address = address;
        this.bankOffice = bankOffice;
        this.employee = employee;
        this.canPaymentOfMoney = canPaymentOfMoney;
        this.canDepositMoney = canDepositMoney;
        this.moneyAmount = moneyAmount;
        this.maintenance = maintenance;
    }

    public BankAtm(BankAtm bankAtm) {
        this.id = bankAtm.getId();
        this.name = bankAtm.getName();
        this.status = bankAtm.getStatus();
        this.address = bankAtm.getAddress();
        this.bankOffice = bankAtm.getBankOffice();
        this.employee = bankAtm.getEmployee();
        this.canPaymentOfMoney = bankAtm.isCanPaymentOfMoney();
        this.canDepositMoney = bankAtm.isCanDepositMoney();
        this.moneyAmount = bankAtm.getMoneyAmount();
        this.maintenance = bankAtm.getMaintenance();
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

    public AtmStatus getStatus() {
        return status;
    }

    public void setStatus(AtmStatus status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public BigDecimal getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(BigDecimal maintenance) {
        this.maintenance = maintenance;
    }

    @Override
    public String toString() {
        return "BankAtm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", address='" + address + '\'' +
                ", bankOffice=" + bankOffice +
                ", employee=" + employee +
                ", isCanPaymentOfMoney=" + canPaymentOfMoney +
                ", isCanDepositMoney=" + canDepositMoney +
                ", moneyAmount=" + moneyAmount +
                ", maintenance=" + maintenance +
                '}';
    }
}
