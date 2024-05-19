package com.example.dice.assignment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex) throws JsonProcessingException {
        // Extract the message from the exception
        String errorMessage = ex.getMessage();

        int statusCode = getStatusCode(errorMessage);
        String message = getMessage(errorMessage);

        // Extract the HTTP status code from the exception
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR; // Default status code if not available
        if (HttpStatus.valueOf(statusCode) instanceof HttpStatus) {
            httpStatus = HttpStatus.valueOf(statusCode);
        }
        else {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        // Return the message as JSON with the corresponding status code
        return new ResponseEntity<>(message, httpStatus);
    }

    private int getStatusCode(String errorMessage) {
        String statusCodeString = errorMessage.substring(0,3);
        int statusCode = Integer.parseInt(statusCodeString);
        return statusCode;
    }

    private String getMessage(String errorMessage) {
        String[] parts = errorMessage.split(":");

        
        String jsonPart = parts[2].trim();

        
        jsonPart = jsonPart.replaceAll("[^a-zA-Z0-9\\s]", "");

        
        return jsonPart;
    }
}
