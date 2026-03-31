package com.eecs3311.servicebooking.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment_records")
public class PaymentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookingId;
    private double amount;
    private String methodType;
    private String status;
    private LocalDateTime createdAt;

    public PaymentRecord() {}

    public PaymentRecord(Long id, Long bookingId, double amount, String methodType, String status, LocalDateTime createdAt) {
        this.id = id;
        this.bookingId = bookingId;
        this.amount = amount;
        this.methodType = methodType;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public Long getBookingId() { return bookingId; }
    public double getAmount() { return amount; }
    public String getMethodType() { return methodType; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setBookingId(Long bookingId) { this.bookingId = bookingId; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setMethodType(String methodType) { this.methodType = methodType; }
    public void setStatus(String status) { this.status = status; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
