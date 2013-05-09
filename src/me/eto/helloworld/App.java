package me.eto.helloworld;

import android.app.Application;

public class App extends Application{
	private static App self;
	@Override
	public void onCreate() {
		super.onCreate();
		self = this;
	}
	
	static App get(){
		
		return self;
	}
}

