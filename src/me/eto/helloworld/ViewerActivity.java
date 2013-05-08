package me.eto.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ViewerActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new View(this));
		Log.d("OPEN", "OPEN");
	}
}
