package com.circuitbreaker.serviceb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/B")
public class ControllerB {

    @GetMapping
    public String getB() {
        return "Service B Running Via Rest Template From Service A";
    }
}
