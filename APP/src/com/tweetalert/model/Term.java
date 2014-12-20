package com.tweetalert.model;

import java.io.Serializable;

public class Term implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String term;
	private String profile;
	
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

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	
	
	public static final String TABLE_NAME = "term";
	public static final String ID    = "_id";
	public static final String TERM  = "nome";
	public static final String PROFILE  = "profile";
 
	public static final String CREATE_TABLE = "" +
	
							   "CREATE TABLE terms (" +
							   "_id INTEGER PRIMARY KEY, "+ 
							   "termo TEXT, " +
							   "profile TEXT )";
									
										
}
