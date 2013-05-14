package me.eto.helloworld.async;

import me.eto.helloworld.R;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SimpleMessageHandlerActivity extends FragmentActivity implements OnClickListener{
	private final static int FIRST_KIND = 1;
	private final static int SECOND_KIND = 2;
	
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
		mSimpleHandler = new MyHandler(this);
	}
	
	@Override
	public void onClick(View v) {
		mSimpleHandler.sendEmptyMessage(FIRST_KIND);

		Message message = mSimpleHandler.obtainMessage();
		message.what = SECOND_KIND;
		mSimpleHandler.sendMessageDelayed(message, 4000);
	}

	private void setText(String text){
		mOutput.setText(text);
	}
	
	private static class MyHandler extends Handler{
		private SimpleMessageHandlerActivity mMe;
		
		public MyHandler(SimpleMessageHandlerActivity me) {
			mMe = me;
		}
		@Override
		public void handleMessage(Message msg) {
			if(msg.what== FIRST_KIND){
				mMe.setText("FIRST MESSAGE");
			}else if(msg.what==SECOND_KIND){
				mMe.setText("SECOND MESSAGE");
			}
		}
	}
}
