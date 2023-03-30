package com.github.phati.microservices.limitsservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Limits {
    private Integer minimum;
    private Integer maximum;
}
