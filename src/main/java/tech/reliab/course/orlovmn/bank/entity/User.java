package tech.reliab.course.orlovmn.bank.entity;

import java.math.BigDecimal;
import java.util.Date;

public class User {
    Long id;
    String fullName;
    Date birthDate;
    String job;
    BigDecimal salary;
    Bank bank;
    CreditAccount creditAccount;
    PaymentAccount paymentAccount;
    int creditRating;

    public User() {}

    public User(Long id, String fullName, Date birthDate, String job,
                BigDecimal salary, Bank bank, CreditAccount creditAccount,
                PaymentAccount paymentAccount, int creditRating) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.job = job;
        this.salary = salary;
        this.bank = bank;
        this.creditAccount = creditAccount;
        this.paymentAccount = paymentAccount;
        this.creditRating = creditRating;
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public CreditAccount getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(CreditAccount creditAccount) {
        this.creditAccount = creditAccount;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                ", bank=" + bank +
                ", creditAccount=" + creditAccount +
                ", paymentAccount=" + paymentAccount +
                ", creditRating=" + creditRating +
                '}';
    }
}
