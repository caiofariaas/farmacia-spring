package com.remedios.caio.infra;

import com.remedios.caio.dtos.ExceptionDTO;
import com.remedios.caio.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerAdvice {

    // Not Found Exception

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<Object> handleNotFoundException(Exception e) {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    // Argument Not Valid

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<?> handleArgumentNotValidException (MethodArgumentNotValidException e){
        return ResponseEntity.badRequest().body(Map.of("message",
                e.getFieldErrors().stream().map(ExceptionDTO::new).collect(Collectors.toList())));
    }

    // Usuário ou senha incorreta!

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ResponseEntity<Object> handleBadCredentialsException(){

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", "Usuário inexistente ou senha inválida");

        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }

    // Login Existente

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ResponseEntity<Object> handleIllegalArgumentException(Exception e){
        Map<String, Object> body = new HashMap<>();

        body.put("message", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

}
