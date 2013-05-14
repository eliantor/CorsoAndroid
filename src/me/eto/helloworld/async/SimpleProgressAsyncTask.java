package me.eto.helloworld.async;

import java.lang.ref.WeakReference;

import android.os.AsyncTask;
import android.widget.TextView;

public class SimpleProgressAsyncTask extends AsyncTask<Void, Float, Integer>{
	
	private TextView mView;
	private WeakReference<TextView> mViewRef;
	private volatile boolean mNotifyUser;
	
	public SimpleProgressAsyncTask(TextView view) {
	
		mViewRef = new WeakReference<TextView>(view);
		mNotifyUser = true;
	}
	
	//THREAD UI
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
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
		FakeSlowAction.reallySlowCall();
		publishProgress(0.25f);
		FakeSlowAction.reallySlowCall();
		publishProgress(0.5f);
		FakeSlowAction.reallySlowCall();
		publishProgress(0.75f);
		return FakeSlowAction.reallySlowCall();
	}
	
	
	// THREAD UI
	@Override
	protected void onProgressUpdate(Float... values) {
		super.onProgressUpdate(values);
		final TextView tv = mViewRef.get();
		if(tv != null && mNotifyUser){
			tv.setText("Progress... "+values[0]);
		}
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
