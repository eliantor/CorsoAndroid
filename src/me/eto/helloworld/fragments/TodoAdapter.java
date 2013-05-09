package me.eto.helloworld.fragments;

import java.sql.Date;
import java.util.List;

import me.eto.helloworld.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TodoAdapter extends BaseAdapter{

	private final LayoutInflater fInflater;
	private final List<Todo> fTodos;
	
	public TodoAdapter(Context context,List<Todo> todos) {
		fInflater = LayoutInflater.from(context);
		fTodos = todos;
	}
	
	@Override
	public int getCount() {
		if(fTodos==null){
			Log.d("THINKING!!!", "NULL");
			return 0;
		}
		return fTodos.size();
	}

	@Override
	public Todo getItem(int position) {
		return fTodos.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder h;
		if(convertView==null){
			convertView = fInflater.inflate(R.layout.todo_row, parent,false);
			h = new ViewHolder();
			h.textView = (TextView)convertView.findViewById(R.id.tv_todo_text);
			h.timeView = (TextView)convertView.findViewById(R.id.tv_todo_date);
			convertView.setTag(h);
		}else{
			h = (ViewHolder)convertView.getTag();
		}
		
		final Todo todo = getItem(position);
		h.textView.setText(todo.fText);
		h.timeView.setText(new Date(todo.fTime).toString());
		
		return convertView;
	}
	
	private static class ViewHolder{
		TextView textView;
		TextView timeView;
	}

	
}
