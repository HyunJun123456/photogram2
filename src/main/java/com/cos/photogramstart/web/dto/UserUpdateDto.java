package com.cos.photogramstart.web.dto;


import javax.validation.constraints.NotBlank;

import com.cos.photogramstart.domain.user.User;

import lombok.Data;

@Data
public class UserUpdateDto {
	// 필수로 받아야 하는 데이터
	@NotBlank // @Valid 어노테이션으로 확인해줘야 함
	private String name;
	@NotBlank
	private String password;
	
	// 받지 않아도 되는 데이터
	private String website;
	private String bio;
	private String phone;
	private String gender;
	
	public User toEntity() {
		return User.builder()
				.name(name)
				.password(password)
				.website(website)
				.bio(bio)
				.phone(phone)
				.gender(gender)
				.build();
	}
}
