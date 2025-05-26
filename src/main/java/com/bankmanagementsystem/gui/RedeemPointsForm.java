package com.bankmanagementsystem.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RedeemPointsForm extends JFrame {
    private int availablePoints = 2500;  // example static points
    private JLabel pointsInfoLabel;
    private JTextField pointsField;
    private JButton redeemButton;
    private JButton backButton;

    public RedeemPointsForm() {
        setTitle("Nexus Bank - Redeem Points");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Background panel with teal gradient
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
        backgroundPanel.setLayout(new GridBagLayout());
        add(backgroundPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Title label
        JLabel titleLabel = new JLabel("Redeem Points", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridwidth = 2;
        backgroundPanel.add(titleLabel, gbc);

        // Points info label
        pointsInfoLabel = new JLabel("You have " + availablePoints + " points available.", SwingConstants.CENTER);
        pointsInfoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        pointsInfoLabel.setForeground(Color.WHITE);
        gbc.gridy++;
        backgroundPanel.add(pointsInfoLabel, gbc);

        // Label for input
        JLabel enterPointsLabel = new JLabel("Enter points to redeem:");
        enterPointsLabel.setForeground(Color.WHITE);
        enterPointsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        gbc.gridy++;
        gbc.gridwidth = 1;
        backgroundPanel.add(enterPointsLabel, gbc);

        // Input text field
        pointsField = new JTextField();
        gbc.gridx = 1;
        backgroundPanel.add(pointsField, gbc);

        // Redeem button
        redeemButton = new JButton("Redeem");
        redeemButton.setBackground(Color.WHITE);
        redeemButton.setForeground(new Color(0, 128, 128));
        redeemButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        redeemButton.setFocusPainted(false);
        redeemButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        backgroundPanel.add(redeemButton, gbc);

        // Back to Dashboard button
        backButton = new JButton("Back to Dashboard");
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(new Color(0, 128, 128));
        backButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        backButton.setFocusPainted(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridy++;
        backgroundPanel.add(backButton, gbc);

        // Button actions
        redeemButton.addActionListener(e -> redeemPoints());
        backButton.addActionListener(e -> {
            new Dashboard().setVisible(true);
            this.dispose();
        });
    }

    private void redeemPoints() {
        String input = pointsField.getText().trim();
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter points to redeem.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int pointsToRedeem;
        try {
            pointsToRedeem = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (pointsToRedeem < 1 || pointsToRedeem > availablePoints) {
            JOptionPane.showMessageDialog(this, "Enter points between 1 and " + availablePoints + ".", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // For demo, just show success and reduce points
        availablePoints -= pointsToRedeem;
        pointsInfoLabel.setText("You have " + availablePoints + " points available.");
        JOptionPane.showMessageDialog(this, "Congratulations! You have successfully redeemed your points.", "Success", JOptionPane.INFORMATION_MESSAGE);
        pointsField.setText("");
    }

    // For quick testing standalone
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RedeemPointsForm().setVisible(true);
        });
    }
}
