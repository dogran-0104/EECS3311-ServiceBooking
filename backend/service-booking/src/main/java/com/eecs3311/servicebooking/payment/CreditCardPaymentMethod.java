package com.eecs3311.servicebooking.payment;

import java.util.Map;

public class CreditCardPaymentMethod implements PaymentMethod {
    @Override public String methodName() { return "CREDIT_CARD"; }

    @Override
    public void validate(Map<String, String> payload) {
        String card = payload.getOrDefault("cardNumber", "");
        String expiry = payload.getOrDefault("expiry", "");
        String cvv = payload.getOrDefault("cvv", "");

        if (!card.matches("\\d{16}")) throw new IllegalArgumentException("cardNumber must be 16 digits");
        if (!expiry.matches("\\d{4}-\\d{2}")) throw new IllegalArgumentException("expiry must be YYYY-MM");
        if (!cvv.matches("\\d{3,4}")) throw new IllegalArgumentException("cvv must be 3-4 digits");
    }

    @Override
    public boolean process(double amount) {
        return amount > 0; // Phase1：模拟成功
    }
}