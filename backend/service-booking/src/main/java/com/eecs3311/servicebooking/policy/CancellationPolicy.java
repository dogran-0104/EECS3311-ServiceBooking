package com.eecs3311.servicebooking.policy;

import java.time.LocalDateTime;

public interface CancellationPolicy {
    CancellationDecision evaluate(LocalDateTime startTime, LocalDateTime now);
}
