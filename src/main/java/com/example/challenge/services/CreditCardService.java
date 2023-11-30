package com.example.challenge.services;

import com.example.challenge.entities.CreditCard;
import com.example.challenge.repositories.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    public List<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }

    public void createCreditCard(CreditCard creditCard) {
        creditCardRepository.save(creditCard);
    }





}
