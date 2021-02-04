package com.rpgame.security.model;

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
import com.rpgame.entity.Document;
import com.rpgame.entity.Personaje;

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
	private String password;
	private boolean vip;
	
	@OneToMany
	@JoinColumn(name="doc_id", foreignKey = @ForeignKey(name="doc_id_fk"), nullable = true)
	@JsonIgnore
	private List<Document> documents;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Personaje> personajes;

	public User() {
		super();
		this.personajes = new ArrayList();
	}

	public User(String name, String surname, String userName, String mobileNumber, String mail, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.mail = mail;
		this.password = password;
		this.personajes = new ArrayList();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "User [idUsuario=" + idUsuario + ", name=" + name + ", surname=" + surname + ", userName=" + userName
				+ ", mobileNumber=" + mobileNumber + ", mail=" + mail + ", vip=" + vip 
				+ ", personajes=" + personajes + "]";
	}

}
