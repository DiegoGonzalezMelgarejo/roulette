package roulette.roulette.domain.port;

import roulette.roulette.domain.Roulette;

import java.util.List;

public interface RoulettePort {

    void createRoulette(Roulette roulette);
    List<Roulette> getRoulettes();
    void openRoulette(Roulette roulette);
    Roulette findRouletteById(String id);
    void update(Roulette roulette);
}
