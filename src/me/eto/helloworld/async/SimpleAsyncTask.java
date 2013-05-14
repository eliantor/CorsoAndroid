package me.eto.helloworld.async;

import java.lang.ref.WeakReference;

import android.os.AsyncTask;
import android.widget.TextView;

public class SimpleAsyncTask extends AsyncTask<Void, Void, Integer>{
	// FakeSlowAction.reallySlowCall();
	
	private TextView mView;
	private WeakReference<TextView> mViewRef;
	private volatile boolean mNotifyUser;
	
	public SimpleAsyncTask(TextView view) {
	
//		mView = view;
		mViewRef = new WeakReference<TextView>(view);
		mNotifyUser = true;
	}
	
	//THREAD UI
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
//		mView.setText("Pending...");
		final TextView tv = mViewRef.get();
		if(tv != null){
			tv.setText("Pending...");
		}
		
	}
	
	public void stopNotify(){
		mNotifyUser=false;
	}
	
	//ALTRO THREAD
	@Override
	protected Integer doInBackground(Void... params) {
		return FakeSlowAction.reallySlowCall();
	}
	
	//THREAD UI
	@Override
	protected void onPostExecute(Integer result) {
//		mView.setText(result.toString());
		final TextView tv = mViewRef.get();
		if(tv != null && mNotifyUser){
			tv.setText(result.toString());
		}
	}
}
