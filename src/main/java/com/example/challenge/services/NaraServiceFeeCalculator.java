package com.example.challenge.services;

import com.example.challenge.services.impl.ServiceFeeCalculator;

public class NaraServiceFeeCalculator implements ServiceFeeCalculator {
    @Override
    public double calculateServiceFee(int year, int month, int day) {
        return day * 0.5;
    }
}
