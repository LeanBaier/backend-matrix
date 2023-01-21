package com.matriz.lb.products.controller.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductsControllerErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(){
        return ResponseEntity.internalServerError().body("Service Error!");
    }

}
