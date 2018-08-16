package ch.nyp.noa.webContext.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorMessage> handleException(EntityNotFoundException exc) {
		ErrorMessage error = new ErrorMessage();
		error.setStatus(4001);
		//error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorMessage> handleException(Exception exc) {
		ErrorMessage error = new ErrorMessage();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<ErrorMessage> noException() {
		ErrorMessage error = new ErrorMessage();
		error.setStatus(4001);
		//error.setStatus(HttpStatus.OK.value());
		error.setMessage("Request executed successfully");
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
}
