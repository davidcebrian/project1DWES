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

import com.rpgame.entity.Personaje;
import com.rpgame.service.PersonajeService;

/**
 * Personaje CRUD Controller
 * @author estudiante
 *	
 */


@RestController
@RequestMapping(path = "/personaje")
public class PersonajeCRUDController {
	@Autowired
	private PersonajeService pj;
	
	@GetMapping()
	public ResponseEntity<?> getPersonajes(){
		return pj.getPersonajes();
	}
	
	@GetMapping("/user/{idUser}")
	public ResponseEntity<?> getPersonajesUser(@PathVariable int idUser){
		return pj.getPersonajesUser(idUser);
	}
	
	@GetMapping("/{idPersonaje}")
	public ResponseEntity<?> getPersonaje(@PathVariable String idPersonaje){
		return pj.getPersonaje(idPersonaje);
	}
	
	@PostMapping("/{idUser}")
	public ResponseEntity<?> postPersonaje(@RequestBody Personaje sent, @PathVariable int idUser){
		return pj.postPersonaje(sent, idUser);
	}
	
	@PutMapping()
	public ResponseEntity<?> putPersonaje(@RequestBody Personaje change){
		return pj.putPersonaje(change);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePersonaje(@PathVariable String id){
		return pj.deletePersonaje(id);
	}
	
	
	
	
}
