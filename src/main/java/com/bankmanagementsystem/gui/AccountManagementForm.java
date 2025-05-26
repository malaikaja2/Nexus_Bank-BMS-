package com.bankmanagementsystem.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountManagementForm extends JFrame {

    public AccountManagementForm() {
        setTitle("Account Management - Nexus Bank");
        setSize(600, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Background panel with teal gradient (same as Dashboard)
        JPanel backgroundPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(0, 128, 128, 180);
                Color color2 = new Color(0, 128, 128, 180);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        backgroundPanel.setLayout(new BorderLayout(0, 20));
        setContentPane(backgroundPanel);

        // Title label
        JLabel titleLabel = new JLabel("Account Management", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        backgroundPanel.add(titleLabel, BorderLayout.NORTH);

        // Form panel with GridBagLayout
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Labels and fields
        String[] labels = {
                "Customer ID:", "Account Type:", "Balance:",
                "Branch ID:", "Monthly Deposit:", "Date Opened:"
        };

        JTextField customerIdField = new JTextField(20);

        JComboBox<String> accountTypeCombo = new JComboBox<>(new String[]{"Savings", "Current", "Joint"});

        JTextField balanceField = new JTextField(20);

        JTextField branchIdField = new JTextField(20);

        JTextField monthlyDepositField = new JTextField(20);

        JTextField dateOpenedField = new JTextField(20);
        dateOpenedField.setToolTipText("Enter date as YYYY-MM-DD");

        // Add components row by row
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(new JLabel(labels[0]), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(customerIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(new JLabel(labels[1]), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(accountTypeCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(new JLabel(labels[2]), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(balanceField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(new JLabel(labels[3]), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(branchIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(new JLabel(labels[4]), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(monthlyDepositField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(new JLabel(labels[5]), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(dateOpenedField, gbc);

        backgroundPanel.add(formPanel, BorderLayout.CENTER);

        // Buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);

        JButton createButton = new JButton("Create Account");
        createButton.setBackground(Color.WHITE);
        createButton.setForeground(new Color(0, 128, 128));
        createButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        createButton.setFocusPainted(false);

        JButton backButton = new JButton("Back to Dashboard");
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(new Color(0, 128, 128));
        backButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        backButton.setFocusPainted(false);

        buttonsPanel.add(createButton);
        buttonsPanel.add(backButton);

        backgroundPanel.add(buttonsPanel, BorderLayout.SOUTH);

        // Action listeners
        createButton.addActionListener(e -> {
            // TODO: Add your account creation logic here (validation, DB save, etc.)
            JOptionPane.showMessageDialog(this,
                    "Account Created Successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        backButton.addActionListener(e -> {
            // Open dashboard and close this form
            Dashboard dashboard = new Dashboard();
            dashboard.setVisible(true);
            this.dispose();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AccountManagementForm::new);
    }
}
