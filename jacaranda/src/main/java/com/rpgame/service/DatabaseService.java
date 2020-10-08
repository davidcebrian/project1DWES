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
		User us0 = new User("Rizo","PAM","RAISO","689299299", "davidcebrian@hotmail");
		Personaje pj = new Personaje(us0.getId(),"pepe","cara1","fornido","largo","hippie","elfo",400);
		Mascota mas = new Mascota("willy","wolf","fire");
		Ataque atq = new Ataque("Puño",50.5,"hielo","fisico",3.2,3);
		pj.setMascota(mas);
		pj.getAtaques().add(atq);
		us0.getPersonajes().add(pj);
		this.usuarios.add(us0);
		this.personajes = new ArrayList<>();
		this.personajes.add(pj);
		this.ataques = new ArrayList<>();
		this.ataques.add(atq);
		this.mascotas = new ArrayList<>();
		this.mascotas.add(mas);
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
