package roulette.roulette.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Roulette {

    private String id;
    private Boolean state;
    private List<Bet> bets;

    public Roulette(String id, Boolean state) {
        this.id = id;
        this.state = state;
        this.bets= new ArrayList<>();
    }

    public  void setState(Boolean state){
        this.state=state;
    }
    public void setBets(List<Bet> bets){
        this.bets=bets;
    }
}
