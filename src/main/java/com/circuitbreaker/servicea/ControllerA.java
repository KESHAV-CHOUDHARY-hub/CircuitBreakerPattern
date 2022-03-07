package com.circuitbreaker.servicea;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@RequestMapping("/A")
public class ControllerA {

    @Autowired
    RestTemplate restTemplate;

    public static final String BASE_URL = "http://localhost:8085/";

    public static final String SERVICE_A = "serviceA";

//    int count=1;

    @GetMapping
    @CircuitBreaker(name = SERVICE_A, fallbackMethod = "getAFallback")
    //@Retry(name = SERVICE_A)
    //@RateLimiter(name = SERVICE_A)
    public String getA() {
        String url = BASE_URL + "B";
//        System.out.println("Retry method called " + count++ + " times at " + new Date());
        return restTemplate.getForObject(url, String.class);
    }

    public String getAFallback(Exception e) {
        return "Fallback method for Service A";
    }
}
