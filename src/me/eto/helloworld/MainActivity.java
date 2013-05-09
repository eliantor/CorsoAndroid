package me.eto.helloworld;

import me.eto.helloworld.fragments.TodoListActivity;
import me.eto.helloworld.list.NamesListsActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		findViewById(R.id.btn_first_sample).setOnClickListener(this);
		findViewById(R.id.btn_activity_results).setOnClickListener(this);
		findViewById(R.id.btn_second_sample).setOnClickListener(this);
		findViewById(R.id.btn_fragments1).setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		Class<? extends Activity> clazz;
		switch (v.getId()) {
		case R.id.btn_first_sample:
			clazz = HelloActivity.class;
			break;
		case R.id.btn_activity_results:
			clazz= ShowNameActivity.class;
			break;
		case R.id.btn_second_sample:
			clazz = NamesListsActivity.class;
			break;
		case R.id.btn_fragments1:
			clazz = TodoListActivity.class;
			break;
		default:
			clazz = null;
		}
		if(clazz !=null){
			startActivity(new Intent(this,clazz));
		}
	}
}
