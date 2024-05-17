package com.dailype.task.exceptions;

import lombok.Builder;

@Builder
public class BadRequestException extends  RuntimeException{
	
	 public BadRequestException(){
	        super("Bad Request Exception!!");
	    }

	    public BadRequestException(String message){
	        super(message);
	    }

	

}

