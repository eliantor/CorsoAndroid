package me.eto.helloworld.fragments;

import java.util.List;

import me.eto.helloworld.R;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class TodoListFragment extends Fragment{

	public static interface TodoDataProvider{
		public List<Todo> getTodos();
	}
	
	private TodoDataProvider mProvider;
	private ListView mListView;
	private TodoAdapter mAdapter;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if(activity instanceof TodoDataProvider){
			mProvider = (TodoDataProvider)activity;
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View v = inflater.inflate(R.layout.todo_list, container,false);
		mListView = (ListView)v;
		// PROBABLY WRONG!!!
//		mAdapter = new TodoAdapter(getActivity(), mProvider.getTodos());
//		mListView.setAdapter(mAdapter);
		return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mAdapter = new TodoAdapter(getActivity(), mProvider.getTodos());
		mListView.setAdapter(mAdapter);
	}
	
	public void refresh(){
		mAdapter.notifyDataSetChanged();
	}
}
