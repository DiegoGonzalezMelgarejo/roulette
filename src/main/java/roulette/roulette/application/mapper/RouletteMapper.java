package roulette.roulette.application.mapper;

import org.springframework.stereotype.Component;
import roulette.roulette.application.dto.RouletteDto;
import roulette.roulette.domain.Roulette;

@Component
public class RouletteMapper {



    public static Roulette createRoulette(RouletteDto rouletteDto){
        return new Roulette(rouletteDto.getId(), rouletteDto.getStatus());
    }

    public static  RouletteDto createRouletteDto(Roulette roulette){
        return new RouletteDto(roulette.getId(),roulette.getState());
    }
}
