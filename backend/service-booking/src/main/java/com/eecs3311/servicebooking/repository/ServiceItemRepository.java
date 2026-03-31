package com.eecs3311.servicebooking.repository;

import com.eecs3311.servicebooking.model.ServiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceItemRepository extends JpaRepository<ServiceItem, Long> {
}
