package roulette.roulette.application.mapper;

import org.springframework.stereotype.Component;
import roulette.roulette.application.dto.BetDto;
import roulette.roulette.domain.Bet;

@Component
public class BetMapper {


    public static Bet createBet(BetDto betDto){
        return new Bet(betDto.getId(), betDto.getNumber(),betDto.getColor(),betDto.getCash(),UserMapper.createUser(betDto.getUserDto()));
    }
    public static  BetDto createBetDto(Bet bet){
        return new BetDto(bet.getId() ,bet.getNumber(),bet.getColor(),bet.getCash(),UserMapper.CreaeteUserDto(bet.getUser()));
    }
}
