package com.eecs3311.servicebooking.repository;

import com.eecs3311.servicebooking.model.AvailabilitySlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailabilitySlotRepository extends JpaRepository<AvailabilitySlot, Long> {
    List<AvailabilitySlot> findByConsultantId(Long consultantId);
}
