package com.ecommerce.domain.model;

import lombok.Data;

import java.util.Objects;
@Data
public class OrderId {
    private final Long value;

    public OrderId(Long value) {
        this.value = Objects.requireNonNull(value, "Order ID cannot be null");
        // Additional validation can be added here
    }

    public Long getValue() {
        return value;
    }


}