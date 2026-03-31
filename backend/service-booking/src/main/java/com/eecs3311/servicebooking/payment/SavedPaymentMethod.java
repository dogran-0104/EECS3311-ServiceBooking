package com.eecs3311.servicebooking.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "saved_payment_methods")
public class SavedPaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientName;
    private String methodType;
    private String details;

    public SavedPaymentMethod() {}

    public SavedPaymentMethod(Long id, String clientName, String methodType, String details) {
        this.id = id;
        this.clientName = clientName;
        this.methodType = methodType;
        this.details = details;
    }

    public Long getId() { return id; }
    public String getClientName() { return clientName; }
    public String getMethodType() { return methodType; }
    public String getDetails() { return details; }

    public void setId(Long id) { this.id = id; }
    public void setClientName(String clientName) { this.clientName = clientName; }
    public void setMethodType(String methodType) { this.methodType = methodType; }
    public void setDetails(String details) { this.details = details; }
}
