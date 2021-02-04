package com.rpgame.security.model.dto;

public class UserDto {

	
	private String surname;
	private String password;
	private String mail;
	private boolean vip;
	
	
	
	public UserDto() {
		super();
	}
	
	public UserDto(String surname, String password, String mail, boolean vip) {
		super();
		this.surname = surname;
		this.password = password;
		this.mail = mail;
		this.vip = vip;
	}
	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
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
	
}
