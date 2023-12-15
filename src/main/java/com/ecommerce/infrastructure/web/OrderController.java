package com.ecommerce.infrastructure.web;

import com.ecommerce.application.dto.CreateOrderDTO;
import com.ecommerce.application.dto.responses.CreateOrderReponseDTO;
import com.ecommerce.domain.ports.out.OrderService;
import com.ecommerce.domain.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderApplicationService;

    @Autowired
    public OrderController(OrderService orderApplicationService) {
        this.orderApplicationService = orderApplicationService;
    }

    @PostMapping
    public CreateOrderReponseDTO createOrder(@RequestBody CreateOrderDTO createOrderDTO) throws JsonProcessingException {
        return orderApplicationService.createOrder(createOrderDTO);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) throws JsonProcessingException {
        return orderApplicationService.getOrderById(id);
    }

    @GetMapping("/all")
    public List<Order> getOrder() {
        return orderApplicationService.getAll();
    }
}
