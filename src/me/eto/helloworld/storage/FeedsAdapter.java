package me.eto.helloworld.storage;



import me.eto.helloworld.R;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FeedsAdapter extends CursorAdapter{

	private final LayoutInflater mInflater;
	
	public FeedsAdapter(Context context) {
		super(context, null,CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public void bindView(View row, Context context, Cursor cursor) {
		ViewHolder h = (ViewHolder)row.getTag();
		int idIndex = cursor.getColumnIndexOrThrow("_id");
		int titleIndex = cursor.getColumnIndex(FeedContract.Feeds.Columns.TITLE);
		h.tvId.setText(Long.toString(cursor.getLong(idIndex)));
		h.tvTitle.setText(cursor.getString(titleIndex));
	}

	
	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		View v = mInflater.inflate(R.layout.feeds_row, parent ,false);
		ViewHolder h = new ViewHolder();
		h.tvId=(TextView)v.findViewById(R.id.tv_feed_id);
		h.tvTitle=(TextView)v.findViewById(R.id.tv_feed_title);
		v.setTag(h);
		return v;
	}

	private static class ViewHolder{
		TextView tvTitle;
		TextView tvId;
	}
	
	
	private void handlingACursorManually(Cursor c){
		boolean isThereAnotherRecord = c.moveToNext();
		c.moveToFirst();
		
		int idIndex = c.getColumnIndexOrThrow("_id");
		int titleIndex = c.getColumnIndex(FeedContract.Feeds.Columns.TITLE);
		String title = c.getString(titleIndex);
		long id = c.getLong(idIndex);
		
	}
}
