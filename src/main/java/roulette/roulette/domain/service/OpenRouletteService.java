package roulette.roulette.domain.service;

import roulette.roulette.domain.Roulette;
import roulette.roulette.domain.port.RoulettePort;

public class OpenRouletteService {

    private final RoulettePort roulettePort;

    public OpenRouletteService(RoulettePort roulettePort) {
        this.roulettePort = roulettePort;
    }
    public String OpenRoulette(String id){
        Roulette roulette=this.roulettePort.findRouletteById(id);
        roulette.setState(true);
        this.roulettePort.update(roulette);

        return "La Ruleta con identificador " + roulette.getId()+ " fue abierta";
    }

}
