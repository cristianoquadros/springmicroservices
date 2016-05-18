package com.example.application.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.PRECONDITION_FAILED, reason="Erro de validação")  // 412
public class ValidationFailed extends RuntimeException {

	private static final long serialVersionUID = 7640519710002608577L;
	
	public ValidationFailed(String message) {
		super(message);
	}
}