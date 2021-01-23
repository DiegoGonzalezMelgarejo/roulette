package roulette.roulette.application.mapper;

import org.springframework.stereotype.Component;
import roulette.roulette.application.dto.RouletteDto;
import roulette.roulette.domain.Roulette;

import java.util.ArrayList;
import java.util.List;

@Component
public class RouletteMapper {



    public static Roulette createRoulette(RouletteDto rouletteDto){
        Roulette roulette =new Roulette(rouletteDto.getId(), converterStateRoulettetoBoolean(rouletteDto.getStatus()));
      roulette.setColorWinning(rouletteDto.getColorWinning());
      roulette.setNumberWinning(rouletteDto.getNumberWinning());
        if(rouletteDto.getBetDtos()!=null)
            roulette.setBets(BetMapper.converterListBetDtoToBet(rouletteDto.getBetDtos()));
        return roulette;
    }

    public static  RouletteDto createRouletteDto(Roulette roulette){
        RouletteDto rouletteDto=new RouletteDto(roulette.getId(),converterStateRoulettetoString(roulette.getState()));
        rouletteDto.setColorWinning(roulette.getColorWinning());
        rouletteDto.setNumberWinning(roulette.getNumberWinning());
        if(roulette.getBets()!=null)
         rouletteDto.setBetDtos(BetMapper.converterListBetToBetDto(roulette.getBets()));
        return rouletteDto;
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
