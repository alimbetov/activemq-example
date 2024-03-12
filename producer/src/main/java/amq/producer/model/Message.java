package amq.producer.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Message {
    private String name;
    private String email;
    private String website;
}