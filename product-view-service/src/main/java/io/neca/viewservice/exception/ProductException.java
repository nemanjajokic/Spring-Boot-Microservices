package io.neca.viewservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductException extends RuntimeException {

	public ProductException() {
		super();
	}
	
}
