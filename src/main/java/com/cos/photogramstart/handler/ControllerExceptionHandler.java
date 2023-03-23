package com.cos.photogramstart.handler;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.handler.ex.CustomValidationApiException;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.util.Script;
import com.cos.photogramstart.web.dto.CMRespDto;

@RestController
@ControllerAdvice // 모든  Exception을 여기로 받아준다.
public class ControllerExceptionHandler {
	@ExceptionHandler(CustomValidationException.class)
	//public CMRespDto<?> validationException(CustomValidationException e) {
	public String validationException(CustomValidationException e) {
		// ?로 바꿔서 동적으로 타입을 바꿀 수 있음!
		//return new CMRespDto<>(-1, e.getMessage(), e.getErrorMap());
		return Script.back(e.getErrorMap().toString());
	}
	// Script는 클라이언트(브라우저)의 편의성을 위해 만든 응답
	// ajax 통신이나, android 같은 통신을 할 때에는 개발자가 보아야 하기 때문에 CMRespDto가 좋다.
	
	// CMRespDto 오브젝트를 응답하는 핸들러
	@ExceptionHandler(CustomValidationApiException.class)
	public ResponseEntity<CMRespDto<?>> validationApiException(CustomValidationApiException e){
		return new ResponseEntity<CMRespDto<?>>(
				new CMRespDto<>(-1, e.getMessage(), e.getErrorMap()),
				HttpStatus.BAD_REQUEST
				);
	}
}
