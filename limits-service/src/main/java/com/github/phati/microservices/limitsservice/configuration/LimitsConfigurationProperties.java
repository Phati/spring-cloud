package com.github.phati.microservices.limitsservice.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
@ConfigurationProperties("limits-service")
public class LimitsConfigurationProperties {
    private Integer maximum;
    private Integer minimum;
}
