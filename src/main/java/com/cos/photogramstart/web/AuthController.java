package com.cos.photogramstart.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor // final이 걸린 애들만 골라서 생성자를 자동으로 만들어준다.
@Controller
public class AuthController {
	private static Logger log = LoggerFactory.getLogger(AuthController.class);
	
	private final AuthService authService;
	
	// 로그인 페이지로 이동
	@GetMapping("/auth/signin")
	public String signinForm() {
		return "/auth/signin";
	}
	
	// 회원가입 페이지로 이동
	@GetMapping("/auth/signup")
	public String signupForm() {
		return "/auth/signup";
	}
	
	// 회원가입 기능
	@PostMapping("/auth/signup") // @GetMapping과 요청오는게 똑같아도 다르게 받아들임
	public @ResponseBody String signup(@Valid SignupDto signupDto,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
				System.out.println("==============================");
				System.out.println(error.getDefaultMessage());
				System.out.println("==============================");
			}
			return "오류발생";
		}else {
			// log.info(signupDto.toString());
			// User Object에 SignUpDto 데이터를 삽입하려고 한다.
			// User 오브젝트에 signupDto에서 방금 만들었던 toEntity 데이터를 넣어주자.
			User user = signupDto.toEntity();
			log.info(user.toString());
			User userEntity = authService.회원가입(user);
			System.out.println(userEntity);
			return "/auth/signin"; // 회원가입이 완료되면 로그인페이지로 이동할 것이다.
		}
	}
	
}
