package com.github.phati.microservices.limitsservice.controller;

import com.github.phati.microservices.limitsservice.configuration.LimitsConfigurationProperties;
import com.github.phati.microservices.limitsservice.model.Limits;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LimitsController {
    private final LimitsConfigurationProperties limitsConfigurationProperties;

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return new Limits(limitsConfigurationProperties.getMinimum(), limitsConfigurationProperties.getMaximum());
    }
}
