package com.eecs3311.servicebooking.service;

import com.eecs3311.servicebooking.model.ServiceItem;
import com.eecs3311.servicebooking.repository.ServiceItemRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCatalog {

    private final ServiceItemRepository serviceItemRepository;

    public ServiceCatalog(ServiceItemRepository serviceItemRepository) {
        this.serviceItemRepository = serviceItemRepository;
    }

    @PostConstruct
    public void initDefaultServices() {
        if (serviceItemRepository.count() == 0) {
            serviceItemRepository.save(new ServiceItem(null, "Career Consulting", 60, 80.0));
            serviceItemRepository.save(new ServiceItem(null, "Resume Review", 30, 40.0));
            serviceItemRepository.save(new ServiceItem(null, "Mock Interview", 45, 65.0));
        }
    }

    public List<ServiceItem> listServices() {
        return serviceItemRepository.findAll();
    }
}
