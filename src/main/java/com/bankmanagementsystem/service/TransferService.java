package com.bankmanagementsystem.service;

import com.bankmanagementsystem.model.Transfer;

public class TransferService {
    // Simulate transfer processing
    public boolean processTransfer(Transfer transfer) {
        // Add your validation or database logic here
        // For simplicity, assume any positive amount and valid account number is successful
        if (transfer.getAccountNumber() == null || transfer.getAccountNumber().isEmpty()) {
            return false;
        }
        return transfer.getAmount() > 0;
    }
}
