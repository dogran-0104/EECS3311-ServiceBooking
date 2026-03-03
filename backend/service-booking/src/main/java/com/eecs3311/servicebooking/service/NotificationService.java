package com.eecs3311.servicebooking.service;

public interface NotificationService {
    void notifyClient(String clientName, String message);
    void notifyConsultant(long consultantId, String message);
}
