package com.eecs3311.servicebooking.repository;

import com.eecs3311.servicebooking.model.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {
}
