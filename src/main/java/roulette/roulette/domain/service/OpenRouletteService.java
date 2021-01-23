package roulette.roulette.domain.service;

import roulette.roulette.domain.Roulette;
import roulette.roulette.domain.exception.RouletteStateException;
import roulette.roulette.domain.port.RoulettePort;

public class OpenRouletteService {

    private final RoulettePort roulettePort;
    private static final String ERRORSTATE="La ruleta ya se encontraba abierta";
    public OpenRouletteService(RoulettePort roulettePort) {
        this.roulettePort = roulettePort;
    }
    public String OpenRoulette(String id){
        Roulette roulette=this.roulettePort.findRouletteById(id);
        if(roulette.getState()) throw new RouletteStateException(ERRORSTATE);
        roulette.setState(true);
        this.roulettePort.update(roulette);

        return "La Ruleta con identificador " + roulette.getId()+ " fue abierta";
    }

}
