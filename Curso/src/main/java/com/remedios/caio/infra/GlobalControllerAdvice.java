package com.remedios.caio.infra;

import com.remedios.caio.dtos.ExceptionDTO;
import com.remedios.caio.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

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
        var erros = e.getFieldErrors();

        var body = Map.of("message", erros.stream().map(ExceptionDTO::new).collect(Collectors.toList()));

        return ResponseEntity.badRequest().body(body);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<?> handleArgumentNotValidException(MethodArgumentNotValidException e){
//        List<FieldError> erros = e.getFieldErrors();
//
//        Map<String, Object> body = new HashMap<>();
//        body.put("message", erros.stream().map(ExceptionDTO::new).collect(Collectors.toList()));
//
//        return ResponseEntity.badRequest().body(body);
//    }

    // Tratamento de exceções para Recurso não encontrado!
}
