package tech.reliab.course.orlovmn.bank.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CreditAccount {
    Long id;
    User user;
    String bankName;
    Date start;
    Date end;
    int monthNumber;
    BigDecimal sum;
    BigDecimal monthPayment;
    BigDecimal interestRate;
    Employee employee;
    PaymentAccount paymentAccount;

    public CreditAccount() {}

    public CreditAccount(Long id, User user, String bankName, Date start,
                         Date end, int monthNumber, BigDecimal sum, BigDecimal monthPayment,
                         BigDecimal interestRate, Employee employee, PaymentAccount paymentAccount) {
        this.id = id;
        this.user = user;
        this.bankName = bankName;
        this.start = start;
        this.end = end;
        this.monthNumber = monthNumber;
        this.sum = sum;
        this.monthPayment = monthPayment;
        this.interestRate = interestRate;
        this.employee = employee;
        this.paymentAccount = paymentAccount;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public BigDecimal getMonthPayment() {
        return monthPayment;
    }

    public void setMonthPayment(BigDecimal monthPayment) {
        this.monthPayment = monthPayment;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "id=" + id +
                ", user=" + user +
                ", bankName='" + bankName + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", monthNumber=" + monthNumber +
                ", sum=" + sum +
                ", monthPayment=" + monthPayment +
                ", interestRate=" + interestRate +
                ", employee=" + employee +
                ", paymentAccount=" + paymentAccount +
                '}';
    }
}
