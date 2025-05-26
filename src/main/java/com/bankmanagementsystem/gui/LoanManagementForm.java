package com.bankmanagementsystem.gui;

import javax.swing.*;
import java.awt.*;

public class LoanManagementForm extends JFrame {
    public LoanManagementForm() {
        setTitle("Loan Management");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(0, 128, 128)); // Dark background
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Loan Management", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 15, 15));
        formPanel.setBackground(new Color(30, 30, 30));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40)); // slightly more padding

        JLabel lbl1 = new JLabel("Loan Amount:");
        JLabel lbl2 = new JLabel("Loan Term (months):");
        JLabel lbl3 = new JLabel("Interest Rate (%):");
        JLabel lbl4 = new JLabel("Monthly Installment:");

        JTextField loanAmountField = new JTextField();
        JTextField loanTermField = new JTextField();
        JTextField interestRateField = new JTextField("5");
        JLabel resultLabel = new JLabel("0");

        // Style labels (including resultLabel)
        for (JLabel lbl : new JLabel[]{lbl1, lbl2, lbl3, lbl4, resultLabel}) {
            lbl.setForeground(Color.WHITE);
        }

        // Style text fields with teal borders and dark backgrounds
        JTextField[] fields = {loanAmountField, loanTermField, interestRateField};
        for (JTextField field : fields) {
            field.setBackground(new Color(60, 60, 60));
            field.setForeground(Color.WHITE);
            field.setCaretColor(Color.WHITE);
            field.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 128))); // teal border
        }

        formPanel.add(lbl1); formPanel.add(loanAmountField);
        formPanel.add(lbl2); formPanel.add(loanTermField);
        formPanel.add(lbl3); formPanel.add(interestRateField);
        formPanel.add(lbl4); formPanel.add(resultLabel);

        JButton calculateBtn = new JButton("Calculate");
        JButton submitBtn = new JButton("Submit");

        // Style buttons with teal background and white text
        for (JButton btn : new JButton[]{calculateBtn, submitBtn}) {
            btn.setBackground(new Color(0, 128, 128)); // teal color
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
        }

        formPanel.add(calculateBtn);
        formPanel.add(submitBtn);

        add(formPanel, BorderLayout.CENTER);

        // Calculate monthly installment action
        calculateBtn.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(loanAmountField.getText());
                int months = Integer.parseInt(loanTermField.getText());
                double interestRate = Double.parseDouble(interestRateField.getText()) / 100;
                double monthlyInterest = interestRate / 12;
                double monthlyPayment = (amount * monthlyInterest) / (1 - Math.pow(1 + monthlyInterest, -months));
                resultLabel.setText(String.format("%.2f", monthlyPayment));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Submit action
        submitBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Loan application submitted!");
            loanAmountField.setText("");
            loanTermField.setText("");
            interestRateField.setText("5");
            resultLabel.setText("0");
        });
    }
}
