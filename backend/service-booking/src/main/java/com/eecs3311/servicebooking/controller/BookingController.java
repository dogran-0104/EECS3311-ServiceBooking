package com.eecs3311.servicebooking.controller;

import com.eecs3311.servicebooking.model.Booking;
import com.eecs3311.servicebooking.service.AvailabilityService;
import com.eecs3311.servicebooking.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BookingController {

    private final BookingService bookingService;
    private final AvailabilityService availabilityService;

    public BookingController(BookingService bookingService, AvailabilityService availabilityService) {
        this.bookingService = bookingService;
        this.availabilityService = availabilityService;
    }

    // UC8: consultant slots
    @GetMapping("/consultants/{consultantId}/slots")
    public List<LocalDateTime> listSlots(@PathVariable long consultantId) {
        return availabilityService.listSlots(consultantId);
    }

    // UC2: request booking (now must check availability)
    @PostMapping("/bookings")
    public ResponseEntity<?> createBooking(@RequestBody Map<String, String> body) {
        long serviceId = Long.parseLong(body.get("serviceId"));
        String clientName = body.get("clientName");
        LocalDateTime startTime = LocalDateTime.parse(body.get("startTime"));
        long consultantId = Long.parseLong(body.getOrDefault("consultantId", "1"));

        boolean ok = availabilityService.reserveIfAvailable(consultantId, startTime);
        if (!ok) {
            return ResponseEntity.badRequest().body("Selected time is not available.");
        }

        Booking created = bookingService.create(serviceId, clientName, startTime, consultantId);
        return ResponseEntity.ok(created);
    }

    // UC4: list bookings
    @GetMapping("/bookings")
    public List<Booking> listBookings() {
        return bookingService.listAll();
    }

    // UC9: accept
    @PostMapping("/bookings/{id}/accept")
    public Booking accept(@PathVariable long id) {
        return bookingService.accept(id);
    }

    // UC9: reject
    @PostMapping("/bookings/{id}/reject")
    public Booking reject(@PathVariable long id) {
        return bookingService.reject(id);
    }

    // UC3: cancel
    @PostMapping("/bookings/{id}/cancel")
    public Booking cancel(@PathVariable long id) {
        return bookingService.cancel(id);
    }
}
