package me.eto.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HelloResultActivity extends Activity{
	public static String EXTRA_NAME_ARGUMENT = "name";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.hello_layout);
		
		Intent theIntentThatStartedUs = getIntent();
		String name = theIntentThatStartedUs.getStringExtra(EXTRA_NAME_ARGUMENT);
		
		if(name != null && name.length()>0){
			TextView tv = (TextView)findViewById(R.id.tv_result);
			tv.setText(String.format("Hello, %s!", name));
		}
	}
}
