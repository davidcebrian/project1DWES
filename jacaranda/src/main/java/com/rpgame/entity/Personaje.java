package com.rpgame.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rpgame.security.model.User;

/**
 * Personaje entity
 * 
 * @author estudiante
 *
 */

@Entity
public class Personaje implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersonaje;
	private String name;
	private String cara;
	private String cuerpo;
	private String pelo;
	private String ropa;
	private String tipo;
	private int poder;
	private int nivel;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(foreignKey = @ForeignKey(name = "personaje_FK"),name = "idUsuario")
	@JsonIgnore
	private User user;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "personaje_ataques",
			   joinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "personaje_ataque_FK"),name="idPersonaje"),
			   inverseJoinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "ataque_personaje_FK"),name="idAtaque"))
	private List<Ataque> ataques;
	@OneToOne
	@JoinColumn(name="idPersonaje")
	private Mascota mascota;

	public Personaje() {
		this.ataques = new ArrayList();
	}
	
	public Personaje(String name, String cara, String cuerpo, String pelo, String ropa, String tipo,
			int poder) {
		super();
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

	public Personaje(User usuario, String name, String cara, String cuerpo, String pelo, String ropa, String tipo,
			int poder) {
		super();
		this.user = usuario;
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

	public User getUsuario() {
		return user;
	}

	public void setUsuario(User usuario) {
		this.user = usuario;
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

	public Long getIdPersonaje() {
		return idPersonaje;
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
		return "Personaje [idPersonaje=" + idPersonaje + ", name=" + name + ", cara=" + cara + ", cuerpo=" + cuerpo
				+ ", pelo=" + pelo + ", ropa=" + ropa + ", tipo=" + tipo + ", poder=" + poder + ", nivel=" + nivel
				+ ", user=" + user.getId() + ", ataques=" + ataques + ", mascota=" + mascota + "]";
	}

}
