package com.tweetalert.tasks;

import java.util.List;

public interface TwitterTaskListener {
	
	public void update(List<twitter4j.Status> result);

}
