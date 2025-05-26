package com.bankmanagementsystem.model;

public class Transfer {
    private String accountNumber;
    private double amount;

    public Transfer(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }
}
