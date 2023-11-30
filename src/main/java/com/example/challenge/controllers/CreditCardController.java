package com.example.challenge.controllers;

import com.example.challenge.entities.CreditCard;
import com.example.challenge.entities.CreditCardOperation;
import com.example.challenge.enums.CreditCardBrand;
import com.example.challenge.services.*;
import com.example.challenge.services.impl.ServiceFeeCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @GetMapping
    public ResponseEntity<List<CreditCard>> getAllCreditCards() {
        List<CreditCard> creditCard = creditCardService.getAllCreditCards();
        return ResponseEntity.ok(creditCard);
    }

    @PostMapping
    public ResponseEntity<CreditCard> saveCreditCards(@RequestBody CreditCard creditCard) {
        if (creditCard == null) {
            return ResponseEntity.badRequest().build();
        }

        creditCardService.createCreditCard(creditCard);
        return ResponseEntity.ok(creditCard);
    }


    @PostMapping("/processoperation")
    public String processCreditCardOperation(@RequestBody CreditCardOperation operation) {
        if (operation.isValidOperation()) {
            ServiceFeeCalculator calculator = getServiceFeeCalculator(operation.getCreditCard().getCreditCardBrand());
            double serviceFee = calculator.calculateServiceFee(
                    LocalDate.now().getYear(),
                    LocalDate.now().getMonthValue(),
                    LocalDate.now().getDayOfMonth()
            );

            String formattedAmount = String.format("%.2f", operation.getAmount());
            String formattedServiceFee = String.format("%.2f", serviceFee);
            Double total = operation.getAmount() + serviceFee;

            return "Operación exitosa. Tarjeta: " + operation.getCreditCard().getCreditCardBrand() + ". Monto: " + operation.getAmount() + ". Tasa de servicio: " + serviceFee + ". Total: " + total;
        } else {
            return "Operación no válida. Verifique los criterios.";
        }
    }

    private ServiceFeeCalculator getServiceFeeCalculator(CreditCardBrand brand) {
        // Devolver la implementación adecuada de ServiceFeeCalculator según la marca de tarjeta
        switch (brand) {
            case VISA:
                return new VisaServiceFeeCalculator();
            case NARA:
                return new NaraServiceFeeCalculator();
            case AMEX:
                return new AmexServiceFeeCalculator();
            default:
                throw new IllegalArgumentException("Marca de tarjeta no válida: " + brand);
        }
    }
}

