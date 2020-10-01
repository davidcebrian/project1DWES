package com.rpgame.rest.controllers;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpgame.entity.User;


/**
 * 
 * 
 * Customer CRUD controller
 * @author estudiante
 *
 */


@RestController
@RequestMapping(path = "/user")
public class UserCRUDController {
	private List<User> user = new ArrayList<> ();
	
	@GetMapping("/read/{id}")
	public ResponseEntity<?> readUser(@PathVariable int id) {
		ResponseEntity<?> customer = null;
		Iterator<User> it = user.iterator();
		boolean flag = false;
		while(it.hasNext() && !flag) {
			User elemento = it.next();
			if(elemento.getId() == id) {
				customer = ResponseEntity.status(HttpStatus.OK).body(elemento);
			}else {
				customer = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
			}
		}
		return customer;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createUser(@RequestBody User sent) {
		user.add(sent);
		return ResponseEntity.status(HttpStatus.CREATED).body(sent);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody User change){
		ResponseEntity<?> ent = null;
		Iterator<User> it = user.iterator();
		boolean flag = false;
		while(it.hasNext() && !flag) {
			User elemento = it.next();
			if(elemento.getId() == change.getId()) {
				elemento.setName(change.getName());
				elemento.setSurname(change.getSurname());
				flag = true;
				ent = ResponseEntity.ok(change);
			}else {
				ent = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
			}
		}
		//customers.stream().filter(c -> c.getId() == change.getId()).findFirst().get();
		return ent;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id){
		ResponseEntity<?> ent = null;
		Iterator<User> it = user.iterator();
		boolean flag = false;
		while(it.hasNext() && !flag) {
			User elemento = it.next();
			if(elemento.getId() == id) {
				user.remove(elemento);
				flag = true;
				ent = ResponseEntity.status(HttpStatus.ACCEPTED).body("Usuario borrado.");
			}else {
				ent = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
			}
		}
		return ent;
	}
	}
	
	

