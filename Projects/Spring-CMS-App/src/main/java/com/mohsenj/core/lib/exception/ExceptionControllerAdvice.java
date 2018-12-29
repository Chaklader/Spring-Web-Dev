package com.mohsenj.core.lib.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotFoundException.class)
	public String exception(Exception e) {

		return "error/404";
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	public String exceptionBadRequest(Model model, Exception e) {

		model.addAttribute("errorMsg", e.getMessage());
		return "error/error";
	}
	
}
