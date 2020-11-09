package com.rpgame.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rpgame.entity.Ataque;
import com.rpgame.repositorys.AtaqueRepository;

@Service
public class AtaqueService {

	@Autowired
	private AtaqueRepository ataqueRepository;

	public ResponseEntity<?> getAtaques() {
		ResponseEntity<?> atq = null;
		if(ataqueRepository.findAll().iterator().hasNext()) {
			atq = ResponseEntity.ok(ataqueRepository.findAll());
		}else {
			atq = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existen usuarios.");
		}
		return atq;
	}

	public ResponseEntity<?> getAtaque(Long idAtaque) {
		ResponseEntity<?> atq = null;
		Optional<Ataque> ata = ataqueRepository.findById(idAtaque);
		if (ata != null) {
			atq = ResponseEntity.status(HttpStatus.OK).body(ata);
		} else {
			atq = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado.");
		}
		return atq;
	}

	public ResponseEntity<?> postAtaque(Ataque sent) {
		ResponseEntity<?> resp = null;
		if(sent != null) {
			ataqueRepository.save(sent);
			resp = ResponseEntity.status(HttpStatus.OK).body(sent);
		}else {
			resp = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Introduzca un ataque.");
		}
		return resp;
	}

	public ResponseEntity<?> putAtaque(Ataque change, Long id) {
		ResponseEntity<?> ent = null;
		Ataque ata = ataqueRepository.findAtaqueByIdAtaque(id);
		if (change != null && ata != null) {
			ataqueRepository.updateAtaque(id, change.getNombre());
			ent = ResponseEntity.ok(change.toString());
		} else {
			ent = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
		}
		return ent;
	}

	public ResponseEntity<?> deleteAtaque(Long id) {
		ResponseEntity<?> ent = null;
		Ataque ata = ataqueRepository.findAtaqueByIdAtaque(id);
		if(ata != null) {
			ataqueRepository.deleteById(id);			
			ent = ResponseEntity.status(HttpStatus.ACCEPTED).body("Usuario borrado.");
		}else {
			ent = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");			
		}
		return ent;
	}
}
