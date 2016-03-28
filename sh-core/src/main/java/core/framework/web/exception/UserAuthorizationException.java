package core.framework.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Unauthorised User")
public class UserAuthorizationException extends RuntimeException {

	public UserAuthorizationException(String message) {
		super(message);
	}
	
	public UserAuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }

}
