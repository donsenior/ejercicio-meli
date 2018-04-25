package ar.com.meli.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception {

	private static final long serialVersionUID = -5982982620568255685L;

	public BadRequestException(String msg) {
		super(msg);
	}

}
