package com.aurionpro.bms.models;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;

import com.aurionpro.bms.properties.DocumentType;

public class Document {
	private int id;
	private int userId;
	private  byte[] file;
	private String name;
	private DocumentType type;
	private Timestamp createdAt;
	
	public Document() {
		super();
	}
	public Document(int id, int userId, byte[] file, String name, DocumentType type, Timestamp createdAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.file = file;
		this.name = name;
		this.type = type;
		this.createdAt = createdAt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DocumentType getType() {
		return type;
	}
	public void setType(DocumentType type) {
		this.type = type;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Document [id=" + id + ", userId=" + userId +  name
				+ ", type=" + type + ", createdAt=" + createdAt + "]";
	}
	
	
}
