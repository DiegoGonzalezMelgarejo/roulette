package roulette.roulette.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import roulette.roulette.application.dto.BetDto;
import roulette.roulette.application.dto.RouletteDto;
import roulette.roulette.application.handler.CreateBetHandler;
import roulette.roulette.application.handler.CreateRouletteHandler;
import roulette.roulette.application.handler.GetRouletteHandler;
import roulette.roulette.application.handler.OpenRouletteHandler;
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
private final OpenRouletteHandler openRouletteHandler;
private final CreateBetHandler createBetHandler;
    public RouletteController(CreateRouletteHandler createRouletteHandler, GetRouletteHandler getRouletteHandler, OpenRouletteHandler openRouletteHandler,CreateBetHandler createBetHandler) {
        this.createRouletteHandler = createRouletteHandler;
        this.getRouletteHandler = getRouletteHandler;
        this.openRouletteHandler = openRouletteHandler;
        this.createBetHandler=createBetHandler;
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

    @PostMapping("/open/{id}")
    public  ResponseEntity<ResponseDto> openRoulette(@PathVariable("id") String id){
        String response=this.openRouletteHandler.openRoulette(id);
        return new ResponseEntity<>(new ResponseDto(response), HttpStatus.ACCEPTED);
    }

    @PostMapping("/bet/{id}")
    public ResponseEntity<ResponseDto> createApuesta(@PathVariable("id") String id,
                                                     @RequestHeader(value = "userId",required = true) String userId,
                                                     @RequestBody BetDto betDto){

        String message=this.createBetHandler.createBet(id,userId,betDto);
        return new ResponseEntity<>(new ResponseDto(message), HttpStatus.CREATED);

    }
}
