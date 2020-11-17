package com.rpgame.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rpgame.entity.User;
import com.rpgame.service.FileHandlerService;
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
	

	@Autowired
	private FileHandlerService fileService;

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
		return ResponseEntity.ok("File "+ pic.getOriginalFilename()+ "successfully uploaded");
	}

}
