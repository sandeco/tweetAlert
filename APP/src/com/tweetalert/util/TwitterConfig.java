package com.tweetalert.util;

import twitter4j.conf.ConfigurationBuilder;


public class TwitterConfig {

	public static String TWITTER_CONSUMER_KEY = "xfjsqGISXAUYHQo1a7xggNVxD";
	public static String TWITTER_CONSUMER_SECRET = "crAd2KhWkmUM2FwddbADjsCLZtqUh6V8AUZffuC8GUBbL5s3wd";	
	public static String TWITTER_ACCESS_TOKEN =  "24675439-d74UEohZDWHQ8eKZhfcfZ9W2jtogIjjgFWXCqOTF8";	
	public static String TWITTER_ACCESS_TOKEN_SECRET = "ASzzJQVPrQwnHNFmfZDwEslIEiGvMO5FYmlprvc7vMmfm";

	
	public static ConfigurationBuilder getConfigurationBuilder(){
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey(TwitterConfig.TWITTER_CONSUMER_KEY)
		  .setOAuthConsumerSecret(TwitterConfig.TWITTER_CONSUMER_SECRET)
		  .setOAuthAccessToken(TwitterConfig.TWITTER_ACCESS_TOKEN)
		  .setOAuthAccessTokenSecret(TwitterConfig.TWITTER_ACCESS_TOKEN_SECRET);
		
		return cb;
	}
	
	
}
