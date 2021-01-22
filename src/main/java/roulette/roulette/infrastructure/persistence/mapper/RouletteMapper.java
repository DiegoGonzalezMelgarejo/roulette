package roulette.roulette.infrastructure.persistence.mapper;

import roulette.roulette.domain.Roulette;
import roulette.roulette.infrastructure.persistence.entities.RouletteEntity;

public class RouletteMapper {


    public  static RouletteEntity CreateRouletteEntity(Roulette roulette){
        return new RouletteEntity(roulette.getId(), roulette.getState());
    }
    public  static  Roulette CreateRoulette(RouletteEntity rouletteEntity){
        return new Roulette(rouletteEntity.getId(),rouletteEntity.getStatus());
    }
}
