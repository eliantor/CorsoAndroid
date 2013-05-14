package me.eto.helloworld.services;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service{

	final static String ARGUMENTS = "ARGS";
	
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("SERVICE", "WELOCME MY FRIEND...");
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
//		if((START_FLAG_RETRY & flags)!=0){
//			// ACCADE SE RESTITUISCO START_STICKY
//		}else if((START_FLAG_REDELIVERY & flags)!=0){
//			// ACCADE SE RESTITUISCO START_REDELIVER_INTENT
//			assert intent != null;
//		}
		
		//return START_NOT_STICKY; muore e basta
		//return START_STICKY;
//		return START_REDELIVER_INTENT;
		
		String message = intent.getStringExtra(ARGUMENTS);
		Log.d("SERVICE", message);
		stopSelf(startId);
		return START_NOT_STICKY;
	}

	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("SERVICE", "THE END");
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	}

	/////// BINDING TO A SERVICE
	@Override
	public IBinder onBind(Intent intent) {
		return new LocalBinder(this);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		return super.onUnbind(intent);
	}
	
	public void logSomething(String message){
		Log.d("SERVICE", message);
	}
	
	public static class LocalBinder extends Binder{
		private final MyService fService;
		
		private LocalBinder(MyService service){
			fService=service;
		}
		public MyService getService(){
			return fService;
		}
	}
}
