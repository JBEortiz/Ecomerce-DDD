package com.ecommerce.infrastructure.aws.impl;

import com.ecommerce.application.dto.OrderLineDTO;
import com.ecommerce.infrastructure.aws.SQSProducerMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SQSProducerMessageImpl implements SQSProducerMessage {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;

    @Override
    public void sendCreateOrderMessage(List<OrderLineDTO> orderLinesDto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String messageJson = mapper.writeValueAsString(orderLinesDto);
        queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(messageJson).build());

    }
}
