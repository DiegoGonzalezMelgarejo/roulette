package roulette.roulette.domain.service;

import roulette.roulette.domain.Roulette;
import roulette.roulette.domain.port.RoulettePort;

import java.util.List;

public class GetRouletteService {
    private final RoulettePort roulettePort;

    public GetRouletteService(RoulettePort roulettePort) {
        this.roulettePort = roulettePort;
    }

    public List<Roulette> getRoulettes(){
      return   this.roulettePort.getRoulettes();
    }
}
