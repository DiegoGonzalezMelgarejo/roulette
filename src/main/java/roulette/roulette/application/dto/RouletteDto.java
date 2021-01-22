package roulette.roulette.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RouletteDto {
    private String id;
    private String status;
    private List<BetDto> betDtos;

    public RouletteDto(String id, String status) {
        this.id = id;
        this.status = status;
    }
}
