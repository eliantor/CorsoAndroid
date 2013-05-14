package me.eto.helloworld.async;

import me.eto.helloworld.R;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AsyncActivity extends FragmentActivity implements OnClickListener{

	private Button mButton;
	private TextView mOutput;
	private SimpleAsyncTask mTask;
	
	private SimpleProgressAsyncTask mProgressAsyncTask;
	
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
//		callActionWithAsyncTask();
		callActionWithProgressAsyncTask();
	}

	/**
	 * OK
	 */
	public void callActionWithAsyncTask(){
		if(mTask == null){
			mTask = new SimpleAsyncTask(mOutput);
			mTask.execute();
		}
	}
	
	
	public void callActionWithProgressAsyncTask(){
		if(mProgressAsyncTask == null){
			mProgressAsyncTask = new SimpleProgressAsyncTask(mOutput);
			mProgressAsyncTask.execute();
		}
	}
	@Override
	protected void onPause() {
		super.onPause();
		if(mTask != null){
			mTask.cancel(true);
			mTask.stopNotify();
			mTask = null;
		}
	}
	
	/**
	 * NOOOO
	 */
	private void callActionDirectly() {
		FakeSlowAction.reallySlowCall();
	}
}
