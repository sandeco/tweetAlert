package com.tweetalert.model;

import java.io.Serializable;

public class Tweet implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String text;
	private String date;
	private String user;
	
	public Tweet(){}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
	
	public static final String TABLE_NAME = "tweet";
	public static final String ID    = "_id";
	public static final String TEXT  = "text";
	public static final String USER  = "user";
	
	public static final String[] COLUNAS = new String[]{Tweet.ID,Tweet.TEXT,Tweet.USER};

	public static final String CREATE_TABLE = "" +
	
			
								"CREATE TABLE tweet (" +
								"_id long PRIMARY KEY," + 
								"text TEXT," +
								"date TEXT," +
								"user TEXT)";
	
}
