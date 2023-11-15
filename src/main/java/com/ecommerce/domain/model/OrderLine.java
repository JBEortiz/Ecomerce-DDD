package com.ecommerce.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Builder
@Data
public class OrderLine {
    private ProductId productId;
    private int quantity;
    private BigDecimal price;

    public OrderLine(ProductId productId, int quantity, BigDecimal price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public BigDecimal calculateSubtotal() {
        return price.multiply(new BigDecimal(quantity));
    }

}