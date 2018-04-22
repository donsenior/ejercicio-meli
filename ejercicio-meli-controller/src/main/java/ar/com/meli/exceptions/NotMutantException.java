package ar.com.meli.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class NotMutantException extends Exception {

	private static final long serialVersionUID = -1047518770816953093L;
	
	public NotMutantException(String msg) {
		super(msg);
	}

}
