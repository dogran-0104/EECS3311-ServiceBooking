package com.eecs3311.servicebooking.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long serviceId;
    private Long consultantId;
    private String clientName;
    private LocalDateTime startTime;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private Double cancelFee;

    public Booking() {}

    public Booking(Long id,
                   Long serviceId,
                   Long consultantId,
                   String clientName,
                   LocalDateTime startTime,
                   BookingStatus status) {
        this.id = id;
        this.serviceId = serviceId;
        this.consultantId = consultantId;
        this.clientName = clientName;
        this.startTime = startTime;
        this.status = status;
    }

    public Long getId() { return id; }
    public Long getServiceId() { return serviceId; }
    public Long getConsultantId() { return consultantId; }
    public String getClientName() { return clientName; }
    public LocalDateTime getStartTime() { return startTime; }
    public BookingStatus getStatus() { return status; }
    public Double getCancelFee() { return cancelFee; }

    public void setId(Long id) { this.id = id; }
    public void setServiceId(Long serviceId) { this.serviceId = serviceId; }
    public void setConsultantId(Long consultantId) { this.consultantId = consultantId; }
    public void setClientName(String clientName) { this.clientName = clientName; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public void setStatus(BookingStatus status) { this.status = status; }
    public void setCancelFee(Double cancelFee) { this.cancelFee = cancelFee; }
}
