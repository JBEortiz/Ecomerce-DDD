package com.ecommerce.domain.ports.out;

import com.ecommerce.application.dto.CreateOrderDTO;
import com.ecommerce.application.dto.responses.CreateOrderReponseDTO;
import com.ecommerce.domain.model.Order;
import com.ecommerce.domain.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface OrderService {
    Product getProductById(Long id);

    CreateOrderReponseDTO createOrder(CreateOrderDTO createOrderDTO) throws JsonProcessingException;

    Order getOrderById(Long id) throws JsonProcessingException;

    List<Order> getAll();
}
