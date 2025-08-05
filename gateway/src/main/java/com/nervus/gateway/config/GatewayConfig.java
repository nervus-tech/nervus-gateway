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
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://AUTHENTICATION"))
                .route("user", r -> r.path("/users/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://USER"))
                .route("course", r -> r.path("/courses/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://COURSE"))
                .route("assignment", r -> r.path("/assignments/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://ASSIGNMENT"))
                .route("administration", r -> r.path("/admin/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://ADMINISTRATION"))
                .route("ai-query", r -> r.path("/ai/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://AI-QUERY"))
                .route("grading", r -> r.path("/grading/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://GRADING"))
                .route("frontend", r -> r.path("/frontend/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://FRONTEND"))
                .route("notification", r -> r.path("/notifications/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://NOTIFICATION"))
                .build();
    }
}