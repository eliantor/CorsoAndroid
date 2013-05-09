package me.eto.helloworld.fragments.dynamicui;

import me.eto.helloworld.R;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SimpleFragment2 extends Fragment{
	private static final String COLOR = "COLOR";

	public void setColor(int color){
		Bundle b = new Bundle();
		b.putInt(COLOR, color);
		setArguments(b);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.simple_layout, container,false);
		Bundle args = getArguments();
		if(args !=null){
			view.setBackgroundColor(args.getInt(COLOR, Color.BLUE));
		}else{
			view.setBackgroundColor(Color.BLUE);
		}
		return view;
	}
}
