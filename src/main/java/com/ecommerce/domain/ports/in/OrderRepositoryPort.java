package com.ecommerce.domain.ports.in;

import com.ecommerce.domain.model.Order;
import com.ecommerce.domain.model.OrderId;

import java.util.Optional;

public interface OrderRepositoryPort {
    Order save(Order pedido);

    Order findById(OrderId orderId);
}
