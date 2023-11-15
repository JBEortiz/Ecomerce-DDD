package com.ecommerce.infrastructure.springconfig;

import com.ecommerce.application.factory.OrderFactory;
import com.ecommerce.application.repository.OrderRepository;
import com.ecommerce.application.service.impl.OrderApplicationServiceImpl;
import com.ecommerce.domain.ports.in.OrderRepositoryPort;
import com.ecommerce.domain.ports.in.ProductRepositoryPort;
import com.ecommerce.domain.ports.out.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ecommerce.application")
public class SpringConfig {

    @Bean
    public OrderRepository orderRepository(OrderRepositoryPort orderRepository,ProductRepositoryPort productRepository) {
        return new OrderRepository(orderRepository,productRepository);
    }
    @Bean
    public OrderService orderService(OrderRepository orderService, OrderFactory orderFactory) {
        return new OrderApplicationServiceImpl(orderService, orderFactory);
    }
    @Bean
    public OrderFactory orderFactory() {
        return new OrderFactory();
    }
}