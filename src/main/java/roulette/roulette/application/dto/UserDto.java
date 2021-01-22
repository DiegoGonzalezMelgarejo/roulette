package roulette.roulette.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String id;
    private String name;
    private Double money;

    public UserDto(String id, String name, Double money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }
}
