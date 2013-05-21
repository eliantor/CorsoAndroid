package me.eto.helloworld.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class SimplePreferences extends FragmentActivity implements OnSharedPreferenceChangeListener{
	private static final String TIMES_OPENED = "TIMES_OPENED";
	private static final String PREFS = "PREFS";
	
	private void talkWithGlobalPreferences(){
		SharedPreferences prefs = getSharedPreferences(PREFS, Context.MODE_PRIVATE);
		int times = prefs.getInt(TIMES_OPENED, 0);
		
		Editor edit = prefs.edit();
		edit.putInt(TIMES_OPENED, times+1);
		edit.commit();
		
		Editor editor = prefs.edit()
			 .putInt(TIMES_OPENED, times+1)
			 .putBoolean("one", true);
		compatPrefCommit(editor);
		
		SharedPreferences privatePrefs = getPreferences(Context.MODE_PRIVATE);
		
		privatePrefs.registerOnSharedPreferenceChangeListener(this);
	}
	
	private void compatPrefCommit(final Editor editor){
		if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB){
			editor.apply();
		}else{
			new Thread(){
				public void run() {
					editor.commit();
				};
			}.start();
		}
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
											String key) {
		// TODO Auto-generated method stub
		
	}
}
