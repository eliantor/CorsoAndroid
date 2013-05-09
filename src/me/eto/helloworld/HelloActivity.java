package me.eto.helloworld;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class HelloActivity extends Activity implements OnClickListener{
	private final static String TAG = "HELLO";
	
	private EditText mInputName;
	
	/*
	 * 
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
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
		
		
		/*
		 * This will send an implicit intent
		 */
		findViewById(R.id.btn_implicit_intent).setOnClickListener(this);
	}
	
	private String getText(){
		String string = mInputName.getText().toString();
		Log.i(TAG, "Input is: "+string);
		return string;
	}

	@Override
	public void onClick(View v) {
		final int id = v.getId();
		switch (id) {
		case R.id.btn_implicit_intent:
			startStrangeApp();
//			startGoogle();
			break;
		default:
			break;
		}
	}

	@SuppressWarnings("unused")
	private void startGoogle() {
		Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.google.com"));
		startActivity(intent);
	}
	
	private void startStrangeApp(){
		try {
//			Intent intent = new Intent("unknown_action");
			Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("mysql://in_memorydb"));
			startActivity(intent);
		} catch (ActivityNotFoundException e) {
			Log.d(TAG,"NOT FOUND!");
		}
	}
}
