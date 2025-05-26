package com.bankmanagementsystem.model;

import java.util.Date;

public class Card {
    private String cardId;
    private String cardType;
    private String cardNumber;
    private String customerId;
    private Date expiryDate;
    private double limit;

    // Getters and Setters
    public String getCardId() { return cardId; }
    public void setCardId(String cardId) { this.cardId = cardId; }

    public String getCardType() { return cardType; }
    public void setCardType(String cardType) { this.cardType = cardType; }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public Date getExpiryDate() { return expiryDate; }
    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate; }

    public double getLimit() { return limit; }
    public void setLimit(double limit) { this.limit = limit; }
}
