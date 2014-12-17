package com.tweetalert.service;

import java.util.List;

import twitter4j.Status;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import com.tweetalert.tasks.TweetsByUserTask;
import com.tweetalert.tasks.TwitterTaskListener;
import com.tweetalert.util.InternetCheck;
import com.tweetalert.util.MyApp;

public class TwitterService extends Service implements TwitterTaskListener{
	
	private Notifyer notifyer;
	private String user = "@EASPORTSFIFA";
	//private String user = "@sandeco";
	private String term = "maintenance";
	
	private long lastTweet = 0;
	private final int INTERVAL  = 20 * 1000;
	private boolean running = false;

	
	
	@Override
	public void onCreate() {
		super.onCreate();
		notifyer = new Notifyer();
		running = true;
	}


	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		verifyTwitter();
		Toast.makeText(MyApp.getAppContext(), "Ativando verificação de manutenção do EA server no twitter", Toast.LENGTH_SHORT).show();
		return START_STICKY;	
	}

	
	
	public void verifyTwitter() {
		if(InternetCheck.isConnected(MyApp.getAppContext())){
			TweetsByUserTask task = new TweetsByUserTask();
			task.addListener(this);
			task.execute(user);			
		}else{
			reloadVerify();
		}
	}

	
	@Override
	public void update(List<twitter4j.Status> result) {

		for(Status tweet : result){
			//pega o texto do tweet e transforma tudo em minusculo
			String twt = tweet.getText().toLowerCase();

			//verifica o termo
			int i = twt.indexOf(term);

			// se encontrar chama o alerta
			if(i>=0 && tweet.getId()>lastTweet){
				lastTweet = tweet.getId();
				notifyer.alertTermFind(tweet,term);				
			}
		}
		

		reloadVerify();
	}


	private void reloadVerify() {
		if(running){
			try {
				Thread.sleep(INTERVAL);
				verifyTwitter();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public IBinder onBind(Intent intent) {		
		return null;
	}



	@Override
	public void onDestroy() {
		running = false;
		super.onDestroy();
	}

	

}
