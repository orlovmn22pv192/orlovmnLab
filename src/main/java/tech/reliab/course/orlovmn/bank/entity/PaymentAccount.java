package tech.reliab.course.orlovmn.bank.entity;

import java.math.BigDecimal;

public class PaymentAccount {
    Long id;
    User user;
    String bankName;
    BigDecimal sum;

    public  PaymentAccount() {}

    public PaymentAccount(Long id, User user, String bankName, BigDecimal sum) {
        this.id = id;
        this.user = user;
        this.bankName = bankName;
        this.sum = sum;
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

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                "id=" + id +
                ", user=" + user +
                ", bankName='" + bankName + '\'' +
                ", sum=" + sum +
                '}';
    }
}
