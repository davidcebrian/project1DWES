package com.rpgame.security.model.dto;

import com.rpgame.security.model.User;



public class DtoConverter {
	public User fromUserDTOToUser(UserDto dto) {
		User user  = new User();
		user.setSurname(dto.getSurname());
		user.setPassword(dto.getPassword());
		user.setMail(dto.getMail());
		user.setVip(dto.isVip());
		return user;
	}
	
	public UserDto fromUserToUserDTO(User user) {
		UserDto dto = new UserDto();
		dto.setSurname(user.getSurname());
		dto.setPassword(user.getPassword());
		dto.setMail(user.getMail());
		dto.setVip(user.isVip());
		return dto;
	}
}
