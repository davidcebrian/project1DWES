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
import com.rpgame.service.UserService;


/**
 * 
 * 
 * Customer CRUD controller
 * @author estudiante
 *
 */
	

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(path = "/user")
public class UserCRUDController {
	
	@Autowired
	private UserService us;
	
		
	@GetMapping()
	public ResponseEntity<?> readAllUser() {
		return us.readAllUser();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> readUser(@PathVariable int id) {
		return us.readUser(id);
	}
	
	@PostMapping()
	public ResponseEntity<?> createUser(@RequestBody User sent) {
		return us.createUser(sent);
	}
	
	@PutMapping()
	public ResponseEntity<?> updateUser(@RequestBody User change){
		return us.updateUser(change);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id){
		return us.deleteUser(id);
	}
	
	
	}
	
	

