package com.javanaut.stockAlertObserver.exception.handler;

import com.javanaut.stockAlertObserver.exception.ProductNotFoundException;
import com.javanaut.stockAlertObserver.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> productNotFoundHandler(ProductNotFoundException ex){
        return ResponseEntity.badRequest().body(buildErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> userNotFoundHandler(UserNotFoundException ex){
        return ResponseEntity.badRequest().body(buildErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND));
    }

    private Map<String, String> buildErrorResponse(String message, HttpStatus status) {
        Map<String, String> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now().toString());
        errorDetails.put("status", status.toString());
        errorDetails.put("message", message);
        return errorDetails;
    }
}
