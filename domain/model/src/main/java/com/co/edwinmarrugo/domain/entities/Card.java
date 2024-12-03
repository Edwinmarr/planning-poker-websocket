package com.co.edwinmarrugo.domain.entities;

import com.co.edwinmarrugo.domain.enums.CardValue;

public class Card {
    private CardValue value;
    private String userId;

    public Card(CardValue value, String userId) {
        this.value = value;
        this.userId = userId;
    }

    // Getters y Setters
    public CardValue getValue() {
        return value;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
