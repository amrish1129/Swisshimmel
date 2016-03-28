package core.framework.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource Not Found")
public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

	public ResourceNotFoundException(String message, Throwable cause) {
		// TODO Auto-generated constructor stub
		super(message, cause);
	}

}
