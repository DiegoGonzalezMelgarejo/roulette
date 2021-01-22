package roulette.roulette.infrastructure.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RedisHash("Roulette")
@Getter
@Setter
public class RouletteEntity implements Serializable {

    private String id;
    private Boolean status;
    private List<BetEntity> bets= new ArrayList<>();

    public RouletteEntity() {
    }
}
