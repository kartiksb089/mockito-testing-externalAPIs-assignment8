package com.mockito.test.service;

import com.mockito.test.dependency.PaymentGatewayClient;

public class PaymentService {

    private PaymentGatewayClient paymentGatewayClient;

    public PaymentService(PaymentGatewayClient paymentGatewayClient) {
        this.paymentGatewayClient = paymentGatewayClient;
    }

    public boolean processPayment(String userId, double amount) {

        String response =
                paymentGatewayClient.charge(userId, amount);

        return "SUCCESS".equals(response);
    }
}
