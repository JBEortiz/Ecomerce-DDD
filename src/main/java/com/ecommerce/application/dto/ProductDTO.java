package com.ecommerce.application.dto;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class ProductDTO {
    private Long id; // Se asume que el ID se representa como Long para los DTOs
    private String name;
    private BigDecimal price;
}
