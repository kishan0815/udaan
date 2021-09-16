package exceptionHandler;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import exception.InsertionException;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(value = InsertionException.class)
	public ResponseEntity<Object> insertionException(InsertionException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	private ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}
