package com.eecs3311.servicebooking.payment;

import java.util.Map;

public class DebitCardPaymentMethod implements PaymentMethod {
    @Override public String methodName() { return "DEBIT_CARD"; }

    @Override
    public void validate(Map<String, String> payload) {
        String card = payload.getOrDefault("cardNumber", "");
        String pin = payload.getOrDefault("pin", "");

        if (!card.matches("\\d{16}")) throw new IllegalArgumentException("cardNumber must be 16 digits");
        if (!pin.matches("\\d{4}")) throw new IllegalArgumentException("pin must be 4 digits");
    }

    @Override
    public boolean process(double amount) {
        return amount > 0;
    }
}
