package com.bankmanagementsystem.service;

import com.bankmanagementsystem.dao.AccountDao;
import com.bankmanagementsystem.model.Account;

public class AccountService {
    private AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void createAccount(Account account) {
        // Business logic: e.g. validate balance
        if (account.getBalance() < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        accountDao.addAccount(account);
    }
}
