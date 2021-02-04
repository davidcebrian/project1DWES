package com.rpgame.security.service;


import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rpgame.entity.Document;
import com.rpgame.repositorys.DocumentRepository;
import com.rpgame.security.model.User;
import com.rpgame.security.model.dto.DtoConverter;
import com.rpgame.security.model.dto.UserDto;
import com.rpgame.security.repo.UserRepository;
import com.rpgame.service.AbstractServiceUtils;
import com.rpgame.service.FileHandlerService;




@Service
public class UserService extends AbstractServiceUtils{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DtoConverter converter;
	
	@Autowired 
	private DocumentRepository docRepository;
	
	@Autowired
	private FileHandlerService fhService;
	
	
	public List<User> readUser() {
		ArrayList<User> users = null;
		if(userRepository.findAll().iterator().hasNext()) {
			users = (ArrayList<User>) userRepository.findAll();
		}else {
			users = null;
		}
		return users;
	}
	
	
	public UserDto readUser(Long id) {
		User us = userRepository.findUserByIdUsuario(id);
		return converter.fromUserToUserDTO(us);
	}

	public UserDto createUser(User sent) {
		User user = null;
		if(sent != null) {
			userRepository.save(sent);
			user = sent;
		}else {
			user = null;
		}
		return converter.fromUserToUserDTO(user);
	}

	public User updateUser(User change, Long id) {
		User user = userRepository.findUserByName(change.getName());
		if (change != null && user != null) {
			userRepository.updateUser(id, change.getUserName());
		} else {
			user = null;
		}
		return user;
	}
		

	public User deleteUser(Long id) {
		User user = userRepository.findUserByIdUsuario(id);
		if(user != null) {
			userRepository.deleteById(id);			
		}else {
			user = null;			
		}
		return user;
	}
	
	
	/**
	 * Add a new Document to this entity
	 * @param id Identifier of the entity to be updated
	 * @param mpf Multipart file 
	 * @return Updated entity
	 */
	
	public User addDocument(Long id, MultipartFile mpf) {
		User c = null;
		
		try {
			Document doc = docRepository.save( new Document(fhService.createBlob(mpf), 
															 mpf.getOriginalFilename(), 
															 Integer.valueOf((int) mpf.getSize()))
										);
			
			c = userRepository.findUserByIdUsuario(id);
			c.setDocuments(c.getDocuments()!=null && !c.getDocuments().isEmpty()? c.getDocuments():new ArrayList<>());
			c.getDocuments().add(doc);
			userRepository.save(c);
			
		} catch (NumberFormatException e) {
			logger.debug(String.format("Customer with identifier %s could not be found ", id));
		}
			
		
		return c;
	}
	
	
	public ResponseEntity<?> getDocument(Long id){
		ResponseEntity<?> ent = null;
		HttpHeaders headers = new HttpHeaders();
		Document dc = docRepository.findDocumentById(id);
		Blob blob = dc.getPicture();
		try {
			byte[] bytes = blob.getBinaryStream().readAllBytes();
			headers.set("Content-Disposition", String.format("attachment; filename=" + dc.getFileName()));
			ent = ResponseEntity.ok()
	                .headers(headers)
	                .contentLength(bytes.length)
	                .body(bytes);
           
		} catch (SQLException | IOException e) {
			logger.debug(String.format("Customer with identifier %s could not be found ", id));
		}
	
		return ent;
	}

}
