package me.eto.helloworld.fragments;

import me.eto.helloworld.R;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class EditFragment extends Fragment implements OnClickListener{

	private EditText mInputTodo;
	private Button mAdd;
	
	public static interface OnTodoItemAddedListener{
		public void onTodoItemAdded(String item,long when);
	}
	
	private OnTodoItemAddedListener mListener;
	
	/**
	 * Decido attivamente chi è il listener
	 * @param listener
	 */
	public void setOnTodoItemAddedListener(OnTodoItemAddedListener listener){
		mListener = listener;
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if( activity instanceof OnTodoItemAddedListener){
			mListener = (OnTodoItemAddedListener)activity;
		}else{
			//Se è obbligatorio
			//throw new IllegalStateException();
		}
		
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.edit_todo, container,false);
		mInputTodo = (EditText)view.findViewById(R.id.edt_todo);
		mAdd = (Button)view.findViewById(R.id.btn_add_todo);
		mAdd.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		mListener.onTodoItemAdded(mInputTodo.getText().toString(),System.currentTimeMillis());
	}
}
