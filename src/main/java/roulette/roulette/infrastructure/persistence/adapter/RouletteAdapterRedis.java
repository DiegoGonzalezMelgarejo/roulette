package roulette.roulette.infrastructure.persistence.adapter;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import roulette.roulette.domain.Roulette;
import roulette.roulette.domain.port.RoulettePort;
import roulette.roulette.infrastructure.persistence.entities.RouletteEntity;
import roulette.roulette.infrastructure.persistence.mapper.RouletteMapper;

import java.util.List;

@Repository
public class RouletteAdapterRedis implements RoulettePort {

    private static final Object HEADER = "Roulette";
    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    public RouletteAdapterRedis(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations=redisTemplate.opsForHash();
    }

    @Override
    public void createRoulette(Roulette roulette) {
        RouletteEntity rouletteEntity= RouletteMapper.CreateRouletteEntity(roulette);
    this.hashOperations.put(HEADER,rouletteEntity.getId(),rouletteEntity);
    }

    @Override
    public List<Roulette> getRoulettes() {
        return null;
    }
}
