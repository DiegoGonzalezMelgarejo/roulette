package roulette.roulette.domain.service;

import roulette.roulette.application.dto.BetDto;
import roulette.roulette.application.mapper.BetMapper;
import roulette.roulette.domain.Bet;
import roulette.roulette.domain.Roulette;
import roulette.roulette.domain.User;
import roulette.roulette.domain.exception.RouletteNoFoundException;
import roulette.roulette.domain.port.RoulettePort;
import roulette.roulette.domain.port.UserPort;

public class CreateBetService {
    private  final RoulettePort roulettePort;
    private  final UserPort userPort;
    private static  final String USERNAME="Username";
    private static  final Double MONEY=1000000d;
    private static  final  String ROULETTENOFOUND="Esa ruleta no existe";
    public CreateBetService(RoulettePort roulettePort,UserPort userPort) {
        this.roulettePort = roulettePort;
        this.userPort=userPort;
    }
    public void createBet(String idRoulette, String userId,Bet bet){
        Roulette roulette=this.roulettePort.findRouletteById(idRoulette);
        if (roulette==null) throw new RouletteNoFoundException(ROULETTENOFOUND);
        User user=null;
        user=this.userPort.findUserById(userId);
        if(user==null) {
            user = new User(userId, USERNAME + userId, MONEY);
        }
            this.userPort.createUser(user);
        bet.setUser(user);

        roulette.getBets().add(bet);
        this.roulettePort.update(roulette);
    }


}
