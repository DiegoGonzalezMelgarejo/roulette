package roulette.roulette.application.handler;

import org.springframework.stereotype.Component;
import roulette.roulette.application.dto.BetDto;
import roulette.roulette.application.mapper.BetMapper;
import roulette.roulette.domain.Bet;
import roulette.roulette.domain.service.CreateBetService;

@Component
public class CreateBetHandler {

    private  final CreateBetService createBetService;

    public CreateBetHandler(CreateBetService createBetService) {
        this.createBetService = createBetService;
    }

    public String createBet(String idRoulette, String idUser, BetDto betDto){

        this.createBetService.createBet(idRoulette,idUser, BetMapper.createBet(betDto));
        return "Apuesta Creada";
    }
}
