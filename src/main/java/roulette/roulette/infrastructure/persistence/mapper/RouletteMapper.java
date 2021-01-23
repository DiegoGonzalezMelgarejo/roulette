package roulette.roulette.infrastructure.persistence.mapper;

import roulette.roulette.domain.Roulette;
import roulette.roulette.infrastructure.persistence.entities.RouletteEntity;

import java.util.ArrayList;
import java.util.List;

public class RouletteMapper {


    public  static RouletteEntity CreateRouletteEntity(Roulette roulette){
        RouletteEntity rouletteEntity = new RouletteEntity(roulette.getId(), roulette.getState());
        rouletteEntity.setColorWinning(roulette.getColorWinning());
        rouletteEntity.setNumberWinning(roulette.getNumberWinning());
        if(roulette.getBets()!=null)
             rouletteEntity.setBets(BetMapper.converterListBetToListBetEntity(roulette.getBets()));
        return rouletteEntity ;
    }
    public  static  Roulette CreateRoulette(RouletteEntity rouletteEntity){
        Roulette roulette=new Roulette(rouletteEntity.getId(),rouletteEntity.getStatus());
        roulette.setNumberWinning(rouletteEntity.getNumberWinning());
        roulette.setColorWinning(rouletteEntity.getColorWinning());
        if(rouletteEntity.getBets()!=null)
            roulette.setBets(BetMapper.converterListBetEntityToListBet(rouletteEntity.getBets()));
        return roulette;
    }
    public static List<Roulette> converterListRouletteEntityToListRoulette(List<RouletteEntity> rouletteEntities){
        List<Roulette>rouletteList= new ArrayList<>();
        rouletteEntities.forEach((final RouletteEntity rouletteEntity)-> rouletteList.add(CreateRoulette(rouletteEntity)));
        return rouletteList;
    }


}
