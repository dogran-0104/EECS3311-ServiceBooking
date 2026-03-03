package com.eecs3311.servicebooking.policy;

import org.springframework.stereotype.Service;

@Service
public class PolicyService {
    private final CancellationPolicy cancellationPolicy;

    public PolicyService(CancellationPolicy cancellationPolicy) {
        this.cancellationPolicy = cancellationPolicy;
    }

    public CancellationPolicy cancellation() {
        return cancellationPolicy;
    }
}