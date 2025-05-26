package com.bankmanagementsystem.model;

import java.time.LocalDate;

public class Account {
    private String customerId;
    private String accountType;
    private double balance;
    private String branchId;
    private double monthlyDeposit;
    private LocalDate dateOpened;

    public Account(String customerId, String accountType, double balance, String branchId,
                   double monthlyDeposit, LocalDate dateOpened) {
        this.customerId = customerId;
        this.accountType = accountType;
        this.balance = balance;
        this.branchId = branchId;
        this.monthlyDeposit = monthlyDeposit;
        this.dateOpened = dateOpened;
    }

    public String getCustomerId() { return customerId; }
    public String getAccountType() { return accountType; }
    public double getBalance() { return balance; }
    public String getBranchId() { return branchId; }
    public double getMonthlyDeposit() { return monthlyDeposit; }
    public LocalDate getDateOpened() { return dateOpened; }
}
