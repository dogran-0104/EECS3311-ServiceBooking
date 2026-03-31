package com.eecs3311.servicebooking.controller;

import com.eecs3311.servicebooking.payment.PaymentMethodService;
import com.eecs3311.servicebooking.payment.SavedPaymentMethod;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-methods")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @PostMapping
    public SavedPaymentMethod add(@RequestBody PaymentMethodRequest req) {
        return paymentMethodService.add(req.clientName, req.methodType, req.details);
    }

    @GetMapping
    public List<SavedPaymentMethod> listAll(@RequestParam(required = false) String clientName) {
        if (clientName != null && !clientName.isBlank()) {
            return paymentMethodService.listByClient(clientName);
        }
        return paymentMethodService.listAll();
    }

    @PutMapping("/{id}")
    public SavedPaymentMethod update(@PathVariable long id, @RequestBody PaymentMethodRequest req) {
        return paymentMethodService.update(id, req.clientName, req.methodType, req.details);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        paymentMethodService.remove(id);
    }

    public static class PaymentMethodRequest {
        public String clientName;
        public String methodType;
        public String details;
    }
}
