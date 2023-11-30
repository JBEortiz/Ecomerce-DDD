package com.ecommerce.domain.ports.out;

import com.ecommerce.application.dto.CreateOrderDTO;
import com.ecommerce.application.dto.responses.CreateOrderReponseDTO;
import com.ecommerce.domain.model.Order;
import com.ecommerce.domain.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface OrderService {
    Product getProductById(Long id);

    CreateOrderReponseDTO createOrder(CreateOrderDTO createOrderDTO) throws JsonProcessingException;

    Order getOrderById(Long id);
}
