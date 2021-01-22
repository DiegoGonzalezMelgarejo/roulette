package roulette.roulette.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String id;
    private String name;
    private Double money;

    public User(String id, String name, Double money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }
}