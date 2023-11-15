package com.ecommerce.domain.model;

import java.util.Objects;

public class CustomerId {
    private final Long value;

    public CustomerId(Long value) {
        this.value = Objects.requireNonNull(value, "Customer ID cannot be null");
        // Additional validation can be added here
    }

    public Long getValue() {
        return value;
    }

    // ... equals, hashCode and toString methods ...
}
