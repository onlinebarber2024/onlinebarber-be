package com.rf.onlinebarber.exception_management;

import com.rf.onlinebarber.dto.ApiResponse;
import com.rf.onlinebarber.exception.UserNotFoundException;
import com.rf.onlinebarber.model.Customer;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // validasyon hataları
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> validationExceptionManagement(MethodArgumentNotValidException exception, HttpServletRequest http){
        Map<String,String> errors=new HashMap<>();
        for(FieldError fieldError : exception.getFieldErrors()){
            errors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ApiResponse<Void> response=ApiResponse.<Void>builder().
        status(400).path(http.getRequestURI()).message("Doğrulama Hatası").errors(errors).dateTime(LocalDateTime.now()).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    // Kullanıcı bulunamadı hatası
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> notFoundException(UserNotFoundException exception,HttpServletRequest request){
        ApiResponse<Void> apiResponse=ApiResponse.<Void>builder().status(404).message(exception.getMessage()).dateTime(LocalDateTime.now())
                .path(request.getRequestURI()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }
}
