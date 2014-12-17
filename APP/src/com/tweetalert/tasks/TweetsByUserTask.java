package com.tweetalert.tasks;

import java.util.List;

import twitter4j.TwitterException;

public class TweetsByUserTask extends TwitterTaskAbstrat{
		
	
	List<twitter4j.Status> tweets = null;
	
	@Override
	protected List<twitter4j.Status> doInBackground(String... params) {
		
		String user = params[0];
		
		try {
			tweets = twitter.getUserTimeline(user);
		} catch (TwitterException te) {
			//erro
		}

		return tweets;
	}
	
	
}



