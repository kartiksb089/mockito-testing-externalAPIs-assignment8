package com.mockito.test.dependency;

public class PaymentGatewayClient {

    public String charge(String userId, double amount) {

        // Imagine this calls external API

        System.out.println("Calling external payment API...");

        return "SUCCESS";
    }
}