package me.eto.helloworld.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

public class NetworkStateReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		String info = intent.getStringExtra(ConnectivityManager.EXTRA_EXTRA_INFO);
		Toast.makeText(context, info, Toast.LENGTH_LONG).show();
		Log.d("RECEIVER", info);
//		context.startService(service);
	}
}
