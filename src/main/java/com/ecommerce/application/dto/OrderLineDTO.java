package com.ecommerce.application.dto;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderLineDTO {
    private Long productId;
    private int quantity;
    private BigDecimal price;
}
