package com.example.productsampleapi.advisor;

import com.example.productsampleapi.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class RestControllerAdvisor {
    // New One From Cher
    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<ErrorResponse<?>> handleResourceAlreadyExistException(ResourceAlreadyExistException ex) {
        var response = ErrorResponse.builder()
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CONFLICT.value())
                .build();
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);

    }

//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<ErrorResponse<Object>> handleNoSuchElementException(
//            NoSuchElementException ex) {
//
//        ErrorResponse<Object> errorResponse =
//                ErrorResponse.<Object>builder()
//                        .timestamp(LocalDateTime.now())
//                        .message(ex.getMessage())
//                        .status(HttpStatus.NOT_FOUND.value())
//                        .errors(null)
//                        .build();
//
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(errorResponse);
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorResponse<Map<String, String>>> handleMethodArgumentNotValidException(
//            MethodArgumentNotValidException ex) {
//
//        Map<String, String> errors = new HashMap<>();
//
//        ex.getBindingResult()
//                .getFieldErrors()
//                .forEach(error ->
//                        errors.put(
//                                error.getField(),
//                                error.getDefaultMessage()
//                        ));
//
//        ErrorResponse<Map<String, String>> errorResponse =
//                ErrorResponse.<Map<String, String>>builder()
//                        .timestamp(LocalDateTime.now())
//                        .message("Provided data is invalid")
//                        .errors(errors)
//                        .status(HttpStatus.BAD_REQUEST.value())
//                        .build();
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body(errorResponse);
//    }
}