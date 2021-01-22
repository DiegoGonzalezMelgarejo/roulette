package roulette.roulette.infrastructure.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@RedisHash("User")
public class UserEntity {

    @Id
    private String id;
    private String name;
    private Double money;

    public UserEntity() {
    }
}
