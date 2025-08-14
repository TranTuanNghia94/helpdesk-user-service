package com.it.user.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.it.user.enums.Constant;
import com.it.user.model.Kafka.KafkaMessage;
import com.it.user.model.Users.Login;
import com.it.user.model.Users.UserInfo;
import com.it.user.utils.KafkaMessageBuilder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaMessageHandler {
    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;
    private final UsersService userService;
    private final ObjectMapper objectMapper;

    private void sendMessage(KafkaMessage message, String topic) {
        log.info("Sending message to topic: {} | Message ID: {} | Status: {}", topic, message.getMessageId(), message.getStatus());
        kafkaTemplate.send(topic, message.getMessageId(), message);
    }

    private void sendErrorResponse(String messageId, String errorMessage) {
        KafkaMessage response = new KafkaMessage();
        response.setMessageId(messageId);
        response.setStatus(Constant.ResponseStatus.ERROR.getValue());
        response.setErrorMessage(errorMessage);
        sendMessage(response, Constant.USER_EVENT_RESPONSE);
    }

    @KafkaListener(topics = Constant.USER_EVENT_REQUEST, groupId = Constant.EVENT_GROUP)
    private void listenUserEvent(KafkaMessage message) {
        try {
            Login login = objectMapper.convertValue(message.getPayload(), Login.class);

            log.info("Processing login request - Message ID: {} | Username: {}", message.getMessageId(), login.getUsername());

            // Process the login event
            UserInfo userInfo = userService.loginUser(login);

            // Send response with the same messageId
            responseLoginEvent(userInfo, message.getMessageId());

        } catch (Exception e) {
            log.error("Error processing login event for messageId: {}", message.getMessageId(), e);
            sendErrorResponse(message.getMessageId(), e.getMessage());
        }
    }

    private void responseLoginEvent(UserInfo user, String messageId) {
        log.info("Successfully login response - Message ID: {} | Username: {}", messageId, user.getUsername());
        KafkaMessage response = KafkaMessageBuilder.buildKafkaMessage(Constant.OPERATION_LOGIN, Constant.ResponseStatus.SUCCESS.getValue(), user, messageId);
        sendMessage(response, Constant.USER_EVENT_RESPONSE);
    }

}
