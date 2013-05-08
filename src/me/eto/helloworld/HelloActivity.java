package me.eto.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class HelloActivity extends Activity{
	private final static String TAG = "HELLO";
	
	private EditText mInputName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_layout);
		Button submit = (Button)findViewById(R.id.btn_submit);
		mInputName = (EditText)findViewById(R.id.edt_name);
		
		submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.wtf(TAG, "Clicked!");
				String name = getText();
				final Intent intent = new Intent(HelloActivity.this, 
												 HelloResultActivity.class);
				intent.putExtra(HelloResultActivity.EXTRA_NAME_ARGUMENT, name);
				startActivity(intent);
			}
		});
	}
	
	private String getText(){
		String string = mInputName.getText().toString();
		Log.i(TAG, "Input is: "+string);
		return string;
	}
}
