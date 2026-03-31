package com.eecs3311.servicebooking.repository;

import com.eecs3311.servicebooking.payment.PaymentRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRecordRepository extends JpaRepository<PaymentRecord, Long> {
    List<PaymentRecord> findByBookingId(Long bookingId);
}
