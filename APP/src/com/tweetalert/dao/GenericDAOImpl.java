package com.tweetalert.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public abstract class GenericDAOImpl<T, ID extends Serializable>  implements GenericDAO<T, ID> {

	private SimpleDateFormat dateFormat;
	private DatabaseHelper helper;
	private SQLiteDatabase db;
	
	public GenericDAOImpl(Context context) {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		helper = new DatabaseHelper(context);
	}

	protected SQLiteDatabase getDb() {
		if (db == null)
			db = helper.getWritableDatabase();

		return db;
	}
		
	protected void close() {
		helper.close();
	}

	protected SimpleDateFormat getDateFormat() {
		return dateFormat;
	}


	protected DatabaseHelper getHelper() {
		return helper;
	}

}
