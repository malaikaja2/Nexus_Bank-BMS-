package com.bankmanagementsystem.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import com.bankmanagementsystem.model.User;
import com.bankmanagementsystem.service.UserService;

public class RegisterForm extends JFrame {

    private JTextField fullnameField;
    private JTextField emailField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;

    private UserService userService;  // add service layer reference

    public RegisterForm() {
        setTitle("Nexus Bank - Register");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // center on screen
        setLayout(new BorderLayout());

        userService = new UserService();  // initialize the service

        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 128, 128));
        JLabel titleLabel = new JLabel("Nexus Bank");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(9, 1, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        formPanel.setBackground(new Color(0, 128, 128));

        // Full Name
        formPanel.add(new JLabel("Full Name:"));
        fullnameField = new JTextField();
        formPanel.add(fullnameField);

        // Email
        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        // Username
        formPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        formPanel.add(usernameField);

        // Password
        formPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        formPanel.add(passwordField);

        // Register button
        registerButton = new JButton("Register");
        formPanel.add(registerButton);

        add(formPanel, BorderLayout.CENTER);

        // Add button listener
        registerButton.addActionListener(this::registerUser);
    }

    private void registerUser(ActionEvent e) {
        String fullname = fullnameField.getText();
        String email = emailField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (fullname.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create User object
        User user = new User(fullname, email, username, password);

        // Call service layer to register user
        boolean success = userService.registerUser(user);

        if (success) {
            JOptionPane.showMessageDialog(this, "User registered successfully:\n" + fullname, "Success", JOptionPane.INFORMATION_MESSAGE);
            // Optionally clear fields or close form
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Registration failed. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        fullnameField.setText("");
        emailField.setText("");
        usernameField.setText("");
        passwordField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegisterForm form = new RegisterForm();
            form.setVisible(true);
        });
    }
}