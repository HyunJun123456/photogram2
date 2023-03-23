package com.cos.photogramstart.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	@Transactional // spring의 Transactional을 사용해야함
	public User 회원수정(int id, User user) {
		// 1. 영속화 하기
		User userEntity = userRepository.findById(id).get();
		/*
		 * 여기서 findById(id)만 하면되지 왜 get()까지 추가했을까?
		 * JpaRepository가 가지고 있는 findById() 메서드에서 찾으려고 하는 User id가 없다면, 
		 * null이 리턴이 되어버린다.
		 * 때문에 자바에서는 WrappingClass인 Optional<T> 라는걸 자동으로 만들어준다.
		 * 이 Optional<T> 덕분에 3가지 옵션을 선택할 수 있게 되는데
		 * 
		 * 1) get() : 데이터를 무조건 찾아줄테니 신경쓰지마라.
		 * 2) orElseThrow() : 데이터가 null일 때, Exception을 발동시켜 주겠다.
		 * 3) orElse : 데이터가 null일 때, 괄호안에 객체를 만들어서 리턴시켜 주겠다.
		 * 
		 */
		// 2. 영속화된 오브젝트 수정하기
		userEntity.setName(user.getName());
		// 2-1. password 암호화 하기
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		
		userEntity.setPassword(encPassword);
		userEntity.setBio(user.getBio());
		userEntity.setWebsite(user.getWebsite());
		userEntity.setPhone(user.getPhone());
		userEntity.setGender(user.getGender());
		
		return userEntity;
	}// 3. 리턴 완료되면 더티체킹이 일어나면서 업데이트가 완료됨.
}
