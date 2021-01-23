package roulette.roulette.infrastructure.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import roulette.roulette.domain.exception.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    private  static final String ERRORMESSAGE="Hubo un error,por favor contacte al administrador";
    private static  final Map<String ,Integer> RESPONSEHTTP= new HashMap<>();

    public ErrorHandler() {
        this.RESPONSEHTTP.put(BetCashException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        this.RESPONSEHTTP.put(BetColorException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        this.RESPONSEHTTP.put(BetNumberException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        this.RESPONSEHTTP.put(BetTypeException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        this.RESPONSEHTTP.put(RouletteNoFoundException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        this.RESPONSEHTTP.put(RouletteStateException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
    }
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<MessageHandler> showException(Exception exception){
        ResponseEntity<MessageHandler> result;
        String nombreExcepcion=exception.getClass().getSimpleName();
        String mensaje=exception.getMessage();
        Integer codigo= RESPONSEHTTP.get(nombreExcepcion);
        if(codigo!=null){
            MessageHandler messageHandler=new MessageHandler(mensaje);
            result=new ResponseEntity<>(messageHandler,HttpStatus.valueOf(codigo));
        }else{
            MessageHandler messageHandler=new MessageHandler(ERRORMESSAGE);
            result=new ResponseEntity<>(messageHandler,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }
}
