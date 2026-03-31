package com.eecs3311.servicebooking.service;

import com.eecs3311.servicebooking.model.Booking;
import com.eecs3311.servicebooking.model.BookingStatus;
import com.eecs3311.servicebooking.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking create(long serviceId, String clientName, LocalDateTime startTime, long consultantId) {
        Booking b = new Booking(
                null,
                serviceId,
                consultantId,
                clientName,
                startTime,
                BookingStatus.REQUESTED
        );
        return bookingRepository.save(b);
    }

    public List<Booking> listAll() {
        List<Booking> list = bookingRepository.findAll();
        list.sort(Comparator.comparingLong(b -> b.getId() == null ? Long.MAX_VALUE : b.getId()));
        return list;
    }

    public Optional<Booking> findById(long id) {
        return bookingRepository.findById(id);
    }

    public Booking accept(long id) {
        Booking b = bookingRepository.findById(id).orElseThrow();

        if (b.getStatus() != BookingStatus.REQUESTED) {
            return b;
        }

        b.setStatus(BookingStatus.CONFIRMED);
        return bookingRepository.save(b);
    }

    public Booking reject(long id) {
        Booking b = bookingRepository.findById(id).orElseThrow();

        if (b.getStatus() != BookingStatus.REQUESTED) {
            return b;
        }

        b.setStatus(BookingStatus.REJECTED);
        return bookingRepository.save(b);
    }

    public Booking cancel(long id) {
        Booking b = bookingRepository.findById(id).orElseThrow();

        if (b.getStatus() == BookingStatus.CANCELLED || b.getStatus() == BookingStatus.COMPLETED) {
            return b;
        }

        b.setStatus(BookingStatus.CANCELLED);
        return bookingRepository.save(b);
    }
}
