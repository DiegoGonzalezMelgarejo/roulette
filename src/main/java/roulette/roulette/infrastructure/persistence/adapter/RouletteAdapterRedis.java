package roulette.roulette.infrastructure.persistence.adapter;

import org.springframework.stereotype.Repository;
import roulette.roulette.domain.Roulette;
import roulette.roulette.domain.port.RoulettePort;
@Repository
public class RouletteAdapterRedis implements RoulettePort {
    @Override
    public void CreateRoulette(Roulette roulette) {

    }
}
