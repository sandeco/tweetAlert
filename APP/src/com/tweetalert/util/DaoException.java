package com.tweetalert.util;

import android.database.SQLException;

public class DaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SQLException sqlException; 
	private String message;
	
	public DaoException(String message, SQLException e) {
		this.message = message;
		this.sqlException = e;
	}

	public SQLException getSqlException() {
		return sqlException;
	}

	public void setSqlException(SQLException sqlException) {
		this.sqlException = sqlException;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
