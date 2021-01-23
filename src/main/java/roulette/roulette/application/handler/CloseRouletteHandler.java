package roulette.roulette.application.handler;

import org.springframework.stereotype.Component;
import roulette.roulette.application.dto.RouletteDto;
import roulette.roulette.application.mapper.RouletteMapper;
import roulette.roulette.domain.service.CloseRouletteService;
@Component
public class CloseRouletteHandler {

    private final CloseRouletteService closeRouletteService;

    public CloseRouletteHandler(CloseRouletteService closeRouletteService) {
        this.closeRouletteService = closeRouletteService;
    }

    public RouletteDto closeRoulette(String id){
        return RouletteMapper.createRouletteDto(this.closeRouletteService.closeRoulette(id));
    }
}
