package org.sds.samsung.payment.controller;

import org.sds.samsung.payment.dto.OrderDTO;
import org.sds.samsung.payment.service.PaymentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
    @Autowired
    PaymentServiceImpl paymentService;

    @PostMapping
    public String processPayment(@RequestBody OrderDTO orderDTO) {
        logger.info("starts: Received payment request: {}", orderDTO);
        String response = paymentService.processPayment(orderDTO.getOrderId());
        logger.info("ends: Payment processed with response: {}", response);
        return response;
    }
}
