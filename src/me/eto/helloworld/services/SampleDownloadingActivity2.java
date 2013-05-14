package me.eto.helloworld.services;

import me.eto.helloworld.R;
import me.eto.helloworld.services.SimpleResultReceiver.Callback;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SampleDownloadingActivity2 extends Activity implements OnClickListener,Callback{

	private final static IntentFilter FILTER = new IntentFilter("REPLY");
	
	private TextView mOutput;
	private Button mLaunch;
	private SimpleResultReceiver mReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_async_activity);
		mLaunch = (Button)findViewById(R.id.btn_launch);
		mOutput = (TextView)findViewById(android.R.id.text1);
		mLaunch.setOnClickListener(this);
		mReceiver = new SimpleResultReceiver();
	}
		
	@Override
	public void onClick(View v) {
		Intent serv = new Intent(this,SimpleIntentService.class);
		serv.putExtra("REPLY_TO", mReceiver);
		startService(serv);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		mReceiver.setCallback(this);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		mReceiver.setCallback(null);
	}
	

	@Override
	public void onResult(int code, Bundle data) {
		mOutput.setText(data.getString("RESULT"));
	}
	
}
