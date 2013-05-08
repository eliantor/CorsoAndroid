package me.eto.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HelloActivity extends Activity{
	private final static String TAG = "HELLO";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_layout);
		Button submit = (Button)findViewById(R.id.btn_submit);
		submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.wtf(TAG, "Clicked!");
				final Intent intent = new Intent(HelloActivity.this, 
												 HelloResultActivity.class);
				startActivity(intent);
			}
		});
	}
	
	
}
