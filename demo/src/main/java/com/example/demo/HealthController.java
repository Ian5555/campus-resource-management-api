package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// This is a simple controller that has a single endpoint for checking the health of the API. It returns "OK" when the endpoint is accessed, which indicates that the API is running and healthy.
@RestController
@RequestMapping("/api")
public class HealthController {
// The GET endpoint for checking the health of the API. It returns "OK" when the endpoint is accessed, which indicates that the API is running and healthy.
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
