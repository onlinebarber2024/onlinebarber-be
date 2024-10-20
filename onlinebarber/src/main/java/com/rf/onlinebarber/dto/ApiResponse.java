package com.rf.onlinebarber.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ApiResponse <T>{
   private int status;
   private String path;
   private String message;
   private LocalDateTime dateTime=LocalDateTime.now();
   private Map<String,String> errors=new HashMap<>();
   public T data;



   public static <T> ApiResponse<T> ok(String message) {
      return ApiResponse.<T>builder()
              .dateTime(LocalDateTime.now())
              .status(200)
              .message(message)
              .build();
   }


   public static <T> ApiResponse<T> ok(String message, T data) {
      return ApiResponse.<T>builder()
              .dateTime(LocalDateTime.now())
              .status(200)
              .message(message)
              .data(data)
              .build();
   }

}
