package roulette.roulette.infrastructure.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Bet")
@Getter
@Setter
public class BetEntity implements Serializable {

        private  String id;
        private int number;
        private String color;
        private Double cash;
        private Double cashWinning;
        private UserEntity user;
        private String status;


    public BetEntity() {
    }
}
