package ch.nyp.noa.webContext.exceptionHandling;

public class EntityNotFoundException extends RuntimeException{

	public EntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityNotFoundException(String message) {
		super(message);
	}

	public EntityNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
