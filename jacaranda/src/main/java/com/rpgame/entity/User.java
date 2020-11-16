package com.rpgame.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Customer entity
 * 
 * @author estudiante
 *
 */

@Entity
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	private String name;
	private String surname;
	private String userName;
	private String mobileNumber;
	private String mail;
	private boolean vip;
	
	@OneToMany
	@JoinColumn(name="doc_id", foreignKey = @ForeignKey(name="doc_id_fk"), nullable = true)
	@JsonIgnore
	private List<Document> documents;
	
	@OneToMany(mappedBy = "user")
	private List<Personaje> personajes;

	public User() {
		super();
		this.personajes = new ArrayList();
	}

	public User(String name, String surname, String userName, String mobileNumber, String mail) {
		super();
		this.name = name;
		this.surname = surname;
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.mail = mail;
		this.personajes = new ArrayList();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	public Long getId() {
		return idUsuario;
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}

	@Override
	public String toString() {
		ArrayList<Long> pjs = new ArrayList<Long>();
		for(Personaje pj: personajes) {
			pjs.add(pj.getIdPersonaje());
		}
		return "User [name:" + name + ", surname:" + surname + ", userName:" + userName + ", mobileNumber:"
				+ mobileNumber + ", mail:" + mail + ", vip:" + vip + ", id:" + idUsuario + ", personajes:" + pjs + "]";
	}

}
