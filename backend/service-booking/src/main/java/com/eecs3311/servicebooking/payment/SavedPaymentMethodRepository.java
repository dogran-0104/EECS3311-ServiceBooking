package com.eecs3311.servicebooking.repository;

import com.eecs3311.servicebooking.payment.SavedPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavedPaymentMethodRepository extends JpaRepository<SavedPaymentMethod, Long> {
    List<SavedPaymentMethod> findByClientName(String clientName);
}
