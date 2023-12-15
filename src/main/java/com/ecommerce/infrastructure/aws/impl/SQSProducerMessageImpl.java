package com.ecommerce.infrastructure.aws.impl;

import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;

import com.ecommerce.application.dto.OrderLineDTO;
import com.ecommerce.domain.model.Order;
import com.ecommerce.infrastructure.aws.SQSProducerMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.core.interceptor.ExecutionInterceptor;

import java.util.*;
import java.util.function.Consumer;

@Component
public class SQSProducerMessageImpl implements SQSProducerMessage, ExecutionInterceptor {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;
    @Value("${cloud.aws.credentials.access-key}")
    private String awsAccessKey;
    @Value("${cloud.aws.credentials.secret-key}")
    private String awsSecretKey;

    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;

    @Override
    public void sendCreateOrderMessage(List<OrderLineDTO> orderLinesDto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String messageJson = mapper.writeValueAsString(orderLinesDto);
        queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(messageJson).build());

    }

    @Override
    public void sendGetByIdOrderMessage(Order order) throws JsonProcessingException {

    }
/*
    @Override
    public void sendGetByIdOrderMessage(Order order) throws JsonProcessingException {
        List<String > attributeList= new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        String messageJson = mapper.writeValueAsString(order);
        attributeList.add(messageJson);
        MessageAttributeValue attributeValue = MessageAttributeValue.builder()
                .dataType("ORDER")
                .stringValue(order.getId().toString())
                .build();

        Map<String, MessageAttributeValue> message= new HashMap<>();
        message.put("String",attributeValue);
        SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                .queueUrl(endpoint)
                .messageBody(messageJson)
                .messageAttributes(message)
                .build();
        SqsClient sqsClient = SqsClient.builder()
                .region(Region.EU_NORTH_1) // Reemplaza YOUR_REGION con tu región AWS
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(awsAccessKey, awsSecretKey)))
                .build();
        sqsClient.sendMessage(sendMessageRequest);
    }
}*/
}