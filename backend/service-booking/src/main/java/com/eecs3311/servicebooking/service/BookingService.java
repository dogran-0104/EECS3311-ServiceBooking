package com.eecs3311.servicebooking.service;

import com.eecs3311.servicebooking.model.Booking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookingService {

    private final List<Booking> bookings = new ArrayList<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public Booking createBooking(Long serviceId, String clientName, LocalDateTime startTime) {
        Booking b = new Booking(
                idGen.getAndIncrement(),
                serviceId,
                clientName,
                startTime,
                "REQUESTED"
        );
        bookings.add(b);
        return b;
    }

    public List<Booking> listBookings() {
        return bookings;
    }
}
