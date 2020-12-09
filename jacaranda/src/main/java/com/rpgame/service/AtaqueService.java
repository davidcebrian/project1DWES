package com.rpgame.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpgame.entity.Ataque;
import com.rpgame.repositorys.AtaqueRepository;

@Service
public class AtaqueService {

	@Autowired
	private AtaqueRepository ataqueRepository;

	public List<Ataque> getAtaques() {
		ArrayList<Ataque> atq = null;
		if(ataqueRepository.findAll().iterator().hasNext()) {
			atq = (ArrayList<Ataque>) ataqueRepository.findAll();
		}else {
			atq = null;
		}
		return atq;
	}

	public Ataque getAtaque(Long idAtaque) {
		Ataque ata = ataqueRepository.findAtaqueByIdAtaque(idAtaque);
		return ata;
	}

	public Ataque postAtaque(Ataque sent) {
		if(sent != null) {
			ataqueRepository.save(sent);
		}
		return sent;
	}

	public Ataque putAtaque(Ataque change, Long id) {
		Ataque ata = ataqueRepository.findAtaqueByIdAtaque(id);
		if (change != null && ata != null) {
			ataqueRepository.updateAtaque(id, change.getNombre());
		}
		return ata;
	}

	public Ataque deleteAtaque(Long id) {
		Ataque ata = ataqueRepository.findAtaqueByIdAtaque(id);
		if(ata != null) {
			ataqueRepository.deleteById(id);			
		}
		return ata;
	}
}
