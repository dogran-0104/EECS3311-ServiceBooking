package com.eecs3311.servicebooking.controller;

import com.eecs3311.servicebooking.model.ServiceItem;
import com.eecs3311.servicebooking.service.ServiceCatalog;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ServiceController {

    private final ServiceCatalog serviceCatalog;

    public ServiceController(ServiceCatalog serviceCatalog) {
        this.serviceCatalog = serviceCatalog;
    }

    @GetMapping("/services")
    public List<ServiceItem> getServices() {
        return serviceCatalog.listServices();
    }
}
