package me.eto.helloworld.services;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;

public class SimpleResultReceiver extends ResultReceiver{

	public static interface Callback{
		public void onResult(int code,Bundle data);
	}
	
	private Callback mCallback;
	private int mLastInt;
	private Bundle mLastBundle;
	private volatile boolean mHasSticky;
	
	public SimpleResultReceiver() {
		super(new Handler(Looper.getMainLooper()));
	}
	

	public void setCallback(Callback callback){
		mCallback = callback;
		final boolean doCall;
		if(mHasSticky){
			synchronized(this){
				if(mHasSticky){
					mHasSticky=false;
					doCall=true;
				}else{
					doCall=false;
				}
			}
		}else{
			doCall=false;
		}
		if(mCallback!=null && doCall){
			mCallback.onResult(mLastInt, mLastBundle);
			mLastBundle=null;
			mLastInt=0;
		}
	}
	
	
	@Override
	protected void onReceiveResult(int resultCode, Bundle resultData) {
		if(mCallback!=null){
			mCallback.onResult(resultCode, resultData);
		}else{
			mHasSticky = true;
			mLastInt=resultCode;
			mLastBundle=resultData;
		}
	}
}
