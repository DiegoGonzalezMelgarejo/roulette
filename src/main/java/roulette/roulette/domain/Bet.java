package roulette.roulette.domain;

import lombok.Getter;
import roulette.roulette.domain.exception.BetCashException;
import roulette.roulette.domain.exception.BetColorException;
import roulette.roulette.domain.exception.BetNumberException;
import roulette.roulette.domain.exception.BetTypeException;

import java.util.UUID;

@Getter
public class Bet {
    private String id;
    private String color;
    private  int number;
    private Double cash;
    private User user;
    private static final String ERRORNUMBER="El numero debe estar entre 0 y 36";
    private static final String ROJO="rojo";
    private static final String NEGRO="negro";
    private static  final String ERRORCOLOR="Este color no es posible";
    private static  final String ERRORCOMBINATION="Combinación no posible";
    private static  final String ERRORTYPE="Debes apostar solo por numero o solo por color";
    private static  final String ERORRCASH="Valor de apuesta no válido";
    private static final int NUMBERMINIMUM=-1;
    private static  final int NUMBERMAXIMUM=36;
    private  static  final Double BETMINIMUN=0D;
    private static  final Double BETMAXIMUM=10000D;
    public Bet(String id,  int number,String color,Double cash) {
        if(number<NUMBERMINIMUM || number>NUMBERMAXIMUM) throw new BetNumberException(ERRORNUMBER);
        if(color!=""&& color!=null&&(!color.equalsIgnoreCase(ROJO)&& !color.equalsIgnoreCase(NEGRO))) throw new BetColorException(ERRORCOLOR);
        if(color!=null&&number>-1) throw new BetTypeException(ERRORTYPE);
        if(cash>BETMINIMUN && cash>BETMAXIMUM)throw new BetCashException(ERORRCASH);
        this.id = UUID.randomUUID().toString();
        this.color = color;
        this.number = number;
        this.cash = cash;

    }
    public  void setUser(User user){
        this.user=user;
    }
}
