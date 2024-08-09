package org.sds.samsung.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrderMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainApplication.class);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
   /* @Bean
    public DaprClient getDaprClient(){
        return new DaprClientBuilder().build();
    }*/
}