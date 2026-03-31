package com.eecs3311.servicebooking.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "availability_slots")
public class AvailabilitySlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long consultantId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean available;

    public AvailabilitySlot() {}

    public AvailabilitySlot(Long id, Long consultantId, LocalDateTime startTime, LocalDateTime endTime, boolean available) {
        this.id = id;
        this.consultantId = consultantId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.available = available;
    }

    public Long getId() { return id; }
    public Long getConsultantId() { return consultantId; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public boolean isAvailable() { return available; }

    public void setId(Long id) { this.id = id; }
    public void setConsultantId(Long consultantId) { this.consultantId = consultantId; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
    public void setAvailable(boolean available) { this.available = available; }
}
