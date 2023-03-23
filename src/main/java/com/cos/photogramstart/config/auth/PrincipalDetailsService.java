package com.cos.photogramstart.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class PrincipalDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username + "loadUserByUsername 실행됨");
		return null;
	}
	/*
	 * 서버 내부의 시큐리티 설정파일(SecurityConfig)에 /auth/signin 이라는 주소가 
		Post요청으로 Http body에 username과 password 를 담아 보내면, 
		IoC컨테이너에 상주하고 있던 UserDetailsService가 이 body 데이터를 이용해서 로그인을 진행해준다.
		근데 우리가 방금 PrincipalDetailsService를 만들지 않았는가?
		PrincipalDetailsService도 @Service로써 IoC 컨테이너에 등록이 되어야 하고,
		타입은 UserDetailsService이기 때문에 이미 중복되는 타입이 존재하게 된다.
		따라서 UserDetailsService를 없애고 PrincipalDetailsService가 해당 영역을 덮어씌우게 된다.
		즉, PrincipalDetailsService가 가지고 있는 loadUserByUsername 메서드가 실행되게 된다.
	 */
}
