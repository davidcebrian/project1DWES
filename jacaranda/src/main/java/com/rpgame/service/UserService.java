package com.rpgame.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.rpgame.entity.User;
import com.rpgame.repositorys.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	
	public ResponseEntity<?> readUser() {
		ResponseEntity<?> users = null;
		if(userRepository.findAll().iterator().hasNext()) {
			users = ResponseEntity.ok(userRepository.findAll());
		}else {
			users = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existen usuarios.");
		}
		return users;
	}
	
	
	public ResponseEntity<?> readUser(Long id) {
		ResponseEntity<?> customer = null;
		Optional<User> us = userRepository.findById(id);
		if (us != null) {
			customer = ResponseEntity.status(HttpStatus.OK).body(us);
		} else {
			customer = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
		}
		return customer;
	}

//	public ResponseEntity<?> readUserOld(int id) {
//		ResponseEntity<?> customer = null;
//		User us = db.getUsuarios().stream().filter(u -> u.getId() == id).findFirst().get();
//		if (us != null) {
//			customer = ResponseEntity.status(HttpStatus.OK).body(us);
//		} else {
//			customer = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
//		}
//		return customer;
//	}
//	

	public ResponseEntity<?> createUser(User sent) {
		ResponseEntity<?> user = null;
		if(sent != null) {
			userRepository.save(sent);
			user = ResponseEntity.status(HttpStatus.OK).body(sent);
		}else {
			user = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Introduzca un usuario.");
		}
		return user;
	}
	
//	/** Antiguo create user*/
//	public ResponseEntity<?> createUserOld(User sent) {
//		db.getUsuarios().add(sent);
//		return ResponseEntity.status(HttpStatus.CREATED).body(sent);
//	}

//	public ResponseEntity<?> addPersonajeAUser(Personaje pj, int user) {
//		ResponseEntity<?> ent = null;
//		Iterator<User> it = db.getUsuarios().iterator();
//		boolean flag = false;
//		while (it.hasNext() && !flag) {
//			User elemento = it.next();
//			if (elemento.getId() == user) {
//				elemento.getPersonajes().add(pj);
//				flag = true;
//				ent = ResponseEntity.status(HttpStatus.OK).body(pj);
//			} else {
//				ent = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado.");
//			}
//		}
//		return ent;
//	}

	public ResponseEntity<?> updateUser(User change) {
		ResponseEntity<?> ent = null;
		User user = userRepository.findUserByName(change.getName());
		if (change != null && user != null) {
			userRepository.updateUser(change.getId(), change.getUserName());
			ent = ResponseEntity.ok(change);
		} else {
			ent = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
		}
		return ent;
	}
		// customers.stream().filter(c -> c.getId() ==
		// change.getId()).findFirst().get();

	public ResponseEntity<?> deleteUser(Long id) {
		ResponseEntity<?> ent = null;
		User user = userRepository.findUserByIdUsuario(id);
		if(user != null) {
			userRepository.deleteById(id);			
			ent = ResponseEntity.status(HttpStatus.ACCEPTED).body("Usuario borrado.");
		}else {
			ent = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");			
		}
		return ent;
	}

}
