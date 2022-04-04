package model.entities;

import model.exception.DomainException;

public class Account {

    private Integer number;

    private String holder;

    private Double balance;

    private Double withdrawLimit;

    private Double amount;

    public Integer getNumber() {
        return number;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;

    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Account() {

    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {

        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Double Withdraw(Double amount, Double withdrawLimit) {

        balance = balance - amount;

        if (amount > balance) {
            throw new DomainException(" Your balance is lower than that! - WITHDRAWAL DENIED");
        }

        if (amount > withdrawLimit) {
            throw new DomainException(" This is higher than your Limit! - WITHDRAWAL DENIED");
        }
        return balance;
    }

    public Double Deposit(double balance, double amount) {

        return balance += amount;
    }
}
