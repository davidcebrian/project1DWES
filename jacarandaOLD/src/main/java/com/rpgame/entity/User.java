package com.rpgame.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Customer entity
 * @author estudiante
 *
 */


public class User implements Comparable<User>, Serializable{
	private static int idTota = 1;
	private String name;
	private String surname;
	private String userName;
	private String mobileNumber;
	private String mail;
	private boolean vip;
	private int id;
	private List<Personaje> personajes;
	
	public User() {
		super();
		this.personajes = new ArrayList();
		this.id = idTota;
		idTota ++;
	}

	public User(String name, String surname, String userName, String mobileNumber, String mail) {
		super();
		this.name = name;
		this.surname = surname;
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.mail = mail;
		this.id =+ idTota;
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

	public int getId() {
		return id;
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}

	public int compareTo(User other) {
		return Integer.valueOf(this.getId()).compareTo(other.getId());
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", userName=" + userName + ", mobileNumber="
				+ mobileNumber + ", mail=" + mail + ", vip=" + vip + ", id=" + id + ", personajes=" + personajes + "]";
	}

}
