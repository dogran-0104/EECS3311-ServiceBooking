package com.eecs3311.servicebooking.service;

import com.eecs3311.servicebooking.model.ServiceItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCatalog {

    public List<ServiceItem> listServices() {
        return List.of(
                new ServiceItem(1L, "Career Consulting", 60, 80.0),
                new ServiceItem(2L, "Resume Review", 30, 40.0),
                new ServiceItem(3L, "Mock Interview", 45, 65.0)
        );
    }
}
