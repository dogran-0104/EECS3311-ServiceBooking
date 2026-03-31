package com.eecs3311.servicebooking.controller;

import com.eecs3311.servicebooking.model.AvailabilitySlot;
import com.eecs3311.servicebooking.service.AvailabilityService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {

    private final AvailabilityService availabilityService;

    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @PostMapping
    public AvailabilitySlot addSlot(@RequestBody AvailabilityRequest req) {
        return availabilityService.addSlot(req.consultantId, req.startTime, req.endTime);
    }

    @GetMapping
    public List<AvailabilitySlot> listAll(@RequestParam(required = false) Long consultantId) {
        if (consultantId != null) {
            return availabilityService.listByConsultant(consultantId);
        }
        return availabilityService.listAll();
    }

    public static class AvailabilityRequest {
        public long consultantId;
        public LocalDateTime startTime;
        public LocalDateTime endTime;
    }
}
