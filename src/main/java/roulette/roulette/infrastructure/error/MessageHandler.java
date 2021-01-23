package roulette.roulette.infrastructure.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageHandler {
private String message;

    public MessageHandler(String message) {
        this.message = message;
    }
}
