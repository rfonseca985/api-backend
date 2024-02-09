package com.rfonseca985.projeto_backend.handler;

import com.rfonseca985.projeto_backend.model.error.ErrorMessage;
import com.rfonseca985.projeto_backend.model.excepition.ResourceNotFoundExcepition;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExcepitionHandler {

    @ExceptionHandler(ResourceNotFoundExcepition.class)
    public ResponseEntity<?>handleResourceNotFoundExcepition(ResourceNotFoundExcepition ex){

        ErrorMessage error = new ErrorMessage("Not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return  new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
