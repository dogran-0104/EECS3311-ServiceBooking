package com.eecs3311.servicebooking.service;

import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    public String answer(String question) {
        if (question == null || question.isBlank()) {
            return "Please enter a question about the platform, booking process, payment methods, or available services.";
        }

        String q = question.toLowerCase();

        if (q.contains("book") || q.contains("booking") || q.contains("how do i book")) {
            return """
                    To book a consulting session:
                    1. Open the booking page.
                    2. Load available services.
                    3. Load consultant time slots.
                    4. Choose a service and an available slot.
                    5. Enter your name and submit the booking.
                    After submission, the booking starts in REQUESTED status.
                    """;
        }

        if (q.contains("payment") || q.contains("pay") || q.contains("method")) {
            return """
                    The platform supports these payment methods:
                    - Credit Card
                    - Debit Card
                    - PayPal
                    - Bank Transfer

                    Payments are simulated in this project. After a successful payment, the booking status can move to PAID.
                    """;
        }

        if (q.contains("cancel") || q.contains("cancellation")) {
            return """
                    A booking can be cancelled through the system. The platform may apply cancellation rules depending on policy settings.
                    In this demo, booking status can be updated to CANCELLED through the admin workflow.
                    """;
        }

        if (q.contains("service") || q.contains("available services")) {
            return """
                    The platform currently provides public consulting service information such as:
                    - Career Consulting
                    - Resume Review
                    - Mock Interview

                    You can browse services from the home page and view their duration and price.
                    """;
        }

        if (q.contains("consultant") || q.contains("slot") || q.contains("availability")) {
            return """
                    Consultants can provide available time slots. Clients can load those slots on the booking page before submitting a booking request.
                    """;
        }

        if (q.contains("admin")) {
            return """
                    The admin console can:
                    - Load bookings
                    - Accept, reject, or cancel bookings
                    - Process payments
                    - Load payment history
                    """;
        }

        return """
                I can help with:
                - how booking works
                - payment methods
                - cancellation information
                - available services
                - consultant availability
                - admin functions

                Try asking something like:
                "How do I book a consultant?"
                """;
    }
}
