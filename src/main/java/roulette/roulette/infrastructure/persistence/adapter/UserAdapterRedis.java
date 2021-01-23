package roulette.roulette.infrastructure.persistence.adapter;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import roulette.roulette.application.dto.UserDto;
import roulette.roulette.domain.User;
import roulette.roulette.domain.port.UserPort;
import roulette.roulette.infrastructure.persistence.entities.UserEntity;
import roulette.roulette.infrastructure.persistence.mapper.UserMapper;

@Repository
public class UserAdapterRedis implements UserPort {

    private static final Object HEADER = "User";
    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    public UserAdapterRedis(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations=redisTemplate.opsForHash();
    }
    @Override
    public void createUser(User user) {
        UserEntity userEntity= UserMapper.createUserEntity(user);
        this.hashOperations.put(HEADER,userEntity.getId(),userEntity);
    }

    @Override
    public User findUserById(String id) {
        UserEntity userEntity=(UserEntity)this.hashOperations.get(HEADER,id);
        if(userEntity!=null)
        return UserMapper.createUser(userEntity);
        else
            return null;
    }
}
