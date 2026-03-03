package com.eecs3311.servicebooking.policy;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class DefaultCancellationPolicy implements CancellationPolicy {

    // 你可以按要求改规则：比如 24h 内取消收取 fee、开始后不允许等
    private static final long FREE_CANCEL_HOURS = 24;
    private static final double LATE_CANCEL_FEE = 10.0;

    @Override
    public CancellationDecision evaluate(LocalDateTime startTime, LocalDateTime now) {
        if (startTime == null) return CancellationDecision.deny("Missing startTime");
        if (now.isAfter(startTime)) {
            return CancellationDecision.deny("Too late: booking already started");
        }

        long hours = Duration.between(now, startTime).toHours();
        if (hours >= FREE_CANCEL_HOURS) {
            return CancellationDecision.allowNoFee("Cancelled with no fee (>= " + FREE_CANCEL_HOURS + "h)");
        }
        return CancellationDecision.allowWithFee(LATE_CANCEL_FEE, "Late cancellation fee applied");
    }
}