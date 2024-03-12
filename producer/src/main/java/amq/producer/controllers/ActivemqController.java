package amq.producer.controllers;

import amq.producer.model.Message;
import amq.producer.service.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
public class ActivemqController {
    private final Producer producer;

    @PostMapping
    public ResponseEntity<String> publish(@RequestBody Message message) {
        try {
            producer.send(message);
            return new ResponseEntity<>("Message Sent"
                    , HttpStatus.OK);

        } catch (Exception exception) {

            return new ResponseEntity<>(exception.getMessage()
                    , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
