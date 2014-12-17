package com.tweetalert.model;

import java.io.Serializable;

public class Term implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String term;
	private String user;
	
	public Term(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
}
