package roulette.roulette.domain.service;

import roulette.roulette.domain.Roulette;
import roulette.roulette.domain.port.RoulettePort;

public class CreateRouletteService {

private final RoulettePort roulettePort;

    public CreateRouletteService(RoulettePort roulettePort) {
        this.roulettePort = roulettePort;
    }

    public String CreateRoulette(Roulette roulette){

        this.roulettePort.CreateRoulette(roulette);
        return roulette.getId();

}
}
