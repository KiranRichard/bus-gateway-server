package com.online.bus.ticket.reservation.gateway_server.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class GatewayLoggingFilter implements GlobalFilter {

    private static final Logger log = (Logger) LoggerFactory.getLogger(GatewayLoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String path = exchange.getRequest().getURI().getPath();
        String method = exchange.getRequest().getMethod().name();

        log.info("Request routed via API Gateway: "+ method +" "+ path);

        return chain.filter(exchange);
    }
}