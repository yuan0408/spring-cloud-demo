package com.example.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

//全局过滤器
@Component   //需要注册为Bean
public class TestFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {   //只需要实现此方法
        ServerHttpRequest request = exchange.getRequest();
        System.out.println(request.getQueryParams());
        List<String> value = request.getQueryParams().get("Test");
        if (value!=null && value.contains("1")){
            return chain.filter(exchange);
        }else {
            return exchange.getResponse().setComplete();
        }
    }

    @Override
    public int getOrder() {
        //返回的order值越小，优先级越高
        return 0;
    }
}

