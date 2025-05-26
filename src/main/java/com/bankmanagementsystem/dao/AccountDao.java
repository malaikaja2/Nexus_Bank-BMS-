package com.bankmanagementsystem.dao;

import com.bankmanagementsystem.model.Account;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    private List<Account> accountList = new ArrayList<>();

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public List<Account> getAllAccounts() {
        return accountList;
    }
}
