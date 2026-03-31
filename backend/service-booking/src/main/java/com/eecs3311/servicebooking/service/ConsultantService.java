package com.eecs3311.servicebooking.service;

import com.eecs3311.servicebooking.model.Consultant;
import com.eecs3311.servicebooking.repository.ConsultantRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ConsultantService {

    private final ConsultantRepository consultantRepository;

    public ConsultantService(ConsultantRepository consultantRepository) {
        this.consultantRepository = consultantRepository;
    }

    @PostConstruct
    public void initDefaultConsultants() {
        if (consultantRepository.count() == 0) {
            consultantRepository.save(new Consultant(null, "Default Consultant", true));
            consultantRepository.save(new Consultant(null, "New Applicant", false));
        }
    }

    public List<Consultant> listAll() {
        List<Consultant> list = consultantRepository.findAll();
        list.sort(Comparator.comparingLong(c -> c.getId() == null ? Long.MAX_VALUE : c.getId()));
        return list;
    }

    public Optional<Consultant> findById(long id) {
        return consultantRepository.findById(id);
    }

    public Consultant register(String name) {
        Consultant c = new Consultant(null, name, false);
        return consultantRepository.save(c);
    }

    public Consultant approve(long id) {
        Consultant c = consultantRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Consultant not found: " + id));
        c.setApproved(true);
        return consultantRepository.save(c);
    }

    public Consultant reject(long id) {
        Consultant c = consultantRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Consultant not found: " + id));
        c.setApproved(false);
        return consultantRepository.save(c);
    }
}
