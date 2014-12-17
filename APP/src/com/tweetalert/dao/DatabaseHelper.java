package com.tweetalert.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String BANCO_DADOS = "tweetalert";
	private static final int VERSAO = 1;

	public DatabaseHelper(Context context) {
		super(context, BANCO_DADOS, null, VERSAO);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL("CREATE TABLE tweet (_id long PRIMARY KEY, "+ 
                    "text TEXT, "+
                    "date TEXT, "+
                    "user TEXT)");
		
		db.execSQL("CREATE TABLE terms (_id INTEGER PRIMARY KEY, "+ 
                    "termo TEXT, " +
                    "profile TEXT )");
                    
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
	
}
