package com.rpgame.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Attack entity
 * @author estudiante
 *
 */
public class Ataque implements Comparable<Ataque>, Serializable{
	private static int idTot = 1;
	private String nombre;
	private double daño;
	private String elemento;
	private String tipo;
	private double cooldown;
	private int rango;
	private int idAtaque;
	private List<String> personajes;
	
	public Ataque() {
		personajes = new ArrayList<>();
		this.idAtaque = idTot;
		idTot ++;
	}
	
	public Ataque(String nombre, double daño, String elemento, String tipo, double cooldown, int rango) {
		super();
		this.nombre = nombre;
		this.daño = daño;
		this.elemento = elemento;
		this.tipo = tipo;
		this.cooldown = cooldown;
		this.rango = rango;
		this.idAtaque = idTot;
		idTot++;
		personajes = new ArrayList<>();
	}
	
	
	public List<String> getPersonajes() {
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

	public int getIdAtaque() {
		return idAtaque;
	}

	
	@Override
	public String toString() {
		return "Ataque [nombre=" + nombre + ", daño=" + daño + ", elemento=" + elemento + ", tipo=" + tipo
				+ ", cooldown=" + cooldown + ", rango=" + rango + ", idAtaque=" + idAtaque + "]";
	}

	@Override
	public int compareTo(Ataque other) {
		// TODO Auto-generated method stub
		return Integer.valueOf(this.getIdAtaque()).compareTo(other.getIdAtaque());
	}
	
	
	
}
