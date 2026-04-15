package franquicias.narciris.franquicias.configuration.Handler;

import franquicias.narciris.franquicias.configuration.Custom.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationErrors(MethodArgumentNotValidException exce){
        Map<String,String> errors = new HashMap<>();
        exce.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public  ResponseEntity<Map<String,String>> handleUserNotFound(EntityNotFoundException exce){
        Map<String,String> errors = new HashMap<>();
        errors.put("message",exce.getMessage());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }
}
