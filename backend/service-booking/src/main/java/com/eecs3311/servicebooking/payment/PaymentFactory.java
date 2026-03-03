package com.eecs3311.servicebooking.payment;

import org.springframework.stereotype.Component;

@Component
public class PaymentFactory {

    public PaymentMethod create(String methodType) {
        if (methodType == null) {
            throw new IllegalArgumentException("payment methodType is required");
        }

        String t = methodType.trim().toUpperCase();

        return switch (t) {
            case "CREDIT_CARD", "CREDITCARD" -> new CreditCardPaymentMethod();
            case "DEBIT_CARD", "DEBITCARD" -> new DebitCardPaymentMethod();
            case "PAYPAL" -> new PaypalPaymentMethod();
            case "BANK_TRANSFER", "BANKTRANSFER" -> new BankTransferPaymentMethod();
            default -> throw new IllegalArgumentException("Unsupported payment method: " + methodType);
        };
    }
}
