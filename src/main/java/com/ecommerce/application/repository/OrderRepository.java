package com.ecommerce.application.repository;

import com.ecommerce.domain.model.*;
import com.ecommerce.domain.ports.in.OrderRepositoryPort;
import com.ecommerce.domain.ports.in.ProductRepositoryPort;

import java.util.List;
import java.util.Optional;

public class OrderRepository {
    private final OrderRepositoryPort orderRepository;
    private final ProductRepositoryPort productRepository;

    public OrderRepository(OrderRepositoryPort orderRepository, ProductRepositoryPort productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Product getByIdProduct(ProductId productId){
        return productRepository.findByIdProduct(productId);
    }

    public Order createOrder(CustomerId customerId, List<OrderLine> listOrder) {
        Order pedido = new Order(null,customerId, listOrder,OrderStatus.PENDING);
        listOrder.forEach(product -> {
           Product productFind= getByIdProduct(product.getProductId());
           product.setPrice(productFind.getPrice());
        });
        return orderRepository.save(pedido);
    }


    public Order findOrderById(OrderId orderId) {
        return orderRepository.findById(orderId);
    }


}
