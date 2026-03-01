package com.eecs3311.servicebooking.model;

import java.time.LocalDateTime;

public class Booking {
    private Long id;
    private Long serviceId;
    private String clientName;
    private LocalDateTime startTime;
    private String status; // REQUESTED / CONFIRMED / CANCELLED 等，Phase1先用字符串
    private long consultantId;
    public Booking() {}

    public Booking(Long id, Long serviceId, String clientName, LocalDateTime startTime, String status, long consultantId) {
        this.id = id;
        this.serviceId = serviceId;
        this.clientName = clientName;
        this.startTime = startTime;
        this.status = status;
        this.consultantId = consultantId;
    }

    public Long getId() { return id; }
    public Long getServiceId() { return serviceId; }
    public String getClientName() { return clientName; }
    public LocalDateTime getStartTime() { return startTime; }
    public String getStatus() { return status; }
    public long getConsultantId() { return consultantId; }
    public void setId(Long id) { this.id = id; }
    public void setServiceId(Long serviceId) { this.serviceId = serviceId; }
    public void setClientName(String clientName) { this.clientName = clientName; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public void setStatus(String status) { this.status = status; }
    public void setConsultantId(long consultantId) {this.consultantId = consultantId;}
}
