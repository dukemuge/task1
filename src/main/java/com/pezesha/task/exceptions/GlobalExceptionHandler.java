package com.pezesha.task.exceptions;

import com.pezesha.task.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundHandler(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(message,false);
        return new  ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<Map<String,String>> handleMethodArgInvalidException(MethodArgumentNotValidException ex){
        Map<String,String>  responseResults = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
                    String fieldName = ((FieldError)error).getField();
                    String message = error.getDefaultMessage();
                    responseResults.put(fieldName,message);
                }

        );
        return  new ResponseEntity<Map<String,String>>(responseResults,HttpStatus.BAD_REQUEST);

    }
}