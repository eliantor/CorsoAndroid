package me.eto.helloworld.services;

import me.eto.helloworld.R;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;

public class ServiceBoundActivity extends FragmentActivity implements OnClickListener{

	private MyService mService;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_async_activity);
		findViewById(R.id.btn_launch).setOnClickListener(this);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		bindService(new Intent(this,MyService.class), fConnection, BIND_AUTO_CREATE);
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		if(mService != null)unbindService(fConnection);
	}


	@Override
	public void onClick(View v) {
		if(mService!=null){
			mService.logSomething("CIAO");
		}
	}
	
	private final ServiceConnection fConnection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			mService = null;
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			mService=((MyService.LocalBinder)service).getService();
		}
	};


}
