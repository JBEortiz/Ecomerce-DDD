package com.ecommerce.application.factory;

import com.ecommerce.application.dto.OrderLineDTO;
import com.ecommerce.domain.model.OrderLine;
import com.ecommerce.domain.model.ProductId;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class OrderFactory {

    public List<OrderLine> createOrderLineDomain(List<OrderLineDTO> orderLines){
        return orderLines.stream()
                .map(orderLineDTO -> {
                    ProductId productId = new ProductId(orderLineDTO.getProductId());
                    return new OrderLine(productId, orderLineDTO.getQuantity(), orderLineDTO.getPrice());
                })
                .toList();
    }

    public List<OrderLineDTO> createOrderLineDto(List<OrderLine> orderLinesDto){
        return orderLinesDto.stream()
                .map(orderLine -> {
                    return OrderLineDTO.builder()
                            .productId(orderLine.getProductId().getValue())
                            .quantity(orderLine.getQuantity())
                            .price(orderLine.getPrice()).build();
                })
                .toList();
    }
}
