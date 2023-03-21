package com.cos.photogramstart.handler;

import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.handler.ex.CustomValidationException;

@RestController
@ControllerAdvice // 모든  Exception을 여기로 받아준다.
public class ControllerExceptionHandler {
	@ExceptionHandler(CustomValidationException.class)
	public Map<String, String> validationException(CustomValidationException e) {
		
		return e.getErrorMap();
	}
}
