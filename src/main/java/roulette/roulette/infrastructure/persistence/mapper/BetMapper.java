package roulette.roulette.infrastructure.persistence.mapper;

import roulette.roulette.application.dto.BetDto;
import roulette.roulette.domain.Bet;
import roulette.roulette.infrastructure.persistence.entities.BetEntity;

import java.util.ArrayList;
import java.util.List;

public class BetMapper {


    public static BetEntity createBetEntety(Bet bet){
        BetEntity betEntity = new BetEntity();
        betEntity.setId(bet.getId());
        betEntity.setNumber(bet.getNumber());
        betEntity.setCash(bet.getCash());
        betEntity.setUser(UserMapper.createUserEntity(bet.getUser()));
        betEntity.setColor(bet.getColor());
        betEntity.setCashWinning(bet.getCashWinning());
        betEntity.setStatus(bet.getStatus());
        return  betEntity;
    }

    public static  Bet createBet(BetEntity betEntity){
        Bet bet= new Bet(betEntity.getId(),betEntity.getNumber(),betEntity.getColor(),betEntity.getCash());
        bet.setUser(UserMapper.createUser(betEntity.getUser()));
        bet.setCashWinning(betEntity.getCashWinning());
        bet.setStatus(betEntity.getStatus());
        return bet;

    }

    public static List<Bet> converterListBetEntityToListBet(List<BetEntity> betEntities){
        List<Bet> bets= new ArrayList<>();
        betEntities.forEach((final BetEntity betEntity)->bets.add(createBet(betEntity)));
        return bets;
    }
    public static List<BetEntity> converterListBetToListBetEntity(List<Bet> bets){
        List<BetEntity> betEntities= new ArrayList<>();
        bets.forEach((final Bet bet)->betEntities.add(createBetEntety(bet)));
        return betEntities;
    }
}
