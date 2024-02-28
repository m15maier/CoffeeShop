package ee.coffee.coffeeshop.controllers.advice;

import ee.coffee.coffeeshop.services.interfaces.CoffeeShopExeption;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Configuration for handling exceptions globally in the application.
 * This controller advice intercepts and handles various types of exceptions thrown by controllers.
 * Конфигурация для обработки исключений глобально в приложении.
 * Этот контроллер обрабатывает различные типы исключений, возникающих в контроллерах.
 */

@ControllerAdvice
@Slf4j
public class ExeptionHandler {
    
    private ResponseEntity<String> handle(Exception e, HttpStatus httpStatus) {
        log.error("Application error", e);
        return new ResponseEntity<>(e.getMessage(), httpStatus);
    }
    
    @ExceptionHandler(CoffeeShopExeption.class)
    public ResponseEntity<String> handleCoffeeShopExeption(Exception e) {
        return handle(e, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(Exception e) {
        return handle(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(Exception e){
        return handle(e, HttpStatus.BAD_REQUEST);
    }
}
