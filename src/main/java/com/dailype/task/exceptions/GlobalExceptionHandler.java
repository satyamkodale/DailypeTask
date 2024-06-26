package com.dailype.task.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dailype.task.dtos.ApiResponseMessage;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	

	    //handler resource not found
	    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	    @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<ApiResponseMessage> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
	        logger.info("Exception Handler invoked !!");
	        ApiResponseMessage response = ApiResponseMessage.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).success(true).build();
	        return new ResponseEntity(response, HttpStatus.NOT_FOUND);

	    }

	    @ExceptionHandler(BadRequestException.class)
	    public ResponseEntity<ApiResponseMessage> badRequestExceptionHandler(BadRequestException ex) {
	        logger.info("Exception Handler invoked !!");
	        ApiResponseMessage response = ApiResponseMessage.builder().message(ex.getMessage()).status(HttpStatus.BAD_REQUEST).success(true).build();
	        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);

	    }
	    

}
