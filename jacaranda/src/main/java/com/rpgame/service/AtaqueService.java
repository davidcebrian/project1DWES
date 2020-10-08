package com.rpgame.service;


import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rpgame.entity.Ataque;
import com.rpgame.entity.Personaje;

@Service
public class AtaqueService {

	@Autowired
	private DatabaseService db;
	
	public ResponseEntity<?> getAtaques(){
		ResponseEntity<?> pjs = null;
		pjs = ResponseEntity.status(HttpStatus.OK).body(db.getAtaques());
		return pjs;
	}
	
	
	public ResponseEntity<?> getAtaquesPj( String idPj){
		ResponseEntity<?> atq = null;
		for(Personaje pj: db.getPersonajes()) {
			if(pj.getName().compareTo(idPj) == 0) {
				atq = ResponseEntity.status(HttpStatus.OK).body(pj.getAtaques());
			}else {
				atq = ResponseEntity.status(HttpStatus.OK).body("No se encontró el personaje.");
			}
		}
		return atq;
	}
	

	public ResponseEntity<?> getAtaque(int idAtaque){
		ResponseEntity<?> atq = null;
		Ataque ata = db.getAtaques().stream().filter(a -> a.getIdAtaque() == idAtaque).findFirst().get();
		if(ata != null) {
			atq = ResponseEntity.status(HttpStatus.OK).body(ata);
		}else {
			atq = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
		}		
		return atq;
	}
	
	public ResponseEntity<?> postAtaque( Ataque sent, String idPersonaje) {
		ResponseEntity<?> resp = null;
		Iterator<Personaje> it = db.getPersonajes().iterator();
		boolean flag = false;
		while(it.hasNext() && !flag) {
			Personaje elemento = it.next();
			if(elemento.getName().compareTo(idPersonaje) == 0) {
				sent.getPersonajes().add(idPersonaje);
				elemento.getAtaques().add(sent);
				db.getAtaques().add(sent);
				resp = ResponseEntity.status(HttpStatus.CREATED).body(sent);
			}else {
				resp = ResponseEntity.status(HttpStatus.NOT_FOUND).body("El personaje al que desea añadir el ataque no existe.");;
			}
		}
		return resp;
	}
	
	public ResponseEntity<?> putAtaque(Ataque change){
		ResponseEntity<?> ent = null;
		Iterator<Ataque> it = db.getAtaques().iterator();
		boolean flag = false;
		while(it.hasNext() && !flag) {
			Ataque elemento = it.next();
			if(elemento.getIdAtaque() == change.getIdAtaque()) {
				elemento.setCooldown(change.getCooldown());
				elemento.setDaño(change.getDaño());
				elemento.setElemento(change.getElemento());
				elemento.setNombre(change.getNombre());
				elemento.setRango(change.getRango());
				elemento.setTipo(change.getTipo());
				flag = true;
				ent = ResponseEntity.ok(change);
			}else {
				ent = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
			}
		}
		return ent;
	}
	
	public ResponseEntity<?> deleteAtaque(int id){
		ResponseEntity<?> ent = null;
		Ataque ataq = db.getAtaques().stream().filter(a -> a.getIdAtaque() == id).findFirst().get();
		if(ataq != null) {
			Iterator<Personaje> it = db.getPersonajes().iterator();
			while(it.hasNext()) {
				Personaje elemento = it.next();
				if(elemento.getAtaques().contains(ataq)) {
					elemento.getAtaques().remove(ataq);
				}
			}
			db.getAtaques().remove(ataq);
			ent = ResponseEntity.status(HttpStatus.ACCEPTED).body("Ataque borrado.");
		}else {
			ent = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
		}
		
		return ent;
	}
}
