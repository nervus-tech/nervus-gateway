package com.nervus.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth", r -> r.path("/auth/**")
                        .uri("lb://nervus-authentication")) // Placeholder URI, update with Eureka
                .route("user", r -> r.path("/users/**")
                        .uri("lb://nervus-user"))          // Placeholder URI
                .build();
    }
}