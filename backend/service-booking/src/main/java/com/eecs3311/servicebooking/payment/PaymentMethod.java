package com.eecs3311.servicebooking.payment;

import java.util.Map;

public interface PaymentMethod {
    String methodName();

    // 你原来就有的校验
    void validate(Map<String, String> payload);

    // ✅ 必须有这个，否则 PaymentService 里 method.process(amount) 会报错
    boolean process(double amount);
}