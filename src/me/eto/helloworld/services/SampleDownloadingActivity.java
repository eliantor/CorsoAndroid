package me.eto.helloworld.services;

import me.eto.helloworld.R;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SampleDownloadingActivity extends Activity implements OnClickListener{

	private final static IntentFilter FILTER = new IntentFilter("REPLY");
	
	private TextView mOutput;
	private Button mLaunch;
	private Receiver mReceiver;
	
	private class Receiver extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			mOutput.setText(intent.getStringExtra("RESULT"));
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_async_activity);
		mLaunch = (Button)findViewById(R.id.btn_launch);
		mOutput = (TextView)findViewById(android.R.id.text1);
		mLaunch.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		startService(new Intent(this,SimpleIntentService.class));
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		mReceiver = new Receiver();
		registerReceiver(mReceiver, FILTER);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		unregisterReceiver(mReceiver);
		mReceiver = null;
	}
}
