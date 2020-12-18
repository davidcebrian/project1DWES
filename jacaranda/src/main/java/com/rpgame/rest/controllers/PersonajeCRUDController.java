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

import com.rpgame.entity.Personaje;
import com.rpgame.service.PersonajeService;

/**
 * Personaje CRUD Controller
 * 
 * @author estudiante
 * 
 */

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping(path = "/personaje")
public class PersonajeCRUDController {
	
	@Autowired
	private PersonajeService pj;
	


	@GetMapping("")
	public ResponseEntity<?> getPersonajes() {
		ResponseEntity<?> response = null;
		List<Personaje> pjs = pj.getPersonajes();
		if (pjs != null) {
			response = ResponseEntity.status(HttpStatus.OK).body(pjs);
		} else {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrados.");
		}
		return response;
	}

	@GetMapping("/{idPersonaje}")
	public ResponseEntity<?> getPersonaje(@PathVariable Long idPersonaje) {
		ResponseEntity<?> response = null;
		Personaje personaje = pj.getPersonaje(idPersonaje);
		if (personaje != null) {
			response = ResponseEntity.status(HttpStatus.OK).body(personaje);
		} else {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrados.");
		}
		return response;
	}

	@PostMapping("")
	public ResponseEntity<?> postPersonaje(@RequestBody Personaje sent) {
		ResponseEntity<?> response = null;
		Personaje personaje = pj.postPersonaje(sent);
		if (personaje != null) {
			response = ResponseEntity.status(HttpStatus.OK).body(personaje);
		} else {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrados.");
		}
		return response;
	}

	@PutMapping("/{idPersonaje}")
	public ResponseEntity<?> putPersonaje(@RequestBody Personaje change, @PathVariable Long idPersonaje) {
		ResponseEntity<?> response = null;
		Personaje personaje = pj.putPersonaje(change, idPersonaje);
		if (personaje != null) {
			response = ResponseEntity.status(HttpStatus.OK).body(personaje);
		} else {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrados.");
		}
		return response;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePersonaje(@PathVariable Long id) {
		ResponseEntity<?> response = null;
		Personaje personaje = pj.deletePersonaje(id);
		if (personaje != null) {
			response = ResponseEntity.status(HttpStatus.OK).body(personaje);
		} else {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrados.");
		}
		return response;
	}

}
