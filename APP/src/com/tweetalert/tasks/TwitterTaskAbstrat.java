package com.tweetalert.tasks;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;

import com.tweetalert.util.TwitterConfig;

import android.os.AsyncTask;

public abstract class TwitterTaskAbstrat extends AsyncTask<String, String, List<twitter4j.Status>>{
	
	List<TwitterTaskListener> listeners = new ArrayList<TwitterTaskListener>();
	
	
	protected TwitterFactory tf;        
    
	protected Twitter twitter;

	public TwitterTaskAbstrat(){
		tf = new TwitterFactory(TwitterConfig.getConfigurationBuilder().build());
		twitter = tf.getInstance();
	}
	
	@Override
	protected void onPostExecute(List<twitter4j.Status> result) {
		for(TwitterTaskListener listener:listeners)
			listener.update(result);
		super.onPostExecute(result);
	}
	

	public void addListener(TwitterTaskListener listener){
		listeners.add(listener);
	}
	

}
