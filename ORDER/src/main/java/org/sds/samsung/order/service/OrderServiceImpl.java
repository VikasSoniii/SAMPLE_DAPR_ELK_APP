package org.sds.samsung.order.service;

import org.sds.samsung.order.dto.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<String> callPaymentService(OrderDTO orderDTO) {
        logger.info("starts: Creating order: {}", orderDTO);

        //Create a HttpEntity Object that contains the request and body
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OrderDTO> requestEntity = new HttpEntity<>(orderDTO, headers);

        ResponseEntity<String> message = restTemplate.postForEntity("http://payment-demo.ns-vikas:8082/payment", requestEntity, String.class);
        logger.info("ends: Received response from payment-service: {}", message);
        return message;
    }

    /*@Autowired
    DaprClient daprClient;

    public String createOrder(OrderDTO orderDTO) {
        String result = "";
        logger.info("starts: Creating order: {}", orderDTO.toString());
        try {
            byte[] response = daprClient.invokeMethod(
                    "payment-service",
                    "payment",
                    orderDTO,
                    HttpExtension.POST,
                    byte[].class
            ).block();

            if (response != null) {
                result = new String(response);
            }
            logger.info("ends: Received response from payment-service: {}", result);
            return result;
        } catch (Exception e) {
            logger.error("Error while invoking payment-service", e);
            return "ends: Error processing order";
        }
    }*/
}
