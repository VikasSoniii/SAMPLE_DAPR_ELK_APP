package org.sds.samsung.order.controller;

import org.sds.samsung.order.dto.OrderDTO;
import org.sds.samsung.order.service.OrderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    OrderServiceImpl orderService;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO) {
        logger.info("starts: Received order: {}", orderDTO);
        //String response = orderService.createOrder(orderDTO);
        ResponseEntity<String> response = orderService.callPaymentService(orderDTO);
        logger.info("ends: Order processed with response: {}", response);
        return response;
    }

    @GetMapping
    public ResponseEntity<String> getOrder() {
        logger.info("Successfully retrieved order details!");
        return ResponseEntity.ok("Successfully retrieves order details!");
    }
}