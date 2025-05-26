package com.bankmanagementsystem.service;

import com.bankmanagementsystem.dao.CardDAO;
import com.bankmanagementsystem.model.Card;

public class CardService {
    private CardDAO dao = new CardDAO();

    public boolean createCard(Card card) {
        // Optional: validate card info
        return dao.saveCard(card);
    }
}
