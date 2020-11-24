package com.rpgame.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rpgame.entity.Personaje;
import com.rpgame.entity.User;
import com.rpgame.repositorys.PersonajeRepository;
import com.rpgame.repositorys.UserRepository;

@Service
public class PersonajeService {

	@Autowired
	private PersonajeRepository personajeRepository;

	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	public PersonajeService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}	

	public ResponseEntity<?> getPersonajes() {
		ResponseEntity<?> pjs = null;
		if(personajeRepository.findAll().iterator().hasNext()) {
			pjs = ResponseEntity.ok(personajeRepository.findAll());
		}else {
			pjs = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existen usuarios.");
		}
		return pjs;
	}

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
	
	public List<Personaje> getPersonajeFromUser(Long idUser) throws Exception {
		User us = userRepository.findUserByIdUsuario(idUser);
		List<Personaje> pjs = null;
		if (us != null) {
			pjs = us.getPersonajes();
		} else {
			throw new Exception("El usuario no ha sido encontrado.");
		}
		return pjs;
	}

	public ResponseEntity<?> postPersonaje(Personaje sent) {
		ResponseEntity<?> resp = null;
		if(sent != null) {
			personajeRepository.save(sent);
			resp = ResponseEntity.status(HttpStatus.OK).body(sent);
		}else {
			resp = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Introduzca un personaje.");
		}
		return resp;
	}
	

	public ResponseEntity<?> putPersonaje(Personaje change, Long id) {
		ResponseEntity<?> ent = null;
		Personaje pj = personajeRepository.findPersonajeByIdPersonaje(id);
		if (change != null && pj != null) {
			personajeRepository.updatePersonaje(id, change.getName());
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

	
	public void setPersonajeRepository(PersonajeRepository personajeRepository) {
		this.personajeRepository = personajeRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
}
