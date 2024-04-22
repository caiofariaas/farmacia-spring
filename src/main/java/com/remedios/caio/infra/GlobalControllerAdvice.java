package com.remedios.caio.infra;

import com.remedios.caio.dtos.ExceptionDTO;
import com.remedios.caio.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<Object> handleNotFoundException(Exception e) {

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    // Perguntar se deixo como VAR ou se altero para a instancia da classe

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleArgumentNotValidException (MethodArgumentNotValidException e){
        return ResponseEntity.badRequest().body(Map.of("message",
                e.getFieldErrors().stream().map(ExceptionDTO::new).collect(Collectors.toList())));
    }

    // Senha incorreta!

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ResponseEntity<Object> handleBadCredentialsException(Exception e){

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }
}
