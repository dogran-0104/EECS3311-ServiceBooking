package com.eecs3311.servicebooking.payment;

import java.util.Map;

public class PaypalPaymentMethod implements PaymentMethod {
    @Override public String methodName() { return "PAYPAL"; }

    @Override
    public void validate(Map<String, String> payload) {
        String email = payload.getOrDefault("email", "");
        if (!email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new IllegalArgumentException("email is invalid");
        }
    }

    @Override
    public boolean process(double amount) {
        return amount > 0;
    }
}
