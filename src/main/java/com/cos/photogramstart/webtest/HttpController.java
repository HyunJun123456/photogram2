package com.cos.photogramstart.webtest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller 일 때, return에 적은 값은 resources 폴더 내부의 파일명이 되고,
// @RestController일 때, return에 적은 값은 Data가 된다.
//@Controller // File을 응답해주는 컨트롤러 (클라이언트가 웹브라우저 일 때, .html 파일을 응답해주기 위해 사용)
@RestController // Data를 응답해주는 컨트롤러 (클라이언트가 모바일 일 때, Data를 응답해주기 위해 사용)
public class HttpController {
	// http://localhost:8080/get
	@GetMapping("/get") // 엔드포인트 :endpoint
	public String get() {
		return "get 요청이 실행되었습니다.";
	}
	// http://localhost:8080/post
	@PostMapping("/post")
	public String post() {
		return "post 요청이 실행되었습니다.";
	}
	// http://localhost:8080/put
	@PutMapping("/put")
	public String put() {
		return "put 요청이 실행되었습니다.";
	}
	// http://localhost:8080/delete
	@DeleteMapping("/delete")
	public String delete() {
		return "delete 요청이 실행되었습니다.";
	}
	// get, post, put, delete는 모두 다른 요청으로 들어가게됨.
}
