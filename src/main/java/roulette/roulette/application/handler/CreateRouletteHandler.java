package roulette.roulette.application.handler;

import org.springframework.stereotype.Component;
import roulette.roulette.application.dto.RouletteDto;
import roulette.roulette.application.mapper.RouletteMapper;
import roulette.roulette.domain.Roulette;
import roulette.roulette.domain.service.CreateRouletteService;
@Component
public class CreateRouletteHandler {
    private final CreateRouletteService createRouletteService;

    public CreateRouletteHandler(CreateRouletteService createRouletteService) {
        this.createRouletteService = createRouletteService;

    }

    public  String createRoullette(RouletteDto rouletteDto){
        Roulette roulette=RouletteMapper.createRoulette(rouletteDto);
        return this.createRouletteService.CreateRoulette(roulette);
    }
}
