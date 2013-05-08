package me.eto.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class HelloResultActivity extends Activity implements OnClickListener{
	public final static String EXTRA_NAME_ARGUMENT = "name";
	
	private final static String SAVED_LIKES = "saved_likes";
	
	private TextView mLikesView;
	private int mCounter;
	
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
		
		initLikesWithState(savedInstanceState);
	}
	
	private void initLikesWithState(Bundle savedInstanceState){
		findViewById(R.id.btn_add_like).setOnClickListener(this);
		mLikesView = (TextView)findViewById(R.id.tv_likes);
		
		// Controllo se sono stato riavviato
		if(savedInstanceState!=null){
			mCounter = savedInstanceState.getInt(SAVED_LIKES);
			mLikesView.setText(
					String.format("%d", mCounter));
			
		}else{
			Log.d("TAG", "Once in a lifetime!!!");
		}
	}
	

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(SAVED_LIKES, mCounter);
	}
	
	@Override
	public void onClick(View v) {
		mLikesView.setText(String.format("%d", ++mCounter));
	}
}
