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
@RequestMapping(path = "/ataque")
public class AtaqueCRUDController {

	@Autowired
	private AtaqueService ataque;
	
	@GetMapping()
	public ResponseEntity<?> getAtaques() {
		return ataque.getAtaques();
	}

//	@GetMapping("/personaje/{idPj}")
//	public ResponseEntity<?> getAtaquesPj(@PathVariable String idPj) {
//		return ataque.getAtaquesPj(idPj);
//	}

	@GetMapping("/{idAtaque}")
	public ResponseEntity<?> getAtaque(@PathVariable Long idAtaque) {
		return ataque.getAtaque(idAtaque);
	}

	@PostMapping("")
	public ResponseEntity<?> postAtaque(@RequestBody Ataque sent) {
		return ataque.postAtaque(sent);
	}

	@PutMapping("/{idAtaque}")
	public ResponseEntity<?> putAtaque(@RequestBody Ataque change, @PathVariable Long idAtaque) {
		return ataque.putAtaque(change, idAtaque);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAtaque(@PathVariable Long id) {
		return ataque.deleteAtaque(id);
	}

}
