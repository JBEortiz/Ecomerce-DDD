package com.ecommerce.domain.ports.out;

import com.ecommerce.application.dto.CreateOrderDTO;
import com.ecommerce.application.dto.responses.CreateOrderReponseDTO;
import com.ecommerce.domain.model.Order;
import com.ecommerce.domain.model.Product;

public interface OrderService {
    Product getProductById(Long id);

    CreateOrderReponseDTO createOrder(CreateOrderDTO createOrderDTO);

    Order getOrderById(Long id);
}
