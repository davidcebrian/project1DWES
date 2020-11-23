package com.rpgame.entity;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Document implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Blob picture;
	
	private String fileName;
	
	private Integer fileSize;
	
	public Document() {
		super();
	}
	
	public Document(Blob pic, String name, Integer size) {
		this.picture = pic;
		this.fileName = name;
		this.fileSize = size;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}
	
}
