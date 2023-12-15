package com.ecommerce.infrastructure.aws;

import com.ecommerce.application.dto.OrderLineDTO;
import com.ecommerce.domain.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

import java.util.List;


public interface SQSProducerMessage {
    void sendCreateOrderMessage(List<OrderLineDTO> orderLinesDto) throws JsonProcessingException;

    void sendGetByIdOrderMessage(Order order) throws JsonProcessingException;
}
