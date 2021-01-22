package roulette.roulette.application.mapper;

import org.springframework.stereotype.Component;
import roulette.roulette.application.dto.RouletteDto;
import roulette.roulette.domain.Roulette;

import java.util.ArrayList;
import java.util.List;

@Component
public class RouletteMapper {



    public static Roulette createRoulette(RouletteDto rouletteDto){
        return new Roulette(rouletteDto.getId(), converterStateRoulettetoBoolean(rouletteDto.getStatus()));
    }

    public static  RouletteDto createRouletteDto(Roulette roulette){
        return new RouletteDto(roulette.getId(),converterStateRoulettetoString(roulette.getState()));
    }

    private static Boolean converterStateRoulettetoBoolean(String state){
        Boolean stateConvert=state.equalsIgnoreCase("cerrada")?false:true;
        return stateConvert;

    }
    private static String converterStateRoulettetoString(Boolean state){
        String stateConvert=!state?"cerrada":"abierta";
        return stateConvert;

    }
    public static List<RouletteDto> converterListRouletteToLisstRouletteDto(List<Roulette> rouletteList){
    List<RouletteDto> rouletteDtos= new ArrayList<>() ;
    rouletteList.forEach((final Roulette roulette)->rouletteDtos.add(createRouletteDto(roulette)));
    return rouletteDtos;
    }
}
