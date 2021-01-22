package tn.iit.medicalFile.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotFoundException(String message, String exceptionCause) {
		super(message, new Throwable(exceptionCause));
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(Throwable cause) {
		super(cause);
	}
}
