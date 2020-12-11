package com.rpgame.rest.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.rpgame.entity.Ataque;
import com.rpgame.service.AtaqueService;

/**
 * 
 * Controlador de ataques
 * 
 * @author estudiante
 *
 */

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping(path = "/ataque")
public class AtaqueCRUDController {

	@Autowired
	private AtaqueService ataque;
	
	@GetMapping()
	public ResponseEntity<?> getAtaques() {
		ResponseEntity<?> response = null;
		List<Ataque> atack = ataque.getAtaques();
		if (atack != null) {
			response = ResponseEntity.status(HttpStatus.OK).body(atack);
		} else {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
		}
		return response;
	}


	@GetMapping("/{idAtaque}")
	public ResponseEntity<?> getAtaque(@PathVariable Long idAtaque) {
		ResponseEntity<?> response = null;
		Ataque atack = ataque.getAtaque(idAtaque);
		if (atack != null) {
			response = ResponseEntity.status(HttpStatus.OK).body(atack);
		} else {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
		}
		return response;
	}

	@PostMapping("")
	public ResponseEntity<?> postAtaque(@RequestBody Ataque sent) {
		ResponseEntity<?> response = null;
		Ataque atack = ataque.postAtaque(sent);
		if (atack != null) {
			response = ResponseEntity.status(HttpStatus.OK).body(atack);
		} else {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
		}
		return response;
	}

	@PutMapping("/{idAtaque}")
	public ResponseEntity<?> putAtaque(@RequestBody Ataque change, @PathVariable Long idAtaque) {
		ResponseEntity<?> response = null;
		Ataque atack = ataque.putAtaque(change, idAtaque);
		if (atack != null) {
			response = ResponseEntity.status(HttpStatus.OK).body(atack);
		} else {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
		}
		return response;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAtaque(@PathVariable Long id) {
		ResponseEntity<?> response = null;
		Ataque atack = ataque.deleteAtaque(id);
		if (atack != null) {
			response = ResponseEntity.status(HttpStatus.OK).body(atack);
		} else {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
		}
		return response;
	}

}
