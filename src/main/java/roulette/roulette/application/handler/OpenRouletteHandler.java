package roulette.roulette.application.handler;

import org.springframework.stereotype.Component;
import roulette.roulette.domain.service.OpenRouletteService;

@Component
public class OpenRouletteHandler {

    private final OpenRouletteService openRouletteService;

    public OpenRouletteHandler(OpenRouletteService openRouletteService) {
        this.openRouletteService = openRouletteService;
    }
    public String openRoulette(String id){
        return this.openRouletteService.OpenRoulette(id);
    }
}
