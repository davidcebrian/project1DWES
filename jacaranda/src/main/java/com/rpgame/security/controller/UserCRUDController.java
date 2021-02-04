package com.rpgame.security.controller;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rpgame.security.model.User;
import com.rpgame.security.model.dto.UserDto;
import com.rpgame.security.service.UserService;

/**
 * 
 * 
 * Customer CRUD controller
 * 
 * @author estudiante
 *
 */

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping(path = "/user")
public class UserCRUDController {

	@Autowired
	private UserService us;
	

	@GetMapping
	public ResponseEntity<?> readUser() {
		ResponseEntity<?> response = null;
		ArrayList<User> user = (ArrayList<User>) us.readUser(); 
		if (user != null) {
			response = ResponseEntity.status(HttpStatus.OK).body(user);
		} else {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
		}
		
		return response;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> readUser(@PathVariable Long id) {
		ResponseEntity<?> response = null;
		UserDto user = us.readUser(id);
		if (user != null) {
			response = ResponseEntity.status(HttpStatus.OK).body(user);
		} else {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
		}
		return response;
	}

	@PostMapping()
	public ResponseEntity<?> createUser(@RequestBody User sent) {		
		ResponseEntity<?> response = null;
		UserDto user = us.createUser(sent);
		if (user != null) {
			response = ResponseEntity.status(HttpStatus.OK).body(user);
		} else {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
		}
		return response;
	}

	@PutMapping("/{idUsuario}")
	public ResponseEntity<?> updateUser(@RequestBody User change, @PathVariable Long idUsuario) {
		ResponseEntity<?> response = null;
		User user = us.updateUser(change, idUsuario);
		if (user != null) {
			response = ResponseEntity.status(HttpStatus.OK).body(user);
		} else {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
		}
		return response;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		ResponseEntity<?> response = null;
		User user = us.deleteUser(id);
		if (user != null) {
			response = ResponseEntity.status(HttpStatus.OK).body(user);
		} else {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
		}
		return response;
	}
	
	/**
	 * 
	 * @param pic File to store
	 * @param id  Customer whose documents would be updated
	 * @param redirectAttributes
	 * @return
	 */
	
	@PutMapping("/{id}/doc")
	public ResponseEntity<?> uploadPicture(@RequestParam(name = "pic", required = false) MultipartFile pic, 
								@PathVariable(required = false) Long id){
		us.addDocument(id, pic);
		return ResponseEntity.ok("File "+ pic.getOriginalFilename()+ " successfully uploaded");
	}

	@GetMapping("/doc/{mpf}")
	public ResponseEntity<?> getDocument(@PathVariable Long mpf){
		return us.getDocument(mpf);
	}
}
