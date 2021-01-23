package roulette.roulette.application.handler;

import org.springframework.stereotype.Component;
import roulette.roulette.application.dto.RouletteDto;
import roulette.roulette.application.mapper.RouletteMapper;
import roulette.roulette.domain.service.GetRouletteService;

import java.util.List;
@Component
public class GetRouletteHandler {
    private final GetRouletteService getRouletteService;

    public GetRouletteHandler(GetRouletteService getRouletteService) {
        this.getRouletteService = getRouletteService;
    }

    public List<RouletteDto> getRouletteDto(){
        List<RouletteDto>rouletteDtos=
                RouletteMapper.converterListRouletteToLisstRouletteDto(this.getRouletteService.getRoulettes());
        return rouletteDtos;
    }
}
