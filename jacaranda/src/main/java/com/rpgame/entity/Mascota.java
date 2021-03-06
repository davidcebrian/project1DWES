package com.rpgame.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Mascota entity
 * 
 * @author estudiante
 *
 */

@Entity
public class Mascota implements Comparable<Mascota>, Serializable {
	private String name;
	private String tipo;
	private String elemento;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne(mappedBy = "mascota")
	private Personaje personaje;

	public Mascota() {

	}

	public Mascota(String name, String tipo, String elemento) {
		super();
		this.name = name;
		this.tipo = tipo;
		this.elemento = elemento;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int compareTo(Mascota arg0) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(arg0.getName());
	}

	@Override
	public String toString() {
		return "Mascota [name=" + name + ", tipo=" + tipo + ", elemento=" + elemento + ", id=" + id + "]";
	}

}
