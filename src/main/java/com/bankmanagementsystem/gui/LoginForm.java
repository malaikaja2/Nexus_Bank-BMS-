package com.bankmanagementsystem.gui;

import com.bankmanagementsystem.model.User;
import com.bankmanagementsystem.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerLink;
    private JButton homeLink;
    private UserService userService;

    public LoginForm() {
        userService = new UserService();

        setTitle("Nexus Bank - Login");
        setSize(420, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Background
        setContentPane(new JLabel(new ImageIcon("src/com/nexusbank/presentation/NexusBank.jpeg")));
        setLayout(new GridBagLayout());

        // Overlay
        JPanel overlay = new JPanel();
        overlay.setBackground(new Color(0, 128, 128, 180));
        overlay.setPreferredSize(new Dimension(360, 460));
        overlay.setLayout(new BoxLayout(overlay, BoxLayout.Y_AXIS));
        overlay.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Header
        JLabel titleLabel = new JLabel("Nexus Bank", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        overlay.add(titleLabel);

        JLabel tagline = new JLabel("Secure Login to Your Account", SwingConstants.CENTER);
        tagline.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        tagline.setForeground(new Color(224, 247, 250));
        overlay.add(Box.createVerticalStrut(10));
        overlay.add(tagline);
        overlay.add(Box.createVerticalStrut(20));

        // Form panel
        JPanel form = new JPanel();
        form.setOpaque(false);
        form.setLayout(new GridLayout(0, 1, 10, 10));

        form.add(new JLabel("Username:"));
        usernameField = new JTextField();
        form.add(usernameField);

        form.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        form.add(passwordField);

        overlay.add(form);
        overlay.add(Box.createVerticalStrut(20));

        // Login button
        loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setPreferredSize(new Dimension(120, 40));
        loginButton.setMaximumSize(new Dimension(200, 50));
        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(new Color(0, 128, 128));
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(e -> loginUser());
        overlay.add(loginButton);

        overlay.add(Box.createVerticalStrut(20));

        // Extra links
        registerLink = new JButton("New to Nexus Bank? Register Here");
        styleLinkButton(registerLink);
        registerLink.addActionListener(e -> {
            dispose();
            new RegisterForm().setVisible(true);
        });
        overlay.add(registerLink);

        homeLink = new JButton("Back to Home");
        styleLinkButton(homeLink);
        homeLink.addActionListener(e -> {
            // implement navigation to home if you have one, else:
            JOptionPane.showMessageDialog(this, "Go to home screen");
        });
        overlay.add(homeLink);

        add(overlay);
        setVisible(true);
    }

    private void loginUser() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both username and password", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        User user = userService.loginUser(username, password);
        if (user != null) {
            JOptionPane.showMessageDialog(this, "Login successful! Welcome " + user.getFullName(), "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new Dashboard(user).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Failed",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void styleLinkButton(JButton btn) {
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setForeground(new Color(224, 247, 250));
        btn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginForm());
    }
}
