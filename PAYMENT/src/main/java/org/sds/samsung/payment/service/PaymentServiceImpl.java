package org.sds.samsung.payment.service;

import org.sds.samsung.payment.controller.PaymentController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    public String processPayment(String orderId) {
        logger.info("PaymentServiceImpl.processPayment - Received processPayment request: {}", orderId);
        return "Payment processed for Payment Id: " + orderId;
    }
}