package com.example.challenge.entities;

import com.example.challenge.entities.CreditCard;

import java.time.LocalDate;

public class CreditCardOperation {

    private CreditCard creditCard;
    private double amount;

    public CreditCardOperation() {
    }

    public CreditCardOperation(CreditCard creditCard, double amount) {
        this.creditCard = creditCard;
        this.amount = amount;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isValidOperation() {
        return amount < 1000 && creditCard.getExpirationDate().isAfter(LocalDate.now());
    }
}
