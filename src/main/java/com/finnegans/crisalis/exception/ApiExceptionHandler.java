package com.finnegans.crisalis.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.finnegans.crisalis.exception.custom.*;

@ControllerAdvice
public class ApiExceptionHandler {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ EmptyElementException.class, NotCreatedException.class })
	
	@ResponseBody
	public ErrorMessage badRequest(HttpServletRequest request, Exception exception) {
		return new ErrorMessage(exception, request.getRequestURI());
	}

//Esta va  a atender las que Respondan con UNAUTHORIZED
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler({ UnauthorizedException.class })
	
	@ResponseBody
	public void unauthorized() {
		//	Empty, because http in case 401 not support body response
	}

}
