package roulette.roulette.application.mapper;

import org.springframework.stereotype.Component;
import roulette.roulette.application.dto.BetDto;
import roulette.roulette.domain.Bet;

import java.util.ArrayList;
import java.util.List;

@Component
public class BetMapper {


    public static Bet createBet(BetDto betDto){
        Bet bet=new Bet(betDto.getId(), betDto.getNumber(),betDto.getColor(),betDto.getCash());
        bet.setCashWinning(betDto.getCashWinning());
        bet.setStatus(betDto.getStatus());
        return bet ;
    }
    public static  BetDto createBetDto(Bet bet){
        BetDto betDto =new BetDto(bet.getId() ,bet.getNumber(),bet.getColor(),bet.getCash(),UserMapper.CreaeteUserDto(bet.getUser()));
            betDto.setCashWinning(bet.getCashWinning());
            betDto.setStatus(bet.getStatus());
        return betDto;

    }
    public static List<Bet>  converterListBetDtoToBet(List<BetDto> betDtos){
        List<Bet> bets= new ArrayList<>();
        betDtos.forEach((final BetDto betDto)->bets.add(createBet(betDto)));
        return bets;
    }
    public static List<BetDto>  converterListBetToBetDto(List<Bet> bets){
        List<BetDto> betDtos= new ArrayList<>();
        bets.forEach((final Bet bet)->betDtos.add(createBetDto(bet)));
        return betDtos;
    }
}
