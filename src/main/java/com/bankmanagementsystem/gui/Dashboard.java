package com.bankmanagementsystem.gui;

import com.bankmanagementsystem.model.User;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    private User user;

    public Dashboard() {
        this(null);
    }

    public Dashboard(User user) {
        this.user = user;

        setTitle("Nexus Bank - Dashboard");
        setSize(600, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        backgroundPanel.setLayout(new BorderLayout());
        setContentPane(backgroundPanel);

        JLabel title = new JLabel("Welcome to Nexus Bank Dashboard", SwingConstants.CENTER);
        title.setFont(new Font("Times New Roman", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        backgroundPanel.add(title, BorderLayout.NORTH);

        JLabel tagline = new JLabel("Manage all your financial needs in one place", SwingConstants.CENTER);
        tagline.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        tagline.setForeground(Color.WHITE);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new GridLayout(0, 1, 10, 10));

        String[] buttons = {
                "Customer Profile",
                "Account Management",
                "Loan Management",
                "Card Management",
                "Redeem Points",
                "Transfer Money",
                "Logout"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setBackground(Color.WHITE);
            btn.setForeground(new Color(0, 128, 128));
            btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            buttonPanel.add(btn);

            if (text.equals("Customer Profile")) {
                btn.addActionListener(e -> {
                    CustomerProfileForm cpf = new CustomerProfileForm();
                    cpf.setVisible(true);
                    this.setVisible(false);
                });
            }

            if (text.equals("Account Management")) {
                btn.addActionListener(e -> {
                    AccountManagementForm amf = new AccountManagementForm();
                    amf.setVisible(true);
                    this.setVisible(false);
                });
            }

            if (text.equals("Loan Management")) {
                btn.addActionListener(e -> {
                    LoanManagementForm lmf = new LoanManagementForm();
                    lmf.setVisible(true);
                    this.setVisible(false);
                });
            }

            if (text.equals("Redeem Points")) {
                btn.addActionListener(e -> {
                    RedeemPointsForm rpf = new RedeemPointsForm(this);
                    rpf.setVisible(true);
                    this.setVisible(false);
                });
            }

            if (text.equals("Transfer Money")) {
                btn.addActionListener(e -> {
                    TransferMoneyForm tmf = new TransferMoneyForm(this);
                    tmf.setVisible(true);
                    this.setVisible(false);
                });
            }
if (text.equals("Card Management")) {
    btn.addActionListener(e -> {
        CardForm cmf = new CardForm();
        cmf.setVisible(true);
        this.setVisible(false);
    });
}

            if (text.equals("Logout")) {
                btn.addActionListener(e -> {
                    JOptionPane.showMessageDialog(this, "You have been logged out.");
                    new LoginForm().setVisible(true);
                    dispose();
                });
            }
        }

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setOpaque(false);
        centerPanel.add(tagline, BorderLayout.NORTH);
        centerPanel.add(buttonPanel, BorderLayout.CENTER);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 80, 20, 80));
        backgroundPanel.add(centerPanel, BorderLayout.CENTER);

        JLabel footer = new JLabel(
                "<html><center>&copy; 2024 Nexus Bank. All Rights Reserved.<br>Contact: support@nexusbank.com | +1 234 567 890</center></html>",
                SwingConstants.CENTER);
        footer.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        footer.setForeground(Color.WHITE);
        footer.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        backgroundPanel.add(footer, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static class RedeemPointsForm extends JFrame {

        private final Dashboard dashboard;
        private int availablePoints = 2500;

        public RedeemPointsForm(Dashboard dashboard) {
            this.dashboard = dashboard;

            setTitle("Nexus Bank - Redeem Points");
            setSize(450, 350);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

            JLabel titleLabel = new JLabel("Redeem Points", SwingConstants.CENTER);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel pointsInfo = new JLabel("You have " + availablePoints + " points available.");
            pointsInfo.setFont(new Font("Arial", Font.PLAIN, 16));
            pointsInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
            pointsInfo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

            JLabel enterLabel = new JLabel("Enter points to redeem:");
            enterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JTextField pointsField = new JTextField();
            pointsField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

            JButton redeemBtn = new JButton("Redeem");
            redeemBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
            redeemBtn.setBackground(new Color(0, 128, 128));
            redeemBtn.setForeground(Color.WHITE);
            redeemBtn.setFocusPainted(false);

            JButton backBtn = new JButton("Back to Dashboard");
            backBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
            backBtn.setBackground(new Color(0, 128, 128));
            backBtn.setForeground(Color.WHITE);
            backBtn.setFocusPainted(false);

            panel.add(titleLabel);
            panel.add(pointsInfo);
            panel.add(enterLabel);
            panel.add(pointsField);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(redeemBtn);
            panel.add(Box.createRigidArea(new Dimension(0, 15)));
            panel.add(backBtn);

            add(panel);

            redeemBtn.addActionListener(e -> {
                String input = pointsField.getText().trim();
                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter points to redeem.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int pointsToRedeem;
                try {
                    pointsToRedeem = Integer.parseInt(input);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (pointsToRedeem <= 0) {
                    JOptionPane.showMessageDialog(this, "Points must be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (pointsToRedeem > availablePoints) {
                    JOptionPane.showMessageDialog(this, "You cannot redeem more points than you have.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                availablePoints -= pointsToRedeem;
                JOptionPane.showMessageDialog(this, "Successfully redeemed " + pointsToRedeem + " points!");
                pointsInfo.setText("You have " + availablePoints + " points available.");
                pointsField.setText("");
            });

            backBtn.addActionListener(e -> {
                this.dispose();
                dashboard.setVisible(true);
            });
        }
    }

    public static class TransferMoneyForm extends JFrame {
        private final Dashboard dashboard;

        public TransferMoneyForm(Dashboard dashboard) {
            this.dashboard = dashboard;

            setTitle("Nexus Bank - Transfer Money");
            setSize(450, 350);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

            JLabel titleLabel = new JLabel("Transfer Money", SwingConstants.CENTER);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel accountLabel = new JLabel("Recipient Account Number:");
            accountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JTextField accountField = new JTextField();
            accountField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

            JLabel amountLabel = new JLabel("Amount to Transfer:");
            amountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JTextField amountField = new JTextField();
            amountField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

            JButton transferBtn = new JButton("Transfer");
            transferBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
            transferBtn.setBackground(new Color(0, 128, 128));
            transferBtn.setForeground(Color.WHITE);
            transferBtn.setFocusPainted(false);

            JButton backBtn = new JButton("Back to Dashboard");
            backBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
            backBtn.setBackground(new Color(0, 128, 128));
            backBtn.setForeground(Color.WHITE);
            backBtn.setFocusPainted(false);

            panel.add(titleLabel);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(accountLabel);
            panel.add(accountField);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(amountLabel);
            panel.add(amountField);
            panel.add(Box.createRigidArea(new Dimension(0, 15)));
            panel.add(transferBtn);
            panel.add(Box.createRigidArea(new Dimension(0, 15)));
            panel.add(backBtn);

            add(panel);

            transferBtn.addActionListener(e -> {
                String account = accountField.getText().trim();
                String amountStr = amountField.getText().trim();

                if (account.isEmpty() || amountStr.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double amount;
                try {
                    amount = Double.parseDouble(amountStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (amount <= 0) {
                    JOptionPane.showMessageDialog(this, "Amount must be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Here you would add actual transfer logic (e.g., database update)
                JOptionPane.showMessageDialog(this, "Transferred $" + amount + " to account " + account + " successfully!");

                accountField.setText("");
                amountField.setText("");
            });

            backBtn.addActionListener(e -> {
                this.dispose();
                dashboard.setVisible(true);
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Dashboard::new);
    }
}
