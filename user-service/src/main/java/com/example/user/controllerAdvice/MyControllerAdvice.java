package com.example.user.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.user.customException.BusinessException;

@ControllerAdvice
public class MyControllerAdvice{

	
	@ExceptionHandler(BusinessException.class) 
    public ResponseEntity<String> reponseMyException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Global Exception Implementation : "+e.getMessage());
    }

}
