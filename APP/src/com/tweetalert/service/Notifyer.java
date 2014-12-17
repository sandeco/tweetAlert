package com.tweetalert.service;

import twitter4j.Status;
import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.tweetalert.R;
import com.tweetalert.activity.NotifyTweetAlert;
import com.tweetalert.util.MyApp;


@SuppressLint("DefaultLocale")
public class Notifyer{

	public static int NOTIFY_ID=100;

	public void alertTermFind(Status tweet, String term){
		// criar notificação
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MyApp.getAppContext());
		mBuilder.setSmallIcon(R.drawable.ic_launcher);
		mBuilder.setContentTitle(term + " EA Server");
		mBuilder.setContentText("Foi detectada o termo " + term + " em " + tweet.getUser().getScreenName());

		
		Uri sound = Uri.parse("android.resource://" + MyApp.getAppContext().getPackageName() + "/" + R.raw.ea);
		mBuilder.setSound(sound);
		
		
		Intent resultIntent = new Intent(MyApp.getAppContext(), NotifyTweetAlert.class);

		resultIntent.putExtra("tweet", tweet);

		PendingIntent resultPendingIntent =
				PendingIntent.getActivity(
						MyApp.getAppContext(),
						0,
						resultIntent,
						PendingIntent.FLAG_UPDATE_CURRENT
						);

		mBuilder.setContentIntent(resultPendingIntent);


		
		// Gets an instance of the NotificationManager service
		NotificationManager mNotifyMgr = 
		(NotificationManager) MyApp.getAppContext().getSystemService(MyApp.NOTIFICATION_SERVICE);
		
		// Builds the notification and issues it.
		mNotifyMgr.notify(NOTIFY_ID, mBuilder.build());


	}


}
