package me.eto.helloworld.list;

import java.util.Random;

import me.eto.helloworld.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class NamesListsActivity extends Activity implements OnItemClickListener,OnClickListener{
	
	private Random mRand;
	private ListView mListView;
	private NamesAdapter mNamesAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mRand = new Random();
		setContentView(R.layout.names_activity);
		mListView = (ListView)findViewById(R.id.lv_names);

		mNamesAdapter = new NamesAdapter(this, Data.getDataList());
		mListView.setAdapter(mNamesAdapter);
		mListView.setOnItemClickListener(this);
		findViewById(R.id.btn_add_element).setOnClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
		Toast.makeText(this, mNamesAdapter.getItem(position), Toast.LENGTH_LONG).show();
	}

	@Override
	public void onClick(View v) {
		mNamesAdapter.addElement("Ciao "+ mRand.nextInt());
		mNamesAdapter.notifyDataSetChanged();
	}
	
	
}
