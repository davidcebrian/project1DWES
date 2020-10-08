package com.rpgame.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Personaje entity
 * @author estudiante
 *
 */
public class Personaje implements Comparable<Personaje>, Serializable{
	private String name;
	private String cara;
	private String cuerpo;
	private String pelo;
	private String ropa;
	private String tipo;
	private int poder;
	private int nivel;
	private int perteneceUsuario;
	private List<Ataque> ataques;
	private Mascota mascota;
	
	
	public Personaje() {
		this.ataques = new ArrayList();
	}
	
	
	public Personaje(int usuario, String name, String cara, String cuerpo, String pelo, String ropa, String tipo, int poder) {
		super();
		this.perteneceUsuario = usuario;
		this.name = name;
		this.cara = cara;
		this.cuerpo = cuerpo;
		this.pelo = pelo;
		this.ropa = ropa;
		this.tipo = tipo;
		this.poder = poder;
		this.nivel = 1;
		this.ataques = new ArrayList();
	}
	
	


	public int getUsuario() {
		return perteneceUsuario;
	}


	public void setUsuario(int usuario) {
		this.perteneceUsuario = usuario;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCara() {
		return cara;
	}


	public void setCara(String cara) {
		this.cara = cara;
	}


	public String getCuerpo() {
		return cuerpo;
	}


	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}


	public String getPelo() {
		return pelo;
	}


	public void setPelo(String pelo) {
		this.pelo = pelo;
	}


	public String getRopa() {
		return ropa;
	}


	public void setRopa(String ropa) {
		this.ropa = ropa;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getPoder() {
		return poder;
	}


	public void setPoder(int poder) {
		this.poder = poder;
	}


	public int getNivel() {
		return nivel;
	}


	public void setNivel(int nivel) {
		this.nivel = nivel;
	}


	public List<Ataque> getAtaques() {
		return ataques;
	}


	public void setAtaques(List<Ataque> ataques) {
		this.ataques = ataques;
	}


	public Mascota getMascota() {
		return mascota;
	}


	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

		

	@Override
	public String toString() {
		return "Personaje [name=" + name + ", cara=" + cara + ", cuerpo=" + cuerpo + ", pelo=" + pelo + ", ropa=" + ropa
				+ ", tipo=" + tipo + ", poder=" + poder + ", nivel=" + nivel + ", ataques=" + ataques + ", mascota="
				+ mascota + "]";
	}


	@Override
	public int compareTo(Personaje arg0) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(arg0.getName());
	}
}
