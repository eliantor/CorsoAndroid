package me.eto.helloworld.fragments;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class MemoryFragment extends Fragment{

	private List<Todo> mTodos;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true); // IL Fragment non verrà mai distrutto
		mTodos = new ArrayList<Todo>();
	}
	
	public List<Todo> getTodos(){
		return mTodos;
	}
}
