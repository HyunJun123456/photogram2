package com.cos.photogramstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@EnableWebSecurity // 시큐리티 설정파일로 인식된 파일을 활성화 시켜준다.
@Configuration // IoC 컨테이너에 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 시큐리티가 인증되지 않은 쵸청을 낚아채서 login 페이지로 응답하게 해주는 녀석
		// 주석 처리함으로써 적용되어 있던 기능들 비활성화
		
		http.csrf().disable(); // CSRF 토큰 검사를 비활성화 하겠다.
		http.authorizeRequests()
		.antMatchers("/", "/user/**", "/image/**", "/subscribe/**", "/comment/**") // 요청이 들어오는 경로를 지정
		.authenticated() // 해당 경로로 들어온 요청은 인증이 필요하다고 지정
		.anyRequest() // 인증이 필요하지 않는 모든 요청
		.permitAll() // 모두 허용
		.and() // 그리고
		.formLogin() // 로그인(인증)이 필요한 요청이 들어오면
		.loginPage("/auth/signin") // 로그인페이지 auth/signin으로 이동시키고 (GET요청) //loginPage에서의 경로는 인증이 필요한 요청이 들어왔을 때 Get요청으로 페이지를 응답
		.loginProcessingUrl("/auth/signin") // auth/signin 이라는 POST요청을 실행 //loginProcessingUrl는 스프링시큐리티가 Post 요청으로써 로그인프로세스를 진행 
		.defaultSuccessUrl("/") // 인증이 정상적으로 완료되면 / 로 이동한다. 
		;
	}
}
