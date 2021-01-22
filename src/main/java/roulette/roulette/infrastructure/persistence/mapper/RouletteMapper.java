package roulette.roulette.infrastructure.persistence.mapper;

import roulette.roulette.domain.Roulette;
import roulette.roulette.infrastructure.persistence.entities.RouletteEntity;

import java.util.ArrayList;
import java.util.List;

public class RouletteMapper {


    public  static RouletteEntity CreateRouletteEntity(Roulette roulette){
        return new RouletteEntity(roulette.getId(), roulette.getState());
    }
    public  static  Roulette CreateRoulette(RouletteEntity rouletteEntity){
        return new Roulette(rouletteEntity.getId(),rouletteEntity.getStatus());
    }
    public static List<Roulette> converterListRouletteEntityToListRoulette(List<RouletteEntity> rouletteEntities){
        List<Roulette>rouletteList= new ArrayList<>();
        rouletteEntities.forEach((final RouletteEntity rouletteEntity)-> rouletteList.add(CreateRoulette(rouletteEntity)));
        return rouletteList;
    }
}
