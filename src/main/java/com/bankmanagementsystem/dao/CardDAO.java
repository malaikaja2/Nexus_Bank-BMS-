package com.bankmanagementsystem.dao;

import com.bankmanagementsystem.model.Card;
import java.sql.*;

public class CardDAO {
    public boolean saveCard(Card card) {
        boolean inserted = false;

        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO cards (cardId, cardType, cardNumber, customerId, expiryDate, limit) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, card.getCardId());
            ps.setString(2, card.getCardType());
            ps.setString(3, card.getCardNumber());
            ps.setString(4, card.getCustomerId());
            ps.setDate(5, new java.sql.Date(card.getExpiryDate().getTime()));
            ps.setDouble(6, card.getLimit());

            inserted = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inserted;
    }
}
