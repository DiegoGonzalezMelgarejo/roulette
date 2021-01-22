package roulette.roulette.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RouletteDto {
    private String id;
    private Boolean status;
    private List<BetDto> betDtos;

    public RouletteDto(String id, Boolean status) {
        this.id = id;
        this.status = status;
    }
}
