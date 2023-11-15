package com.ecommerce.application.service.impl;

import com.ecommerce.application.dto.CreateOrderDTO;
import com.ecommerce.application.dto.OrderLineDTO;
import com.ecommerce.application.dto.responses.CreateOrderReponseDTO;
import com.ecommerce.domain.ports.out.OrderService;
import com.ecommerce.domain.model.*;
import com.ecommerce.application.repository.OrderRepository;
import com.ecommerce.application.factory.OrderFactory;
import java.util.List;

public class OrderApplicationServiceImpl implements OrderService {

    private final OrderRepository orderService;

    private final OrderFactory orderFactory;


    public OrderApplicationServiceImpl(OrderRepository orderService,OrderFactory orderFactory) {
        this.orderService = orderService;
        this.orderFactory = orderFactory;
    }

    @Override
    public Product getProductById(Long id) {
        ProductId productId = new ProductId(id);
        return orderService.getByIdProduct(productId);
    }

    @Override
    public CreateOrderReponseDTO createOrder(CreateOrderDTO createOrderDTO) {
        //tranformar con mappstruct
        List<OrderLine> orderLines = orderFactory.createOrderLineDomain(createOrderDTO.getOrderLines());
        CustomerId customerId = new CustomerId(createOrderDTO.getCustomerId());

        Order order = orderService.createOrder(customerId, orderLines);

        List<OrderLineDTO> orderLinesDto = orderFactory.createOrderLineDto(order.getOrderLines());

        return CreateOrderReponseDTO.builder()
                .orderLines(orderLinesDto)
                .id(order.getId().getValue())
                .status(order.getStatus().toString())
                .customerId(order.getCustomerId().getValue())
                .build();
    }

    @Override
    public Order getOrderById(Long id) {
        OrderId orderId = new OrderId(id);
        return orderService.findOrderById(orderId);
    }
}
