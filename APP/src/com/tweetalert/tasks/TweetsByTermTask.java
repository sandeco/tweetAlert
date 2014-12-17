package com.tweetalert.tasks;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.TwitterException;

public class TweetsByTermTask extends TwitterTaskAbstrat{


	List<twitter4j.Status> tweets = null;
	
	@Override
	protected List<twitter4j.Status> doInBackground(String... params) {

		
		Query query = new Query(params[0]);
		QueryResult result;

		try {
			result = twitter.search(query);
			tweets = result.getTweets();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tweets;
	}




}
