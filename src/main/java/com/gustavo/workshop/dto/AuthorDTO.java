package com.gustavo.workshop.dto;

import java.io.Serializable;

import com.gustavo.workshop.domain.User;

public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = -8125429375089716302L;
	
	private String id;
	private String name;
	
	public AuthorDTO() {
	}

	public AuthorDTO(User obj) {
		this.id = obj.getId();
		this.name = obj.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
