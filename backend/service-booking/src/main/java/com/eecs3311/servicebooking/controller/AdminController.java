package com.eecs3311.servicebooking.controller;

import com.eecs3311.servicebooking.model.Consultant;
import com.eecs3311.servicebooking.service.ConsultantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final ConsultantService consultantService;

    public AdminController(ConsultantService consultantService) {
        this.consultantService = consultantService;
    }

    // 方便你测试：查看所有顾问（含 approved 状态）
    @GetMapping("/consultants")
    public List<Consultant> listConsultants() {
        return consultantService.listAll();
    }

    // UC11: approve consultant
    @PostMapping("/consultants/{id}/approve")
    public ResponseEntity<?> approve(@PathVariable long id) {
        try {
            Consultant c = consultantService.approve(id);
            return ResponseEntity.ok(c);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    // UC11: reject consultant
    @PostMapping("/consultants/{id}/reject")
    public ResponseEntity<?> reject(@PathVariable long id) {
        try {
            Consultant c = consultantService.reject(id);
            return ResponseEntity.ok(c);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}