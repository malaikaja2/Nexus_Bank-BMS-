package com.bankmanagementsystem.gui;

import com.bankmanagementsystem.model.Transfer;
import com.bankmanagementsystem.service.TransferService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TransferForm extends JFrame {
    private JTextField accountField;
    private JTextField amountField;
    private JLabel successMessage;
    private TransferService transferService;

    public TransferForm() {
        transferService = new TransferService();

        setTitle("Nexus Bank - Transfer Money");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header panel with teal background and white bold title
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 128, 128));
        JLabel headerLabel = new JLabel("Transfer Money");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        formPanel.setBackground(new Color(0, 128, 128));

        // Account label and field
        JLabel accountLabel = new JLabel("Recipient's Account Number:");
        styleLabel(accountLabel);
        accountField = new JTextField();
        styleTextField(accountField);

        // Amount label and field
        JLabel amountLabel = new JLabel("Amount:");
        styleLabel(amountLabel);
        amountField = new JTextField();
        styleTextField(amountField);

        // Transfer button
        JButton transferButton = new JButton("Transfer");
        styleButton(transferButton);

        // Success message label
        successMessage = new JLabel("Transfer successful!", SwingConstants.CENTER);
        successMessage.setForeground(Color.WHITE);
        successMessage.setFont(new Font("Times New Roman", Font.BOLD, 16));
        successMessage.setVisible(false);

        // Back button
        JButton backButton = new JButton("Back to Dashboard");
        styleButton(backButton);

        // Add components to form panel
        formPanel.add(accountLabel);
        formPanel.add(accountField);
        formPanel.add(amountLabel);
        formPanel.add(amountField);
        formPanel.add(transferButton);

        add(formPanel, BorderLayout.CENTER);
        add(successMessage, BorderLayout.SOUTH);
        add(backButton, BorderLayout.PAGE_END);

        // Button actions
        transferButton.addActionListener(this::handleTransfer);
        backButton.addActionListener(e -> {
            dispose();
            new DashboardForm().setVisible(true);
        });
    }

    private void styleLabel(JLabel label) {
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Times New Roman", Font.BOLD, 16));
    }

    private void styleTextField(JTextField field) {
        field.setBackground(Color.WHITE);
        field.setForeground(Color.BLACK);
        field.setCaretColor(Color.BLACK);
        field.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        field.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 128)));
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(0, 128, 128));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Times New Roman", Font.BOLD, 16));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void handleTransfer(ActionEvent e) {
        String account = accountField.getText().trim();
        String amountText = amountField.getText().trim();

        if (account.isEmpty() || amountText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountText);
            if (amount <= 0) {
                JOptionPane.showMessageDialog(this, "Amount must be positive.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid number for amount.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Transfer transfer = new Transfer(account, amount);

        boolean success = transferService.processTransfer(transfer);
        if (success) {
            successMessage.setVisible(true);
            accountField.setText("");
            amountField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Transfer failed. Check details and try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
