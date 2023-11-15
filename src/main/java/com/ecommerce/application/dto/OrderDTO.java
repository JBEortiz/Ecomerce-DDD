package com.ecommerce.application.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class OrderDTO {
    private Long id; // Se asume que el ID se representa como Long para los DTOs
    private Long customerId; // Simplificado para el DTO
    private List<OrderLineDTO> orderLines;
    private String status; // Esto podría ser el nombre de la enumeración de OrderStatus
}
