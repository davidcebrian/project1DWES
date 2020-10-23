package com.rpgame.entity;

import java.io.Serializable;

/**
 * Mascota entity
 * @author estudiante
 *
 */

public class Mascota implements Comparable<Mascota>, Serializable{
	private static int idMasc = 0;
	private String name;
	private String tipo;
	private String elemento;
	private int id;
	
	public Mascota() {
		
	}
	public Mascota(String name, String tipo, String elemento) {
		super();
		this.name = name;
		this.tipo = tipo;
		this.elemento = elemento;
		this.id =+ idMasc;
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
	
	public int getId() {
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
