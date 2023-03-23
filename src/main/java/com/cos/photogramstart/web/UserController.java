package com.cos.photogramstart.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.photogramstart.config.auth.PrincipalDetails;

@Controller
public class UserController {
	@GetMapping("/user/{id}") // 프로필 페이지는 회원가입을 진행한 유저의 수만큼 존재하기 때문에 변수로써 존재해야함
	public String profile(@PathVariable int id,
			@AuthenticationPrincipal PrincipalDetails principalDetails) { // 변수를 바인딩 할 수 있게 @PathVariable을 걸어줘야함
		//System.out.println("세션 정보 확인 : "+principalDetails.getUser());
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		PrincipalDetails mPrincipalDetails = (PrincipalDetails) auth.getPrincipal();	
		return "user/profile";
	}
	
	@GetMapping("/user/{id}/update")
	public String update(@PathVariable int id,
			@AuthenticationPrincipal PrincipalDetails principalDetails,
			Model model) {
		//System.out.println("세션 정보 확인: "+principalDetails.getUser());
		//model.addAttribute("principal", principalDetails.getUser()); // jsp에서 설정해둠 (시큐리티 태그 라이브러리)
		
		return "user/update";
	}
}
