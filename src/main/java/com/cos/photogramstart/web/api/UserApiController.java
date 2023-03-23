package com.cos.photogramstart.web.api;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.handler.ex.CustomValidationApiException;
import com.cos.photogramstart.service.UserService;
import com.cos.photogramstart.web.dto.CMRespDto;
import com.cos.photogramstart.web.dto.UserUpdateDto;

import lombok.RequiredArgsConstructor;

//ajax 통신을 하면 파일(페이지)을 응답하는게 아닌 data를 응답
// data를 응답하는 걸 api라고 부른다.
@RequiredArgsConstructor
@RestController
public class UserApiController { 
	private final UserService userService;
	
	@PutMapping("/api/user/{id}")
	public CMRespDto<?> update(@PathVariable int id, 
			@Valid UserUpdateDto userUpdateDto,
			BindingResult bindingResult, // BindingResult를 걸어주는 위치는 꼭 @Valid되는 파라미터의 다음으로 적용해야함
			@AuthenticationPrincipal PrincipalDetails principalDetails) {
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
				System.out.println("==============================");
				System.out.println(error.getDefaultMessage());
				System.out.println("==============================");
			}
			throw new CustomValidationApiException("유효성검사 실패함", errorMap);
		}
		User userEntity = userService.회원수정(id, userUpdateDto.toEntity());
		principalDetails.setUser(userEntity);
		return new CMRespDto<>(1, "회원수정완료", userEntity);
	} // DB에 반영된 정보가 반영되려면 session 정보를 변경해야한다.
}
