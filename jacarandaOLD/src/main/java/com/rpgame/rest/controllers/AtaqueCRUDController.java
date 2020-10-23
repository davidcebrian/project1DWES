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
 * @author estudiante
 *
 */

@RestController
@RequestMapping(path = "/ataque")
public class AtaqueCRUDController {
	
	@Autowired
	private AtaqueService ataque;
	
	@GetMapping()
	public ResponseEntity<?> getAtaques(){
		return ataque.getAtaques();
	}
	
	@GetMapping("/personaje/{idPj}")
	public ResponseEntity<?> getAtaquesPj(@PathVariable String idPj){
		return ataque.getAtaquesPj(idPj);
	}
	
	@GetMapping("/{idAtaque}")
	public ResponseEntity<?> getAtaque(@PathVariable int idAtaque){
		return ataque.getAtaque(idAtaque);
	}
	
	@PostMapping("/personaje/{idPersonaje}")
	public ResponseEntity<?> postAtaque(@RequestBody Ataque sent, @PathVariable String idPersonaje) {
		return ataque.postAtaque(sent, idPersonaje);
	}
	
	@PutMapping()
	public ResponseEntity<?> putAtaque(@RequestBody Ataque change){
		return ataque.putAtaque(change);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAtaque(@PathVariable int id){
		return ataque.deleteAtaque(id);
	}
	
}
