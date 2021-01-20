package com.lt.springcloud.cofig;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lucine
 * @version 1.0 2020/12/22 17:24
 */
@Configuration
public class GateWayConfig {


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
//http://newsbaidu.com/
        return  routes.build();
    }
}
