package me.eto.helloworld.list;

import java.util.List;

import me.eto.helloworld.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

class NamesAdapter extends BaseAdapter{

	private final List<String> fNames;
	private final LayoutInflater fInflater;
	
	public NamesAdapter(Context context,List<String> names) {
		fNames = names;
		fInflater = LayoutInflater.from(context);
	}
	
	public void addElement(String name){
		fNames.add(name);
	}
	
	@Override
	public int getCount() {
		if(fNames == null) return 0;
		return fNames.size();
	}

	@Override
	public String getItem(int position) {
		return fNames.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
//	@Override
//	public int getViewTypeCount() {
//		// TODO Auto-generated method stub
//		return super.getViewTypeCount();
//	}
//	
//	@Override
//	public int getItemViewType(int position) {
//		// TODO Auto-generated method stub
//		return super.getItemViewType(position);
//	}

	@Override
	public View getView(int position, View recycledRow, ViewGroup parent) {
		final View v;
		final ViewHolder h;
		if(recycledRow==null){
			v = fInflater.inflate(R.layout.name_row_layout, parent,false);
			h = new ViewHolder();
			h.nameView = (TextView)v.findViewById(R.id.tv_row_name);
			v.setTag(h);
		}else{
			v = recycledRow;
			h = (ViewHolder)v.getTag();
		}
		
		h.nameView.setText(getItem(position));
		return v;
	}

	private static class ViewHolder{
		public TextView nameView;
	}
	
}
