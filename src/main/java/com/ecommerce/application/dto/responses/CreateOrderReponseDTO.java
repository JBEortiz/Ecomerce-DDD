package com.ecommerce.application.dto.responses;

import com.ecommerce.application.dto.OrderLineDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class CreateOrderReponseDTO {
    private Long id; // Se asume que el ID se representa como Long para los DTOs
    private Long customerId; // Simplificado para el DTO
    private List<OrderLineDTO> orderLines;
    private String status; // Esto podría ser el nombre de la enumeración de OrderStatus
}
