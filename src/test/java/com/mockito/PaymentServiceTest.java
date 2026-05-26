package com.mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.mockito.test.dependency.PaymentGatewayClient;
import com.mockito.test.service.PaymentService;

public class PaymentServiceTest {
    @Test
    void shouldReturnTrue_whenPaymentSuccessfull(){
        PaymentGatewayClient mockClient=mock(PaymentGatewayClient.class);

        when(mockClient.charge("user1", 100))
                .thenReturn("SUCCESS");

        PaymentService service =
                new PaymentService(mockClient);

        boolean result =
                service.processPayment("user1", 100.0);

        assertTrue(result);

        verify(mockClient)
                .charge("user1", 100.0);

        verifyNoMoreInteractions(mockClient);

    }
    @Test
    void shouldReturnFalse_whenPaymentFails() {

        PaymentGatewayClient mockClient =
                mock(PaymentGatewayClient.class);

        when(mockClient.charge("user1", 100))
                .thenReturn("FAILED");

        PaymentService service =
                new PaymentService(mockClient);

        boolean result =
                service.processPayment("user1", 100);

        assertFalse(result);

        verify(mockClient)
                .charge("user1", 100);

        verifyNoMoreInteractions(mockClient);
    }
    @Test
    void shouldThrowException_whenApiFails() {

        PaymentGatewayClient mockClient =
                mock(PaymentGatewayClient.class);

        when(mockClient.charge("user1", 100))
                .thenThrow(new RuntimeException("API Down"));

        PaymentService service =
                new PaymentService(mockClient);

        RuntimeException exception =
                assertThrows(RuntimeException.class,
                        () -> service.processPayment("user1", 100));

        assertEquals("API Down", exception.getMessage());

        verify(mockClient)
                .charge("user1", 100);

        verifyNoMoreInteractions(mockClient);
    }
}
