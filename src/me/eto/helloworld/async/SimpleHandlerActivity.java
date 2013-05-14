package me.eto.helloworld.async;

import me.eto.helloworld.R;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SimpleHandlerActivity extends FragmentActivity implements OnClickListener{

	private Button mButton;
	private TextView mOutput;
	private Handler mSimpleHandler;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.simple_async_activity);
		mButton = (Button)findViewById(R.id.btn_launch);
		mOutput = (TextView)findViewById(android.R.id.text1);
		mButton.setOnClickListener(this);
	
		mSimpleHandler = new Handler();
	}
	
	@Override
	public void onClick(View v) {
		simpleEnqueueOfAction();
		
		
	}

	private void simpleExecuteTheNextTime(){
		mSimpleHandler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}, 3000);
	}
	private void simpleEnqueueOfAction() {
		mSimpleHandler.post(new Runnable() {
			@Override
			public void run() {
				
			}
		});
	}
	
	private static class AsyncTaskDeNoArtri{
		
		private Handler mHandler = new Handler();
		
		private int doInBackground(long p){
			return 0;
		}
		
		private void onPostExecute(int result){
			
		}
		
		private void internresultalExecution(final long e){
			
			new Thread(){
				
				@Override
				public void run() {
					final int v = doInBackground(e);
					mHandler.post(new Runnable() {
						@Override
						public void run() {
							onPostExecute(v);
						}
					});
				}
			};
		}
	}
}
