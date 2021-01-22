package roulette.roulette.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import roulette.roulette.application.dto.RouletteDto;
import roulette.roulette.application.handler.CreateRouletteHandler;
import roulette.roulette.application.handler.GetRouletteHandler;
import roulette.roulette.application.mapper.RouletteMapper;
import roulette.roulette.domain.Roulette;
import roulette.roulette.domain.service.GetRouletteService;
import roulette.roulette.infrastructure.controller.dto.ResponseDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class RouletteController {

private final CreateRouletteHandler createRouletteHandler;
private final GetRouletteHandler getRouletteHandler;


    public RouletteController(CreateRouletteHandler createRouletteHandler, GetRouletteHandler getRouletteHandler) {
        this.createRouletteHandler = createRouletteHandler;
        this.getRouletteHandler = getRouletteHandler;
    }

    @PostMapping("/")
    public ResponseEntity<ResponseDto> createRoulette(){
        RouletteDto rouletteDto= new RouletteDto(UUID.randomUUID().toString(),"cerrada");
        String response= this.createRouletteHandler.createRoullette(rouletteDto);
        return new ResponseEntity<>(new ResponseDto(response), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public  ResponseEntity<List<RouletteDto>> getRoulettes(){
        List<RouletteDto>rouletteDtos= this.getRouletteHandler.getRouletteDto();
        return new ResponseEntity<>(rouletteDtos,HttpStatus.OK);
    }
}
