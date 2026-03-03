package com.eecs3311.servicebooking.service;

import com.eecs3311.servicebooking.model.Booking;
import com.eecs3311.servicebooking.model.BookingStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookingService {

    private final List<Booking> bookings = new ArrayList<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public Booking create(long serviceId, String clientName, LocalDateTime startTime, long consultantId) {
        Booking b = new Booking(
                idGen.getAndIncrement(),
                serviceId,
                consultantId,              // consultantId 要放第3个
                clientName,
                startTime,
                BookingStatus.REQUESTED
        );
        bookings.add(b);
        return b;
    }

    public List<Booking> listAll() {
        return bookings;
    }

    public Optional<Booking> findById(long id) {
        for (Booking b : bookings) {
            if (b.getId() != null && b.getId() == id) return Optional.of(b);
        }
        return Optional.empty();
    }

    public Booking accept(long id) {
        Booking b = findById(id).orElseThrow();
        if (b.getStatus() != BookingStatus.REQUESTED) return b;

        // Phase1 先做：REQUESTED -> CONFIRMED（下一步我们会接上 PENDING_PAYMENT）
        b.setStatus(BookingStatus.CONFIRMED);
        return b;
    }

    public Booking reject(long id) {
        Booking b = findById(id).orElseThrow();
        if (b.getStatus() != BookingStatus.REQUESTED) return b;

        b.setStatus(BookingStatus.REJECTED);
        return b;
    }

    public Booking cancel(long id) {
        Booking b = findById(id).orElseThrow();

        // Phase1 简化：REQUESTED / CONFIRMED 都允许取消；已完成/已取消不动
        if (b.getStatus() == BookingStatus.CANCELLED || b.getStatus() == BookingStatus.COMPLETED) return b;

        b.setStatus(BookingStatus.CANCELLED);
        return b;
    }
}
