package com.ecommerce.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
@Data
public class ProductId {
    private final Long value;

    public ProductId(Long value) {
        this.value = Objects.requireNonNull(value, "El ID del producto no puede ser nulo");
        // Agregar validación adicional si es necesario
    }

    public Long getValue() {
        return value;
    }



}
