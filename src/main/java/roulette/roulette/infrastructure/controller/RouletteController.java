package roulette.roulette.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import roulette.roulette.application.dto.RouletteDto;
import roulette.roulette.application.handler.CreateRouletteHandler;
import roulette.roulette.application.mapper.RouletteMapper;
import roulette.roulette.domain.Roulette;
import roulette.roulette.infrastructure.controller.dto.ResponseDto;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class RouletteController {

private final CreateRouletteHandler createRouletteHandler;

    public RouletteController(CreateRouletteHandler createRouletteHandler) {
        this.createRouletteHandler = createRouletteHandler;
    }
    @PostMapping("/")
    public ResponseEntity<ResponseDto> createRoulette(){
        RouletteDto rouletteDto= new RouletteDto(UUID.randomUUID().toString(),false);
        String response= this.createRouletteHandler.createRoullette(rouletteDto);
        return new ResponseEntity<>(new ResponseDto(response), HttpStatus.CREATED);
    }
}
