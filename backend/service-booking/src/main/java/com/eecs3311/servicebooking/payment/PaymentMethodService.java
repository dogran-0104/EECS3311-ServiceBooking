package com.eecs3311.servicebooking.payment;

import com.eecs3311.servicebooking.repository.SavedPaymentMethodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodService {

    private final SavedPaymentMethodRepository savedPaymentMethodRepository;

    public PaymentMethodService(SavedPaymentMethodRepository savedPaymentMethodRepository) {
        this.savedPaymentMethodRepository = savedPaymentMethodRepository;
    }

    public SavedPaymentMethod add(String clientName, String methodType, String details) {
        SavedPaymentMethod method = new SavedPaymentMethod(
                null,
                clientName,
                methodType == null ? null : methodType.toUpperCase(),
                details
        );
        return savedPaymentMethodRepository.save(method);
    }

    public List<SavedPaymentMethod> listAll() {
        return savedPaymentMethodRepository.findAll();
    }

    public List<SavedPaymentMethod> listByClient(String clientName) {
        return savedPaymentMethodRepository.findByClientName(clientName);
    }

    public SavedPaymentMethod update(long id, String clientName, String methodType, String details) {
        SavedPaymentMethod method = savedPaymentMethodRepository.findById(id).orElseThrow();
        method.setClientName(clientName);
        method.setMethodType(methodType == null ? null : methodType.toUpperCase());
        method.setDetails(details);
        return savedPaymentMethodRepository.save(method);
    }

    public void remove(long id) {
        savedPaymentMethodRepository.deleteById(id);
    }
}
