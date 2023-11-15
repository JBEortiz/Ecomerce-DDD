package com.ecommerce.infrastructure.persistence.repository.impl;

import com.ecommerce.domain.model.*;
import com.ecommerce.domain.ports.in.OrderRepositoryPort;
import com.ecommerce.infrastructure.persistence.entity.OrderEntity;
import com.ecommerce.infrastructure.persistence.entity.OrderLineEntity;
import com.ecommerce.infrastructure.persistence.repository.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class OrderRepositoryAdapter implements OrderRepositoryPort {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Order save(Order order) {
        List<OrderLineEntity> orderLinesEntities = order.getOrderLines().stream()
                .map(orderLine -> {
                    return OrderLineEntity.builder()
                            .productId(orderLine.getProductId().getValue())
                            .quantity(orderLine.getQuantity())
                            .price(orderLine.getPrice())
                            .build();
                })
                .toList();

        OrderEntity orderEntityToSave = OrderEntity.builder()
                .status(order.getStatus())
                .customerId(order.getCustomerId().getValue())
                .orderLines(orderLinesEntities)
                .build();
        orderLinesEntities.forEach(orderLineEntity -> orderLineEntity.setOrder(orderEntityToSave));
        OrderEntity orderEntity = orderJpaRepository.save(orderEntityToSave);
        OrderId orderId = new OrderId(orderEntity.getId());
        order.setId(orderId);
        return order;
    }

    @Override
    public Order findById(OrderId orderId) {
        OrderEntity entity = orderJpaRepository.findById(orderId.getValue())
                .orElseThrow(() -> new IllegalArgumentException("Orden no encontrada no encontrado: " + orderId.getValue()));
        CustomerId customerId = new CustomerId(entity.getCustomerId());
        OrderId orderIdDomain = new OrderId(entity.getId());
        List<OrderLine> listOrderLine = entity.getOrderLines().stream().map(orderLineEntity -> {
            ProductId productId = new ProductId(orderLineEntity.getProductId());
            return OrderLine.builder()
                    .price(orderLineEntity.getPrice())
                    .quantity(orderLineEntity.getQuantity())
                    .productId(productId).build();
        }).toList();
        return Order.builder().id(orderIdDomain).orderLines(listOrderLine).customerId(customerId).status(entity.getStatus()).build();

    }
}
