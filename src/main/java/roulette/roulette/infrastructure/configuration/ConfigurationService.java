package roulette.roulette.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import roulette.roulette.domain.port.RoulettePort;
import roulette.roulette.domain.service.CreateRouletteService;
import roulette.roulette.domain.service.GetRouletteService;
import roulette.roulette.domain.service.OpenRouletteService;

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
    @Bean
    public OpenRouletteService openRouletteService(RoulettePort roulettePort){
        return  new OpenRouletteService(roulettePort);
    }
}
