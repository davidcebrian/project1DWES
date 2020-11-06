package com.rpgame.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rpgame.entity.Personaje;
import com.rpgame.repositorys.PersonajeRepository;

@Service
public class PersonajeService {

	@Autowired
	private PersonajeRepository personajeRepository;

	public ResponseEntity<?> getPersonajes() {
		ResponseEntity<?> pjs = null;
		if(personajeRepository.findAll().iterator().hasNext()) {
			pjs = ResponseEntity.ok(personajeRepository.findAll());
		}else {
			pjs = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existen usuarios.");
		}
		return pjs;
	}

//	public ResponseEntity<?> getPersonajesUser(User user) {
//		ResponseEntity<?> pjs = null;
//		List<Personaje> persnjs = new ArrayList<>();
//		for (Personaje pj : db.getPersonajes()) {
//			if (pj.getUsuario().getId() == user.getId()) {
//				persnjs.add(pj);
//			}
//		}
//		pjs = ResponseEntity.status(HttpStatus.OK).body(persnjs);
//		return pjs;
//	}

	public ResponseEntity<?> getPersonaje(Long idPersonaje) {
		ResponseEntity<?> pj = null;
		Personaje us = personajeRepository.findPersonajeByIdPersonaje(idPersonaje);
		if (us != null) {
			pj = ResponseEntity.status(HttpStatus.OK).body(us);
		} else {
			pj = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
		}
		return pj;
	}

	public ResponseEntity<?> postPersonaje(Personaje sent) {
		ResponseEntity<?> resp = null;
		if(sent != null) {
			personajeRepository.save(sent);
			resp = ResponseEntity.status(HttpStatus.OK).body(sent);
		}else {
			resp = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Introduzca un usuario.");
		}
		return resp;
	}
	

	public ResponseEntity<?> putPersonaje(Personaje change) {
		ResponseEntity<?> ent = null;
		Personaje pj = personajeRepository.findPersonajeByIdPersonaje(change.getIdPersonaje());
		if (change != null && pj != null) {
			personajeRepository.updatePersonaje(change.getIdPersonaje(), change.getName());
			ent = ResponseEntity.ok(change);
		} else {
			ent = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
		}
		return ent;
	}

	public ResponseEntity<?> deletePersonaje(Long id) {
		ResponseEntity<?> ent = null;
		Personaje pj = personajeRepository.findPersonajeByIdPersonaje(id);
		if(pj != null) {
			personajeRepository.deleteById(id);			
			ent = ResponseEntity.status(HttpStatus.ACCEPTED).body("Usuario borrado.");
		}else {
			ent = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");			
		}
		return ent;
	}

}
