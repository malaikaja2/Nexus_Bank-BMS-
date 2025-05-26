package com.bankmanagementsystem.gui;
import com.bankmanagementsystem.service.CustomerProfileService;
import com.bankmanagementsystem.model.CustomerProfile;


import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CustomerProfileForm extends JFrame {
    private JTextField customerIdField;
    private JTextField fullNameField;
    private JTextField addressField;
    private JTextField phoneNoField;
    private JTextField emailField;
    private JTextField dobField; // For simplicity, use text field with format YYYY-MM-DD

    private CustomerProfileService service;

    public CustomerProfileForm() {
        service = new CustomerProfileService();

        setTitle("Customer Profile - Nexus Bank");
        setSize(450, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(0, 128, 128, 180));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Labels and Fields
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Customer ID:"), gbc);
        gbc.gridx = 1;
        customerIdField = new JTextField(20);
        panel.add(customerIdField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Full Name:"), gbc);
        gbc.gridx = 1;
        fullNameField = new JTextField(20);
        panel.add(fullNameField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Address:"), gbc);
        gbc.gridx = 1;
        addressField = new JTextField(20);
        panel.add(addressField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Phone Number:"), gbc);
        gbc.gridx = 1;
        phoneNoField = new JTextField(20);
        panel.add(phoneNoField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        emailField = new JTextField(20);
        panel.add(emailField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Date of Birth (YYYY-MM-DD):"), gbc);
        gbc.gridx = 1;
        dobField = new JTextField(20);
        panel.add(dobField, gbc);

        // Submit Button
        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 2;
        JButton submitBtn = new JButton("Create Profile");
        submitBtn.setBackground(Color.WHITE);
        submitBtn.setForeground(new Color(0, 128, 128));
        submitBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
        panel.add(submitBtn, gbc);

        add(panel);

        submitBtn.addActionListener(e -> onSubmit());
    }

    private void onSubmit() {
        // Simple validation & data reading
        String customerId = customerIdField.getText().trim();
        String fullName = fullNameField.getText().trim();
        String address = addressField.getText().trim();
        String phoneNo = phoneNoField.getText().trim();
        String email = emailField.getText().trim();
        String dobText = dobField.getText().trim();

        if (customerId.isEmpty() || fullName.isEmpty() || address.isEmpty() || phoneNo.isEmpty() || email.isEmpty() || dobText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate date format
        LocalDate dob;
        try {
            dob = LocalDate.parse(dobText);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Date of Birth must be in format YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate phone number (simple digit check)
        if (!phoneNo.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Phone number must contain only digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create CustomerProfile object
        CustomerProfile profile = new CustomerProfile(customerId, fullName, address, phoneNo, email, dob);

        // Save profile through service layer
        service.createProfile(profile);

        // Show success dialog
        JOptionPane.showMessageDialog(this, "Profile Created Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        // Clear form
        customerIdField.setText("");
        fullNameField.setText("");
        addressField.setText("");
        phoneNoField.setText("");
        emailField.setText("");
        dobField.setText("");
    }
}
