package com.rpgame.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rpgame.entity.Personaje;
import com.rpgame.repositorys.PersonajeRepository;
import com.rpgame.security.model.User;
import com.rpgame.security.repo.UserRepository;

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

	public List<Personaje> getPersonajes() {
		List<Personaje> pjs = null;
		if(personajeRepository.findAll().iterator().hasNext()) {
			pjs = (List<Personaje>) personajeRepository.findAll();
		}else {
			pjs = null;
		}
		return pjs;
	}

	public Personaje getPersonaje(Long idPersonaje) {
		Personaje us = personajeRepository.findPersonajeByIdPersonaje(idPersonaje);
		return us;
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

	public Personaje postPersonaje(Personaje sent) {
		if(sent != null) {
			personajeRepository.save(sent);
		}
		return sent;
	}
	

	public Personaje putPersonaje(Personaje change, Long id) {
		Personaje pj = personajeRepository.findPersonajeByIdPersonaje(id);
		if (change != null && pj != null) {
			personajeRepository.updatePersonaje(id, change.getName());
		}
		return pj;
	}

	public Personaje deletePersonaje(Long id) {
		Personaje pj = personajeRepository.findPersonajeByIdPersonaje(id);
		if(pj != null) {
			personajeRepository.deleteById(id);			
		}
		return pj;
	}

	
	public void setPersonajeRepository(PersonajeRepository personajeRepository) {
		this.personajeRepository = personajeRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
}
