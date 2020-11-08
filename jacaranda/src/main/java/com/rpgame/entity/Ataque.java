package com.rpgame.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Attack entity
 * 
 * @author estudiante
 *
 */


@Entity
public class Ataque implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAtaque;
	private String nombre;
	private double daño;
	private String elemento;
	private String tipo;
	private double cooldown;
	private int rango;
	@ManyToMany(mappedBy = "ataques", cascade = CascadeType.PERSIST)
	private List<Personaje> personajes;

	public Ataque() {
		personajes = new ArrayList<>();
	}

	public Ataque(String nombre, double daño, String elemento, String tipo, double cooldown, int rango) {
		super();
		this.nombre = nombre;
		this.daño = daño;
		this.elemento = elemento;
		this.tipo = tipo;
		this.cooldown = cooldown;
		this.rango = rango;
		personajes = new ArrayList<>();
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getDaño() {
		return daño;
	}

	public void setDaño(double daño) {
		this.daño = daño;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getCooldown() {
		return cooldown;
	}

	public void setCooldown(double cooldown) {
		this.cooldown = cooldown;
	}

	public int getRango() {
		return rango;
	}

	public void setRango(int rango) {
		this.rango = rango;
	}

	public Long getIdAtaque() {
		return idAtaque;
	}

	@Override
	public String toString() {
		return "Ataque [nombre=" + nombre + ", daño=" + daño + ", elemento=" + elemento + ", tipo=" + tipo
				+ ", cooldown=" + cooldown + ", rango=" + rango + ", idAtaque=" + idAtaque + "]";
	}

}
