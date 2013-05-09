package me.eto.helloworld.fragments;

import java.util.List;

import me.eto.helloworld.R;
import me.eto.helloworld.fragments.EditFragment.OnTodoItemAddedListener;
import me.eto.helloworld.fragments.TodoListFragment.TodoDataProvider;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

public class TodoListActivity extends FragmentActivity 
	implements OnTodoItemAddedListener,
			   TodoDataProvider{
	private final static String MEMORY_TAG = "MEMORY";
	private List<Todo> mTodoList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.todo_activity);
//		mTodoList = new ArrayList<Todo>();
//		final FragmentManager fm = getSupportFragmentManager();
//		EditFragment editFragment = (EditFragment)fm.findFragmentById(R.id.EditFragment);
//		editFragment.setOnTodoItemAddedListener(null);
		FragmentManager fm = getSupportFragmentManager();
		if(savedInstanceState == null){
			fm.beginTransaction()
			  .add(new MemoryFragment(), MEMORY_TAG)
//			  .add(viewgroup, fragment, tag)
			  .commit();
			fm.executePendingTransactions();
		}
	}

	@Override
	public void onTodoItemAdded(String item, long when) {
		Log.d("FRAGS", item);
		getTodos().add(new Todo(item, when));
		refreshListFragment();
	}

	private void refreshListFragment() {
		FragmentManager fm = getSupportFragmentManager();
		TodoListFragment todoList = (TodoListFragment)fm.findFragmentById(R.id.TodoList);
		todoList.refresh();
	}

	@Override
	public List<Todo> getTodos() {
		FragmentManager fm = getSupportFragmentManager();
		MemoryFragment memory =(MemoryFragment) fm.findFragmentByTag(MEMORY_TAG);
		return memory.getTodos();
	}
}
