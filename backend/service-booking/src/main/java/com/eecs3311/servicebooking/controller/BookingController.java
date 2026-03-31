package com.eecs3311.servicebooking.controller;

import com.eecs3311.servicebooking.model.AvailabilitySlot;
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
    public List<AvailabilitySlot> listSlots(@PathVariable long consultantId) {
        return availabilityService.listSlots(consultantId);
    }

    // UC2: request booking
    @PostMapping("/bookings")
    public ResponseEntity<?> createBooking(@RequestBody Map<String, String> body) {
        long serviceId = Long.parseLong(body.get("serviceId"));
        String clientName = body.get("clientName");
        LocalDateTime startTime = LocalDateTime.parse(body.get("startTime"));
        long consultantId = Long.parseLong(body.get("consultantId"));

        if (!availabilityService.isAvailable(consultantId, startTime)) {
            return ResponseEntity.badRequest().body(Map.of(
                    "error", "Selected consultant is not available at the requested time."
            ));
        }

        Booking booking = bookingService.create(serviceId, clientName, startTime, consultantId);
        return ResponseEntity.ok(booking);
    }

    // UC4: view booking history / list all bookings
    @GetMapping("/bookings")
    public List<Booking> listBookings() {
        return bookingService.listAll();
    }

    // UC9: consultant accepts booking
    @PostMapping("/bookings/{id}/accept")
    public Booking acceptBooking(@PathVariable long id) {
        return bookingService.accept(id);
    }

    // UC9: consultant rejects booking
    @PostMapping("/bookings/{id}/reject")
    public Booking rejectBooking(@PathVariable long id) {
        return bookingService.reject(id);
    }

    // UC3: cancel booking
    @PostMapping("/bookings/{id}/cancel")
    public Booking cancelBooking(@PathVariable long id) {
        return bookingService.cancel(id);
    }
}
