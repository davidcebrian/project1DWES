package com.rpgame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rpgame.entity.User;
import com.rpgame.repositorys.UserRepository;

public class OrderedUsersService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> usuariosOrdenados(int cuantos){
		List<User> usuarios = userRepository.findAllOrderedByName();
		
		return usuarios;
	}
}
