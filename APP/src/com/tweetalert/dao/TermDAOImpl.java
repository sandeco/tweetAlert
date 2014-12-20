package com.tweetalert.dao;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;

import com.tweetalert.model.Term;
import com.tweetalert.util.DaoException;

public class TermDAOImpl extends GenericDAOImpl<Term, Integer>implements TermDAO {

	public TermDAOImpl(Context context) {
		super(context);
	}

	@Override
	public List<Term> listALL() {

		return null;
	}

	@Override
	public Term create(Term entity) throws DaoException{
		Term term = new Term();
		getDb().beginTransaction();
		
		
		try {
			ContentValues values = new ContentValues();
			values.put("_id", entity.getId());
			values.put("term", entity.getTerm());
			values.put("profile", entity.getProfile());
			 
			getDb().insertOrThrow("term", null, values);
		
			
		} catch (SQLException e) {
			throw new DaoException("Erro ao criar termo", e);
		}
			
		getDb().setTransactionSuccessful(); //commit
		
		return term;
	}

	
	
	@Override
	public Term update(Term entity) {

		return null;
	}

	@Override
	public Term findById(Integer id) {

		return null;
	}

	@Override
	public boolean delete(Term entity) {

		return false;
	}

	@Override
	public Term getLastById() {
		
		Cursor cursor = getDb().rawQuery("Select * from " + Term.TABLE_NAME + 
									 " order by _id desc limit 1", null);
		cursor.moveToFirst();
		
		Term term = new Term();
		term.setId(cursor.getInt(cursor.getColumnIndex(Term.ID)));
		term.setTerm(cursor.getString(cursor.getColumnIndex(term.TERM)));
		term.setProfile(cursor.getString(cursor.getColumnIndex(Term.PROFILE)));
		
		return term;
	}


}
