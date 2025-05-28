package com.rds.app.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class GreetController
{

    @GetMapping
    public Map<String, String> greet()
    {
        return Map.of(
            "message", "Congratulations! You have successfully deployed your first Spring Boot application on AWS",
            "status", "success",
            "timestamp", LocalDateTime.now().toString(),
            "version", "1.0.0",
            "author", "Ramanuj Das"
        );

    }

    @GetMapping("/health")
    public Map<String, String> healthCheck()
    {
        return Map.of(
            "status", "UP",
            "timestamp", LocalDateTime.now().toString(),
            "version", "1.0.0",
            "author", "Ramanuj Das"
        );
    }

}
