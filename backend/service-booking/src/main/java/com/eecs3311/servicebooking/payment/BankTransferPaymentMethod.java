package com.eecs3311.servicebooking.payment;

import java.util.Map;

public class BankTransferPaymentMethod implements PaymentMethod {
    @Override public String methodName() { return "BANK_TRANSFER"; }

    @Override
    public void validate(Map<String, String> payload) {
        String account = payload.getOrDefault("accountNumber", "");
        String routing = payload.getOrDefault("routingNumber", "");

        if (!account.matches("\\d{6,18}")) throw new IllegalArgumentException("accountNumber must be 6-18 digits");
        if (!routing.matches("\\d{5,12}")) throw new IllegalArgumentException("routingNumber must be 5-12 digits");
    }

    @Override
    public boolean process(double amount) {
        return amount > 0;
    }
}
