package amq.producer.service;

import amq.producer.model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class Producer {


    private final ObjectMapper mapper;
    private final JmsTemplate jmsTemplate;

    @Value("${spring.artemis.embedded.queues}")
    private String artemisQueue;

    public void send(Message message) {
        try {
            String jmsMessage = mapper.writeValueAsString(message);

            jmsTemplate.convertAndSend(artemisQueue, jmsMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}