package com.cos.photogramstart.handler;

import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.web.dto.CMRespDto;

@RestController
@ControllerAdvice // 모든  Exception을 여기로 받아준다.
public class ControllerExceptionHandler {
	@ExceptionHandler(CustomValidationException.class)
	public CMRespDto<?> validationException(CustomValidationException e) {
		// ?로 바꿔서 동적으로 타입을 바꿀 수 있음!
		return new CMRespDto<>(-1, e.getMessage(), e.getErrorMap());
	}
}
