package me.eto.helloworld.storage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;

public class PendingNotifications {

	
	private static void registerAlarm(Context context){
		AlarmManager am =(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
		Intent aPrivateIntent = new Intent();
		PendingIntent pi = PendingIntent.getActivity(context, 0, aPrivateIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		PendingIntent sign = PendingIntent.getBroadcast(context, 0, new Intent(), PendingIntent.FLAG_ONE_SHOT);
		
		
		am.setRepeating(AlarmManager.ELAPSED_REALTIME, 1000, 10*60*1000, pi);
	}
	
	private static void doAction(PendingIntent pi){
		try {
			pi.send();
		} catch (CanceledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
