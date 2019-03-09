package com.world.rest.controller;

import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.ConnectException;

@ControllerAdvice
public class ExceptionsHandler {

    /**
     * Handle the database server down error
     * @param exception the exception occured
     * @return
     */
    @ExceptionHandler(value = DataAccessResourceFailureException.class)
    public ResponseEntity<Object> hendleDatabaseDownExceptions(DataAccessResourceFailureException exception){
        return new ResponseEntity("INTERNAL_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
