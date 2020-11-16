package com.rpgame.service;


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
			users = ResponseEntity.ok(userRepository.findAll().toString());
		}else {
			users = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existen usuarios.");
		}
		return users;
	}
	
	public ResponseEntity<?> readUser(Long id) {
		ResponseEntity<?> customer = null;
		User us = userRepository.findUserByIdUsuario(id);
		if (us != null) {
			customer = ResponseEntity.status(HttpStatus.OK).body(us.toString());
		} else {
			customer = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
		}
		return customer;
	}

	public ResponseEntity<?> createUser(User sent) {
		ResponseEntity<?> user = null;
		if(sent != null) {
			userRepository.save(sent);
			user = ResponseEntity.status(HttpStatus.OK).body(sent.toString());
		}else {
			user = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Introduzca un usuario.");
		}
		return user;
	}

	public ResponseEntity<?> updateUser(User change, Long id) {
		ResponseEntity<?> ent = null;
		User user = userRepository.findUserByName(change.getName());
		if (change != null && user != null) {
			userRepository.updateUser(id, change.getUserName());
			ent = ResponseEntity.ok(change.toString());
		} else {
			ent = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
		}
		return ent;
	}
		

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
	
	
	/**
	 * Add a new Document to this entity
	 * @param id Identifier of the entity to be updated
	 * @param mpf Multipart file 
	 * @return Updated entity
	 */
	@Override
	public User addDocument(String id, MultipartFile mpf) {
		User c = null;
		
		try {
			User doc = docReposiroty.save( new Document(fhService.createBlob(mpf), 
															 mpf.getName(), 
															 Integer.valueOf((int) mpf.getSize()))
										);
			
			c = userRepository.findUserByIdUsuario(id);
			c.setDocuments(c.getDocuments()!=null && !c.getDocuments().isEmpty()? c.getDocuments():new ArrayList<>());
			c.getDocuments().add(doc);
			userRepository.save(c);
			
		} catch (NumberFormatException | NotFoundException e) {
			logger.debug(String.format("Customer with identifier %s could not be found ", id));
		}
			
		
		return c;
	}

}
