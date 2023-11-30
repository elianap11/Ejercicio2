package com.example.challenge.entities;

import com.example.challenge.enums.CreditCardBrand;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "brand")
    private CreditCardBrand creditCardBrand;

    @Column(name = "number")
    private Long creditCardNumber;

    @Column(name = "name")
    private String cardHolder;

    @Column(name = "date")
    private LocalDate expirationDate;

    public CreditCard() {
    }

    public CreditCard(Long id, CreditCardBrand creditCardBrand, Long creditCardNumber, String cardHolder, LocalDate expirationDate) {
        this.id = id;
        this.creditCardBrand = creditCardBrand;
        this.creditCardNumber = creditCardNumber;
        this.cardHolder = cardHolder;
        this.expirationDate = expirationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CreditCardBrand getCreditCardBrand() {
        return creditCardBrand;
    }

    public void setCreditCardBrand(CreditCardBrand creditCardBrand) {
        this.creditCardBrand = creditCardBrand;
    }

    public Long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(Long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
