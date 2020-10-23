package com.rpgame.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rpgame.entity.Ataque;
import com.rpgame.entity.Mascota;
import com.rpgame.entity.Personaje;
import com.rpgame.entity.User;

@Service
public class DatabaseService {
	private List<User> usuarios;
	private List<Personaje> personajes;
	private List<Ataque> ataques;
	private List<Mascota> mascotas;
	
	public DatabaseService() {
		super();
		this.usuarios = new ArrayList<>();
		this.personajes = new ArrayList<>();
		this.ataques = new ArrayList<>();
		this.mascotas = new ArrayList<>();
	}
	
	public DatabaseService(List<User> usuarios, List<Personaje> personajes, List<Ataque> ataques,
			List<Mascota> mascotas) {
		super();
		this.usuarios = usuarios;
		this.personajes = personajes;
		this.ataques = ataques;
		this.mascotas = mascotas;
	}

	public List<User> getUsuarios() {
		return usuarios;
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public List<Ataque> getAtaques() {
		return ataques;
	}

	public List<Mascota> getMascotas() {
		return mascotas;
	}
	
	
	
	
}
