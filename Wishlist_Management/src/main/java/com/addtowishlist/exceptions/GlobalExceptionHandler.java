package com.addtowishlist.exceptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
	

	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> myExpHandler(UserException ie, WebRequest req)  {
		
		ErrorDetails err= new ErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		
		
	 return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	
	}

	@ExceptionHandler(WishlistItemException.class)
	public ResponseEntity<ErrorDetails> myExpHandler(WishlistItemException ie, WebRequest req)  {

		ErrorDetails err= new ErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));



		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);

	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> myExpHandler(MethodArgumentNotValidException ie, WebRequest req)  {
		
		ErrorDetails err= new ErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		
		
	 return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	
	}
	
	
	//when you try to push data which does not have proper structure
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorDetails> myExpHandler(ConstraintViolationException ie, WebRequest req)  {
		
		ErrorDetails err= new ErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		
		
	 return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	
	}
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> myanyExphandler(Exception ie, WebRequest req)  {
		
		ErrorDetails err= new ErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		
	 return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	
	}
	
		@ExceptionHandler(NoHandlerFoundException.class)
		public ResponseEntity<ErrorDetails> myNotFoundHandler(NoHandlerFoundException nfe,WebRequest req)  {
				
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
		
			return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
						
		}
			
	
	
	
	
}
