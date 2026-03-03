package com.eecs3311.servicebooking.policy;

public class CancellationDecision {
    private final boolean allowed;
    private final double fee;
    private final String reason;

    public CancellationDecision(boolean allowed, double fee, String reason) {
        this.allowed = allowed;
        this.fee = fee;
        this.reason = reason;
    }

    public boolean isAllowed() { return allowed; }
    public double getFee() { return fee; }
    public String getReason() { return reason; }

    public static CancellationDecision allowNoFee(String reason) {
        return new CancellationDecision(true, 0.0, reason);
    }

    public static CancellationDecision allowWithFee(double fee, String reason) {
        return new CancellationDecision(true, fee, reason);
    }

    public static CancellationDecision deny(String reason) {
        return new CancellationDecision(false, 0.0, reason);
    }
}