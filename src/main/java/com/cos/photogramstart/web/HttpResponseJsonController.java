package com.cos.photogramstart.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.domain.User;

@RestController
public class HttpResponseJsonController {
	@GetMapping("/response/json")
	public String responseJson() {
		return "{\"username\" : \"ssar\"}"; // json 타입으로 응답하기
	}
	
	@GetMapping("/response/json/object")
	public User responseJsonObject() {
		User user = new User();
		user.setUsername("홍길동");
		return user; // 매번 json 형태로 바꿀 수 없으니 object로 넘겨준다.
		// MessageConverter라는 class가 자바오브젝트를 Json으로 변경해서 통신을 통하여 Json으로 응답해줌
		// 그리고 @RestController일 때만, MessageConverter가 자동으로 작동
	}
	
	
	
}
