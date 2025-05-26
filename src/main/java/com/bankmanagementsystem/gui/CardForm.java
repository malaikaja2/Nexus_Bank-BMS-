package com.bankmanagementsystem.gui;

import com.bankmanagementsystem.model.Card;
import com.bankmanagementsystem.service.CardService;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CardForm extends JFrame {
    private JTextField cardIdField, cardTypeField, cardNumberField, customerIdField, expiryDateField, limitField;
    private JButton saveButton, dashboardButton;
    private CardService cardService;

    public CardForm() {
        setTitle("Nexus Bank - Card Entry");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        cardService = new CardService();

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 128, 128));
        JLabel titleLabel = new JLabel("Nexus Bank");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        formPanel.setBackground(new Color(0, 128, 128));

        // Form fields
        formPanel.add(createStyledLabel("Card ID:"));
        cardIdField = new JTextField();
        formPanel.add(cardIdField);

        formPanel.add(createStyledLabel("Card Type:"));
        cardTypeField = new JTextField();
        formPanel.add(cardTypeField);

        formPanel.add(createStyledLabel("Card Number:"));
        cardNumberField = new JTextField();
        formPanel.add(cardNumberField);

        formPanel.add(createStyledLabel("Customer ID:"));
        customerIdField = new JTextField();
        formPanel.add(customerIdField);

        formPanel.add(createStyledLabel("Expiry Date (yyyy-MM-dd):"));
        expiryDateField = new JTextField();
        formPanel.add(expiryDateField);

        formPanel.add(createStyledLabel("Limit:"));
        limitField = new JTextField();
        formPanel.add(limitField);

        // Buttons
        saveButton = new JButton("Save Card");
        dashboardButton = new JButton("Back to Dashboard");
        formPanel.add(saveButton);
        formPanel.add(dashboardButton);

        add(formPanel, BorderLayout.CENTER);

        // Button actions
        saveButton.addActionListener(e -> saveCard());
        dashboardButton.addActionListener(e -> {
            dispose();  // Close current window
            new Dashboard().setVisible(true);  // Open dashboard
        });
    }

    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("SansSerif", Font.PLAIN, 14));
        return label;
    }

    private void saveCard() {
        try {
            Card card = new Card();
            card.setCardId(cardIdField.getText());
            card.setCardType(cardTypeField.getText());
            card.setCardNumber(cardNumberField.getText());
            card.setCustomerId(customerIdField.getText());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(expiryDateField.getText());
            card.setExpiryDate(date);

            card.setLimit(Double.parseDouble(limitField.getText()));

            boolean success = cardService.createCard(card);

            if (success) {
                JOptionPane.showMessageDialog(this, "Card saved successfully!");
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save card.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Invalid input: " + ex.getMessage());
        }
    }

    private void clearFields() {
        cardIdField.setText("");
        cardTypeField.setText("");
        cardNumberField.setText("");
        customerIdField.setText("");
        expiryDateField.setText("");
        limitField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CardForm form = new CardForm();
            form.setVisible(true);
        });
    }
}
