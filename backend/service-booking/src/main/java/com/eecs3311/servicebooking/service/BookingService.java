package com.eecs3311.servicebooking.service;

import com.eecs3311.servicebooking.model.Booking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookingService {

    private final List<Booking> bookings = new ArrayList<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public Booking create(long serviceId, String clientName, LocalDateTime startTime, long consultantId) {
        Booking b = new Booking(
                idGen.getAndIncrement(),
                serviceId,
                clientName,
                startTime,
                "REQUESTED",
                consultantId
        );
        bookings.add(b);
        return b;
    }

    public List<Booking> listAll() {
        return bookings;
    }

    public Optional<Booking> findById(long id) {
        for (Booking b : bookings) {
            if (b.getId() == id) return Optional.of(b);
        }
        return Optional.empty();
    }

    public Booking accept(long id) {
        Booking b = findById(id).orElseThrow();
        if (!"REQUESTED".equals(b.getStatus())) return b;
        b.setStatus("CONFIRMED");
        return b;
    }

    public Booking reject(long id) {
        Booking b = findById(id).orElseThrow();
        if (!"REQUESTED".equals(b.getStatus())) return b;
        b.setStatus("REJECTED");
        return b;
    }

    public Booking cancel(long id) {
        Booking b = findById(id).orElseThrow();
        // Phase1 简化：REQUESTED/CONFIRMED 都允许 cancel
        if ("CANCELLED".equals(b.getStatus()) || "COMPLETED".equals(b.getStatus())) return b;
        b.setStatus("CANCELLED");
        return b;
    }
}
