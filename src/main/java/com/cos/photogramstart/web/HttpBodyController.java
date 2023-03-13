package com.cos.photogramstart.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.domain.User;

@RestController
public class HttpBodyController {
	
	private static final Logger log = LoggerFactory.getLogger(HttpBodyController.class);
	
	@PostMapping("/body1")
	public String xWwwFormUrlEncoded(String username) {
		log.info(username);
		return "key=value 타입으로 전송 받음";
	}
	
	@PostMapping("/body2") 
	public String plainText(@RequestBody String data) { // @RequestBody 어노테이션은 문자열 그대로 받겠다고 지정해주는 기능이다.
		log.info(data);
		return "text 타입으로 전송 받음";
	}
	
	@PostMapping("/body3") // 모델링이 필요함
	public String applicationJson(@RequestBody User user) { // key값이 따로 없으므로 @RequestBody 어노테이션을 걸어줘야함
		log.info(user.getUsername());
		log.info(user.getPassword());
		return "json 타입으로 전송 받음";
	}
}
