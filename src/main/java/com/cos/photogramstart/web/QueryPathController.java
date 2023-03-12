package com.cos.photogramstart.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryPathController {
	@GetMapping("/chicken")
	public String chickenQueryString(String type) { // 주소의 끝에 ?type=type을 지정
		return type + "배달갑니다. (쿼리스트링)";
	}
	
	@GetMapping("/chicken/{type}") // 중괄호를 쓰면 데이터(변수)를 전달 받을 수 있다.
	public String chickenPathVariable(@PathVariable String type) {
		return type + "배달갑니다. (주소변수매핑)";
	}
	
}
