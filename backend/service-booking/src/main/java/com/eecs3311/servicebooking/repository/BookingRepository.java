package com.eecs3311.servicebooking.repository;

import com.eecs3311.servicebooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
