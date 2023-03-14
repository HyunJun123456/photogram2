package com.cos.photogramstart.service;

import org.springframework.stereotype.Service;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class AuthService {
	private final UserRepository userRepository;
	
	public User 회원가입(User user) {
		// 회원가입 진행
		User userEntity = userRepository.save(user); // save 메서드를 이용하면 S타입으로 리턴을 해주는데, S타입이란 내가 넣은 타입
		// User 타입으로 받은 데이터를 Entity라고 명명한 이유는, 데이터가 DB에 들어간 후에 응답받은 것이기 때문이다.
		return userEntity;
	}
}
