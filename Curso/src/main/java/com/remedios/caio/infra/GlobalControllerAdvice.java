package com.remedios.caio.infra;

import com.remedios.caio.exceptions.ArgumentNotValidException;
import com.remedios.caio.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratador400(Exception e){
        Map<String, Object> body = new HashMap<>();

        body.put("message", "Bad request");
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    // Tratamento de exceções para Recurso não encontrado!

//    @ExceptionHandler(EntityNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ResponseBody
//    public ResponseEntity<Object> handleEntityNotFound(Exception e){
//        Map<String, Object> body = new HashMap<String, Object>();
//        body.put("message", "Resource not found!");
//
//        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
//    }
}
