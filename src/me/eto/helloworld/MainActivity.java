package me.eto.helloworld;

import me.eto.helloworld.async.AsyncActivity;
import me.eto.helloworld.async.SimpleMessageHandlerActivity;
import me.eto.helloworld.fragments.TodoListActivity;
import me.eto.helloworld.fragments.dynamicui.FragmentSwitcher;
import me.eto.helloworld.list.NamesListsActivity;
import me.eto.helloworld.services.SampleDownloadingActivity2;
import me.eto.helloworld.services.ServiceClientActivity;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		findViewById(R.id.btn_first_sample).setOnClickListener(this);
		findViewById(R.id.btn_activity_results).setOnClickListener(this);
		findViewById(R.id.btn_second_sample).setOnClickListener(this);
		findViewById(R.id.btn_fragments1).setOnClickListener(this);
		findViewById(R.id.btn_fragments2).setOnClickListener(this);

		findViewById(R.id.btn_async).setOnClickListener(this);
		findViewById(R.id.btn_handlers).setOnClickListener(this);
		findViewById(R.id.btn_services).setOnClickListener(this);
		findViewById(R.id.btn_downloading).setOnClickListener(this);
		Application application = getApplication();
		App app = (App)application;
		Toast.makeText(this, "YEEEE", Toast.LENGTH_SHORT).show();
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
		case R.id.btn_fragments2:
			clazz = FragmentSwitcher.class;
			break;
		case R.id.btn_async:
			clazz = AsyncActivity.class;
			break;
		case R.id.btn_handlers:
			clazz = SimpleMessageHandlerActivity.class;
			break;
		case R.id.btn_services:
			clazz = ServiceClientActivity.class;
			break;
		case R.id.btn_downloading:
			clazz = SampleDownloadingActivity2.class;
			break;
		default:
			clazz = null;
		}
		if(clazz !=null){
			startActivity(new Intent(this,clazz));
		}
	}
}
