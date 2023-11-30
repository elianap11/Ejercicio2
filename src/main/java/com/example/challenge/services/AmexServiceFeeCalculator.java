package com.example.challenge.services;

import com.example.challenge.services.impl.ServiceFeeCalculator;

public class AmexServiceFeeCalculator implements ServiceFeeCalculator {
    @Override
    public double calculateServiceFee(int year, int month, int day) {
        return month * 0.1;
    }
}
