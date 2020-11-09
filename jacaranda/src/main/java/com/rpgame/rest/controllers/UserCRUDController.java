package com.rpgame.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rpgame.entity.User;
import com.rpgame.repositorys.UserRepository;
import com.rpgame.service.UserService;

/**
 * 
 * 
 * Customer CRUD controller
 * 
 * @author estudiante
 *
 */

@RestController
@RequestMapping(path = "/user")
public class UserCRUDController {

	@Autowired
	private UserService us;
	

	@GetMapping
	public ResponseEntity<?> readUser() {
		return us.readUser();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> readUser(@PathVariable Long id) {
		return us.readUser(id);
	}

	@PostMapping()
	public ResponseEntity<?> createUser(@RequestBody User sent) {		
		return us.createUser(sent);
	}

	@PutMapping("/{idUsuario}")
	public ResponseEntity<?> updateUser(@RequestBody User change, @PathVariable Long idUsuario) {
		return us.updateUser(change, idUsuario);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		return us.deleteUser(id);
	}

}
