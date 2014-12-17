package com.tweetalert.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TwitterBroadcast extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent arg1) {
				
		Intent it = new Intent(context, TwitterService.class);
		context.startService(it);		
	}

}
