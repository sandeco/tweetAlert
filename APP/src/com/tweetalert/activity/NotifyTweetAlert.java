package com.tweetalert.activity;

import twitter4j.Status;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.tweetalert.R;
import com.tweetalert.service.Notifyer;

public class NotifyTweetAlert extends Activity {

	private TextView tweetText;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notify_tweet_alert);
		
		tweetText = (TextView) findViewById(R.id.tweet);
		
		String ns = this.NOTIFICATION_SERVICE;
	    NotificationManager nMgr = (NotificationManager) this.getSystemService(ns);
	    nMgr.cancel(Notifyer.NOTIFY_ID);
		
	    Intent i = this.getIntent();
	    Bundle e = i.getExtras();
	    
	    Status tweet = (Status) e.getSerializable("tweet");
	    
	    String txt =tweet.getCreatedAt().toString() + "\n" +
	    		tweet.getUser().getScreenName() + "\n" +   		
	    		tweet.getText(); 
	    
	    
	    this.tweetText.setText(txt);
	    
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.notify_tweet_alert, menu);
		return true;
	}

}
