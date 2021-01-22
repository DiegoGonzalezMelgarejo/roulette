package roulette.roulette.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import roulette.roulette.domain.port.RoulettePort;
import roulette.roulette.domain.service.CreateRouletteService;
import roulette.roulette.domain.service.GetRouletteService;

@Configuration
public class ConfigurationService {

    @Bean
    public CreateRouletteService createRouletteService(RoulettePort roulettePort){
        return new CreateRouletteService(roulettePort);
    }
    @Bean
    public GetRouletteService getRouletteService(RoulettePort roulettePort){
        return new GetRouletteService(roulettePort);
    }
}
