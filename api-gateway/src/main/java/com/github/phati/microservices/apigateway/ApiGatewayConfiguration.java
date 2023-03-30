package com.github.phati.microservices.apigateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        Function<PredicateSpec, Buildable<Route>> function = new Function<PredicateSpec, Buildable<Route>>() {
            @Override
            public Buildable<Route> apply(PredicateSpec predicateSpec) {
                return predicateSpec.path("").uri("");
            }
        };
        return builder.routes()
                .route(function)
                .route(p -> p.path("/get").uri("http://httpbin.org:80"))
                .route(p-> p.path("/currency-exchange/**").uri("lb://currency-exchange"))
                .route(p-> p.path("/currency-conversion/**").uri("lb://currency-conversion"))
                .route(p-> p.path("/currency-conversion-feign/**").uri("lb://currency-conversion"))
                .route(p-> p.path("/currency-conversion-new/**")
                        .filters(f->f.rewritePath("/currency-conversion-new/(?<segment>.*)","/currency-conversion-feign/${segment}"))
                        .uri("lb://currency-conversion"))
                .build();
    }
}
