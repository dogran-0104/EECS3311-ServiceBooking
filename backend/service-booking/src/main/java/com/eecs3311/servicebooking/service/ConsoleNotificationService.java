package com.eecs3311.servicebooking.service;

import org.springframework.stereotype.Service;

@Service
public class ConsoleNotificationService implements NotificationService {

    @Override
    public void notifyClient(String clientName, String message) {
        System.out.println("[NOTIFY][CLIENT][" + clientName + "] " + message);
    }

    @Override
    public void notifyConsultant(long consultantId, String message) {
        System.out.println("[NOTIFY][CONSULTANT][" + consultantId + "] " + message);
    }
}
