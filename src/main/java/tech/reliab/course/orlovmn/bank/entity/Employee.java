package tech.reliab.course.orlovmn.bank.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Employee {
    Long id;
    String fullName;
    Date birthDate;
    String job;
    Bank bank;
    boolean workInOffice;
    BankOffice bankOffice;
    boolean canApplyLoan;
    double salary;

    public Employee() {}

    public Employee(Long id, String fullName, Date birthDate, String job,
                    Bank bank, boolean workInOffice, BankOffice bankOffice,
                    boolean canApplyLoan, double salary) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.job = job;
        this.bank = bank;
        this.workInOffice = workInOffice;
        this.bankOffice = bankOffice;
        this.canApplyLoan = canApplyLoan;
        this.salary = salary;
    }

    public Employee(Employee employee) {
        this.id = employee.getId();
        this.fullName = employee.getFullName();
        this.birthDate = employee.getBirthDate();
        this.job = employee.getJob();
        this.bank = employee.getBank();
        this.workInOffice = employee.isWorkInOffice();
        this.bankOffice = employee.getBankOffice();
        this.canApplyLoan = employee.isCanApplyLoan();
        this.salary = employee.getSalary();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public boolean isWorkInOffice() {
        return workInOffice;
    }

    public void setWorkInOffice(boolean workInOffice) {
        this.workInOffice = workInOffice;
    }

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public boolean isCanApplyLoan() {
        return canApplyLoan;
    }

    public void setCanApplyLoan(boolean canApplyLoan) {
        this.canApplyLoan = canApplyLoan;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", bank_id=" + bank.getId() +
                ", office=" + bankOffice.getName() +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", job='" + job + '\'' +
                ", workInOffice=" + workInOffice +
                ", canApplyLoan=" + canApplyLoan +
                ", salary=" + salary +
                '}';
    }
}
