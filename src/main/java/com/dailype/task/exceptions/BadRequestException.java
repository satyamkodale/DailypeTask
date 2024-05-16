package com.dailype.task.exceptions;

import lombok.Builder;

@Builder
public class BadRequestException extends  RuntimeException{
	
	 public BadRequestException(){
	        super("Resource not found !!");
	    }

	    public BadRequestException(String message){
	        super(message);
	    }

	

}

