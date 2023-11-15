package com.ecommerce.domain.model;

import java.math.BigDecimal;
import com.ecommerce.domain.model.ProductId;
import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class Product {
    private ProductId id;
    private String name;
    private BigDecimal price;
}
