package com.tweetalert.util;

import android.app.Application;
import android.content.Context;
import android.util.Log;


public class MyApp extends Application{
	private static Context context;

    public void onCreate(){
        super.onCreate();
        MyApp.context = getApplicationContext();
        Log.d("entrou : ", "contexto");
    }

    public static Context getAppContext() {
        return MyApp.context;
    }
}


