package roulette.roulette.domain.service;

import roulette.roulette.domain.Bet;
import roulette.roulette.domain.Roulette;
import roulette.roulette.domain.exception.RouletteStateException;
import roulette.roulette.domain.port.RoulettePort;
import roulette.roulette.domain.port.UserPort;

import java.util.List;

public class CloseRouletteService {
    private final RoulettePort roulettePort;
    private  final UserPort userPort;
    private static final String ERRORSTATE="La ruleta ya se encontraba cerrada";
    private  static  final String WINNING="Ganada";
    private  static  final String LOST="Perdida";
    public CloseRouletteService(RoulettePort roulettePort, UserPort userPort) {
        this.roulettePort = roulettePort;
        this.userPort = userPort;
    }

    public Roulette closeRoulette(String id){
        Roulette roulette=this.roulettePort.findRouletteById(id);
        if(!roulette.getState())throw  new RouletteStateException(ERRORSTATE);
        roulette.setNumberWinning(this.numberWinning());
        String colorWinning=roulette.getNumberWinning()%2==0?"rojo":"negro";
        roulette.setColorWinning(colorWinning);
        roulette=validateBets(roulette);
        roulette.setState(false);
        roulettePort.update(roulette);
        return roulette;
    }
    private int numberWinning(){
        return (int) ((Math.random() * (36 - 0)) + 36);
    }

    private Roulette validateBets(Roulette roulette){
        List<Bet>bets=roulette.getBets();
        for (Bet bet:bets) {
            if(bet.getNumber()>-1){
                if(bet.getNumber()==roulette.getNumberWinning()){
                    bet.setStatus(WINNING);
                    bet.getUser().setMoney((bet.getCash()*5)+ bet.getUser().getMoney());
                    this.userPort.updateUser(bet.getUser());
                }else{
                    bet.setStatus(LOST);
                }
            }else{
                if(bet.getColor().equalsIgnoreCase(roulette.getColorWinning())){
                    bet.getUser().setMoney((bet.getCash()*1.8)+ bet.getUser().getMoney());
                    bet.setStatus(WINNING);
                    this.userPort.updateUser(bet.getUser());
                }else{
                    bet.setStatus(LOST);
                }
            }
        }
        roulette.setBets(bets);
        return roulette;
    }
}
