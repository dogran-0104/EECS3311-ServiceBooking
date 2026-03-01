package com.eecs3311.servicebooking.controller;

import com.eecs3311.servicebooking.model.Booking;
import com.eecs3311.servicebooking.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    public static class CreateBookingRequest {
        public Long serviceId;
        public String clientName;
        public String startTime;
    }

    @PostMapping("/bookings")
    public Booking create(@RequestBody CreateBookingRequest req) {
        LocalDateTime t = LocalDateTime.parse(req.startTime);
        return bookingService.createBooking(req.serviceId, req.clientName, t);
    }

    @GetMapping("/bookings")
    public List<Booking> list() {
        return bookingService.listBookings();
    }
}
