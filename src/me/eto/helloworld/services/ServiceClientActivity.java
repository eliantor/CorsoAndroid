package me.eto.helloworld.services;

import me.eto.helloworld.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ServiceClientActivity extends FragmentActivity implements OnClickListener{

	private Button mButton;
	private TextView mOutput;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_async_activity);
		mButton = (Button)findViewById(R.id.btn_launch);
		mOutput = (TextView)findViewById(android.R.id.text1);
		mButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		startService(new Intent(this, MyService.class)
					 .putExtra(MyService.ARGUMENTS, "DA DA DA"));
	}
	
	
}
