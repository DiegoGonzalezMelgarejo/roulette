package roulette.roulette.application.dto;

import lombok.Getter;
import roulette.roulette.domain.User;

@Getter
public class BetDto {
    private String id;
    private int number;
    private String color;
    private Double cash;
    private UserDto userDto;

    public BetDto(String id, int number, String color, Double cash, UserDto userDto) {
        this.id = id;
        this.number = number;
        this.color = color;
        this.cash = cash;
        this.userDto = userDto;
    }

}
