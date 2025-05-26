package com.bankmanagementsystem.model;

public class Loan {
    private String loanId;
    private String customerId;
    private double amount;
    private double interestRate;
    private String startDate;
    private String endDate;
    private String loanType;

    public Loan(String loanId, String customerId, double amount, double interestRate,
                String startDate, String endDate, String loanType) {
        this.loanId = loanId;
        this.customerId = customerId;
        this.amount = amount;
        this.interestRate = interestRate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.loanType = loanType;
    }

    public String getLoanId() { return loanId; }
    public String getCustomerId() { return customerId; }
    public double getAmount() { return amount; }
    public double getInterestRate() { return interestRate; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public String getLoanType() { return loanType; }

    @Override
    public String toString() {
        return String.format("Loan[loanId=%s, customerId=%s, amount=%.2f, interestRate=%.2f, start=%s, end=%s, type=%s]",
                loanId, customerId, amount, interestRate, startDate, endDate, loanType);
    }
}
