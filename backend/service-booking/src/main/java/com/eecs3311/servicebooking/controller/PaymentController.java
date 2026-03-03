package com.eecs3311.servicebooking.controller;

import com.eecs3311.servicebooking.payment.PaymentRecord;
import com.eecs3311.servicebooking.payment.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // 1) 发起支付：POST /api/payments
    @PostMapping("/payments")
    public PaymentRecord pay(@RequestBody PayRequest req) {
        // 你现在的 PaymentService.pay 是 (bookingId, amount, methodType)
        return paymentService.pay(req.bookingId, req.amount, req.methodType);
    }

    // 2) 查全部支付记录：GET /api/payments
    @GetMapping("/payments")
    public List<PaymentRecord> listAll() {
        return paymentService.listAll();
    }

    // 3) 查某个 booking 的支付记录：GET /api/bookings/{id}/payments
    @GetMapping("/bookings/{bookingId}/payments")
    public List<PaymentRecord> listByBooking(@PathVariable long bookingId) {
        return paymentService.listByBookingId(bookingId);
    }

    // ===== Request DTO =====
    public static class PayRequest {
        public long bookingId;
        public double amount;
        public String methodType; // 例如: CREDIT_CARD / DEBIT_CARD / BANK_TRANSFER / PAYPAL
    }
}