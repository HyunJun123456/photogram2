package com.cos.photogramstart.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
	// JpaRepository가 이미 @Repository를 들고 있어 어노테이션을 걸어주지 않아도 됨.
	
	// JPA Query Method
	User findByUsername(String username);
}
