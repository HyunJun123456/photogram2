package com.cos.photogramstart.web.api;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.web.dto.UserUpdateDto;

//ajax 통신을 하면 파일(페이지)을 응답하는게 아닌 data를 응답
// data를 응답하는 걸 api라고 부른다.
@RestController
public class UserApiController { 
	@PutMapping("/api/user/{id}")
	public String update(UserUpdateDto userUpdateDto) {
		System.out.println(userUpdateDto);
		return "update 메서드 실행 ok";
	}
}
