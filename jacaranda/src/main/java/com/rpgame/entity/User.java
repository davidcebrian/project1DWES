package com.rpgame.entity;

import java.io.Serializable;
import java.time.LocalDate;


/**
 * Customer entity
 * @author estudiante
 *
 */


public class User implements Comparable<User>, Serializable{
	private String name;
	private String surname;
	private String userName;
	private String mobileNumber;
	private String mail;
	private boolean vip;
	private int id;
	
	public User() {
		super();
	}
	

	
	public User(String name, String surname, String userName, String mail) {
		super();
		this.name = name;
		this.surname = surname;
		this.userName = userName;
		this.mail = mail;
	}





	public User(String name, String surname, String userName, String mobileNumber, String mail, boolean vip, int id) {
		super();
		this.name = name;
		this.surname = surname;
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.mail = mail;
		this.vip = vip;
		this.id = id;
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





	public void setId(int id) {
		this.id = id;
	}





	public int compareTo(User other) {
		return Integer.valueOf(this.getId()).compareTo(other.getId());
	}

}
