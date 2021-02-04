package com.rpgame.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rpgame.security.model.User;
import com.rpgame.security.repo.UserRepository;

public class OrderedUsersService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> usuariosOrdenados(int cuantos){
		List<User> usuarios = userRepository.findAllOrderedByName();
		
		return usuarios;
	}
}
