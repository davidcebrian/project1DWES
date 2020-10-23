package com.rpgame.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rpgame.entity.Personaje;
import com.rpgame.entity.User;

@Service
public class PersonajeService {
	@Autowired
	private DatabaseService db;
	
	public ResponseEntity<?> getPersonajes(){
		ResponseEntity<?> pjs = null;
		pjs = ResponseEntity.status(HttpStatus.OK).body(db.getPersonajes());
		return pjs;
	}
	
	
	public ResponseEntity<?> getPersonajesUser(int idUser){
		ResponseEntity<?> pjs = null;
		List<Personaje> persnjs = new ArrayList<>();
		for(Personaje pj: db.getPersonajes()) {
			if(pj.getUsuario() == idUser) {
				persnjs.add(pj);
			}
		}
		pjs = ResponseEntity.status(HttpStatus.OK).body(persnjs);
		return pjs;
	}
	

	public ResponseEntity<?> getPersonaje( String idPersonaje){
		ResponseEntity<?> pj = null;
		Iterator<Personaje> it = db.getPersonajes().iterator();
		boolean flag = false;
		while(it.hasNext() && !flag) {
			Personaje elemento = it.next();
			if(elemento.getName().equals(idPersonaje)) {
				pj = ResponseEntity.status(HttpStatus.OK).body(elemento);
			}else {
				pj = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
			}
		}
			return pj;
	}
	
	public ResponseEntity<?> postPersonaje( Personaje sent,  int idUser) {
		ResponseEntity<?> resp = null;
		Iterator<User> it = db.getUsuarios().iterator();
		boolean flag = false;
		while(it.hasNext() && !flag) {
			User elemento = it.next();
			if(elemento.getId() == idUser) {
				elemento.getPersonajes().add(sent);
				db.getPersonajes().add(sent);
				resp = ResponseEntity.status(HttpStatus.CREATED).body(sent);
			}else {
				resp = ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario al que desea añadir el pj no existe.");;
			}
		}
		return resp;
	}
	
	public ResponseEntity<?> putPersonaje( Personaje change){
		ResponseEntity<?> ent = null;
		Iterator<Personaje> it = db.getPersonajes().iterator();
		boolean flag = false;
		while(it.hasNext() && !flag) {
			Personaje elemento = it.next();
			if(elemento.getName().compareTo(change.getName()) == 0) {
				elemento.setAtaques(change.getAtaques());
				elemento.setCara(change.getCara());				
				elemento.setCuerpo(change.getCuerpo());
				elemento.setMascota(change.getMascota());
				elemento.setNivel(change.getNivel());
				elemento.setPelo(change.getPelo());
				elemento.setPoder(change.getPoder());
				elemento.setRopa(change.getRopa());
				elemento.setTipo(change.getTipo());
				elemento.setUsuario(change.getUsuario());
				flag = true;
				ent = ResponseEntity.ok(change);
			}else {
				ent = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
			}
		}
		//customers.stream().filter(c -> c.getId() == change.getId()).findFirst().get();
		return ent;
	}
	
	public ResponseEntity<?> deletePersonaje( String id){
		ResponseEntity<?> ent = null;
		Personaje pj = db.getPersonajes().stream().filter(p -> p.getName().compareTo(id) == 0).findFirst().get();
		User us = db.getUsuarios().stream().filter(u -> u.getPersonajes().contains(pj)).findFirst().get();
		if(pj != null && us != null) {
			db.getPersonajes().remove(pj);
			us.getPersonajes().remove(pj);
			ent = ResponseEntity.status(HttpStatus.ACCEPTED).body("Personaje borrado.");
		}else {
			ent = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
		}
		
		return ent;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
