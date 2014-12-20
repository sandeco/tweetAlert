package com.tweetalert;

import com.tweetalert.dao.TermDAO;
import com.tweetalert.dao.TermDAOImpl;
import com.tweetalert.model.Term;
import com.tweetalert.util.DaoException;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class Tests extends Activity {

	private TermDAO termDao = new TermDAOImpl(this);
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tests);
		
		Term term = new Term();
		term.setProfile("@sandeco");
		term.setTerm("maintenance");
		
		try {
			term = termDao.create(term);
		} catch (DaoException e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tests, menu);
		return true;
	}

}
