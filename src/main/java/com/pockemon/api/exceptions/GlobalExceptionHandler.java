package com.pockemon.api.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    // interceptor
    @ExceptionHandler(PokemonNotFoundException.class)
    public ResponseEntity<ErrorResponseObject> handlePokemonNotFound(PokemonNotFoundException ex, WebRequest request){
        ErrorResponseObject errorResponseObject = new ErrorResponseObject();

        errorResponseObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponseObject.setMessage(ex.getMessage());
        errorResponseObject.setTimestamp(new Date());

        return new ResponseEntity<ErrorResponseObject>(errorResponseObject, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseEntity<ErrorResponseObject> handleReviewNotFound(ReviewNotFoundException ex, WebRequest request){
        ErrorResponseObject errorResponseObject = new ErrorResponseObject();

        errorResponseObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponseObject.setMessage(ex.getMessage());
        errorResponseObject.setTimestamp(new Date());

        return new ResponseEntity<ErrorResponseObject>(errorResponseObject, HttpStatus.NOT_FOUND);
    }
}
