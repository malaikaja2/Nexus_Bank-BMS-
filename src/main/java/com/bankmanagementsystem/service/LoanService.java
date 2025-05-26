package com.bankmanagementsystem.service;

import com.bankmanagementsystem.dao.LoanDAO;
import com.bankmanagementsystem.model.Loan;

public class LoanService {
    private LoanDAO loanDAO = new LoanDAO();

    public void applyForLoan(Loan loan) throws Exception {
        if (loan.getLoanId().isEmpty() || loan.getCustomerId().isEmpty()) {
            throw new Exception("Loan ID and Customer ID cannot be empty.");
        }
        loanDAO.saveLoan(loan);
    }
}
