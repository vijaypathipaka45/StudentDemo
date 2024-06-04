package com.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StudentExceptionHandler {

   @ExceptionHandler(value = StudentException.class)
   @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
   public ErrorResponse handleCustomerAlreadyExistsException(StudentException ex){

	   ErrorResponse response= new ErrorResponse();
	   response.setStatusCode(422);
	   response.setMessage(ex.getMessage());
	   return response;
	   }
	
   @ExceptionHandler(value = Exception.class)
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   public ErrorResponse handleCustomerAlreadyExistsException(Exception ex){

	   ErrorResponse response= new ErrorResponse();
	   response.setStatusCode(500);
	   response.setMessage("something went wrong please contact Administrator");
	   return response;
	   }
	
}
