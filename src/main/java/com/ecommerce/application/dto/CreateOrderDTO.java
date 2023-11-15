package com.ecommerce.application.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class CreateOrderDTO {
    private Long customerId; // Simplificado para el DTO
    private List<OrderLineDTO> orderLines;

}
