package roulette.roulette.infrastructure.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@RedisHash("User")
public class UserEntity implements Serializable {

    @Id
    private String id;
    private String name;
    private Double money;

    public UserEntity() {
    }

    public UserEntity(String id, String name, Double money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }
}
