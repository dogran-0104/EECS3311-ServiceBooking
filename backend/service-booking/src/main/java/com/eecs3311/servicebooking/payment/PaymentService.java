package com.eecs3311.servicebooking.payment;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PaymentService {

    private final PaymentFactory paymentFactory;
    private final List<PaymentRecord> payments = new ArrayList<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public PaymentService(PaymentFactory paymentFactory) {
        this.paymentFactory = paymentFactory;
    }

    public PaymentRecord pay(long bookingId, double amount, String methodType) {
        PaymentMethod method = paymentFactory.create(methodType);

        boolean ok = method.process(amount);

        PaymentRecord record = new PaymentRecord(
                idGen.getAndIncrement(),
                bookingId,
                amount,
                methodType == null ? null : methodType.toUpperCase(),
                ok ? "PAID" : "FAILED",
                LocalDateTime.now()
        );

        payments.add(record);
        return record;
    }

    public List<PaymentRecord> listAll() {
        return payments;
    }

    public List<PaymentRecord> listByBookingId(long bookingId) {
        List<PaymentRecord> out = new ArrayList<>();
        for (PaymentRecord r : payments) {
            if (r.getBookingId() != null && r.getBookingId() == bookingId) {
                out.add(r);
            }
        }
        return out;
    }
}
