package roulette.roulette.infrastructure.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {
    private String message;

    public ResponseDto(String message) {
        this.message = message;
    }

    public ResponseDto() {
    }
}
