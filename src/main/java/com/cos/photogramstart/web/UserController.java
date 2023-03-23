package com.cos.photogramstart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {
	@GetMapping("/user/{id}") // 프로필 페이지는 회원가입을 진행한 유저의 수만큼 존재하기 때문에 변수로써 존재해야함
	public String profile(@PathVariable int id) { // 변수를 바인딩 할 수 있게 @PathVariable을 걸어줘야함
		return "user/profile";
	}
	
	@GetMapping("/user/{id}/update")
	public String update(@PathVariable int id) {
		return "user/update";
	}
}
