package com.eecs3311.servicebooking.payment;

import com.eecs3311.servicebooking.model.Booking;
import com.eecs3311.servicebooking.model.BookingStatus;
import com.eecs3311.servicebooking.repository.BookingRepository;
import com.eecs3311.servicebooking.repository.PaymentRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {

    private final PaymentFactory paymentFactory;
    private final PaymentRecordRepository paymentRecordRepository;
    private final BookingRepository bookingRepository;

    public PaymentService(PaymentFactory paymentFactory,
                          PaymentRecordRepository paymentRecordRepository,
                          BookingRepository bookingRepository) {
        this.paymentFactory = paymentFactory;
        this.paymentRecordRepository = paymentRecordRepository;
        this.bookingRepository = bookingRepository;
    }

    public PaymentRecord pay(long bookingId, double amount, String methodType) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow();

        PaymentMethod method = paymentFactory.create(methodType);
        boolean ok = method.process(amount);

        PaymentRecord record = new PaymentRecord(
                null,
                bookingId,
                amount,
                methodType == null ? null : methodType.toUpperCase(),
                ok ? "PAID" : "FAILED",
                LocalDateTime.now()
        );

        PaymentRecord saved = paymentRecordRepository.save(record);

        if (ok) {
            booking.setStatus(BookingStatus.PAID);
            bookingRepository.save(booking);
        }

        return saved;
    }

    public List<PaymentRecord> listAll() {
        return paymentRecordRepository.findAll();
    }

    public List<PaymentRecord> listByBookingId(long bookingId) {
        return paymentRecordRepository.findByBookingId(bookingId);
    }
}
