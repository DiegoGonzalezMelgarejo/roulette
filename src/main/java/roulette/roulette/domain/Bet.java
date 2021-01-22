package roulette.roulette.domain;

import lombok.Getter;

@Getter
public class Bet {
    private String id;
    private String color;
    private  int number;
    private Double cash;
    private User user;

    public Bet(String id,  int number,String color,Double cash, User user) {
        this.id = id;
        this.color = color;
        this.number = number;
        this.cash = cash;
        this.user = user;
    }
}
