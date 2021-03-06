package com.rpgame.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rpgame.entity.Personaje;
import com.rpgame.entity.User;

@Service
public class UserService {
	@Autowired
	private DatabaseService db;
	
	
	public ResponseEntity<?> readAllUser() {
		ResponseEntity<?> customer = null;
		if(db.getUsuarios().isEmpty()) {
			customer = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay usuarios.");
		}else {
			
		customer = ResponseEntity.status(HttpStatus.OK).body(db.getUsuarios());
		}
		return customer;
	}
	
	public ResponseEntity<?> readUser(int id) {
		ResponseEntity<?> customer = null;
		User us = db.getUsuarios().stream().filter(u -> u.getId() == id).findFirst().get();
			if(us != null) {
				customer = ResponseEntity.status(HttpStatus.OK).body(us);
			}else {
				customer = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
		}
		return customer;
	}
	
	public ResponseEntity<?> createUser(User sent) {
		ResponseEntity<?> customer = null;
		if(sent.getName().equals("") || sent.getMail().equals("")) {
			customer = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Introduzca usuario válido.");
		}else {
		db.getUsuarios().add(sent);
		customer = ResponseEntity.status(HttpStatus.CREATED).body(sent);
		}
		return customer;
	}
	
	
 	public ResponseEntity<?> addPersonajeAUser(Personaje pj, int user) {
		ResponseEntity<?> ent = null;
		Iterator<User> it = db.getUsuarios().iterator();
		boolean flag = false;
		while(it.hasNext() && !flag) {
			User elemento = it.next();
			if(elemento.getId() == user) {
				elemento.getPersonajes().add(pj);
				flag = true;
				ent = ResponseEntity.status(HttpStatus.OK).body(pj);
			}else {
				ent = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado.");
			}	
	}
		return ent;
	}
 	
	public ResponseEntity<?> updateUser(User change){
		ResponseEntity<?> ent = null;
		Iterator<User> it = db.getUsuarios().iterator();
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
	
	public ResponseEntity<?> deleteUser(int id){
		ResponseEntity<?> ent = null;
		Iterator<User> it = db.getUsuarios().iterator();
		boolean flag = false;
		while(it.hasNext() && !flag) {
			User elemento = it.next();
			if(elemento.getId() == id) {
				db.getUsuarios().remove(elemento);
				for(Personaje p : db.getPersonajes()) {
					if(p.getUsuario() == id) {
						p.setUsuario(0);
					}
				}
				flag = true;
				ent = ResponseEntity.status(HttpStatus.ACCEPTED).body("Usuario borrado.");
			}else {
				ent = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
			}
		}
		return ent;
	}
 	
 	
 	
 	
 	
}
