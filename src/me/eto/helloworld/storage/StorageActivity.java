package me.eto.helloworld.storage;

import me.eto.helloworld.storage.FeedContract.Feeds;
import android.content.AsyncQueryHandler;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.widget.ListView;

public class StorageActivity extends FragmentActivity implements
	LoaderCallbacks<Cursor>{
	private final static int FEEDS_LOADER_ID = 1;
	
	
	private final static String[] PROJECTION ={
		FeedContract.Feeds.Columns.ID,
		FeedContract.Feeds.Columns.TITLE
	};
	
	private ListView mListView;
	private FeedsAdapter mAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// GET THE LIST
		mAdapter = new FeedsAdapter(this);
		mListView.setAdapter(mAdapter);
		
		getSupportLoaderManager().initLoader(FEEDS_LOADER_ID, null, this);
	}
	
	
	private void insert(){
		ContentResolver cr = getContentResolver();
		ContentValues cv = new ContentValues();
		cv.put(Feeds.Columns.TITLE, "WHAT A NEWS!!!");
		cv.put(Feeds.Columns.URL,"dsafas.dsafas.ff");
		Uri insert = cr.insert(FeedContract.Feeds.URI, cv);
	}
	
	private void multipleAccess(){
		ContentProviderClient client = getContentResolver()
					.acquireContentProviderClient("");
		client.release();
	}
	
	private void asyncInsert(){
		new AsyncQueryHandler(getContentResolver()) {
			protected void onInsertComplete(int token, Object cookie, Uri uri) {
				
			};
		}.startInsert(10, null, FeedContract.Feeds.URI, null/*content values*/);
	}


	@Override
	public Loader<Cursor> onCreateLoader(int loaderId, Bundle args) {
		if(loaderId== FEEDS_LOADER_ID){
			final CursorLoader feedsLoader = 
		new CursorLoader(this, FeedContract.Feeds.URI,PROJECTION, null, null, null);
			
			return feedsLoader;
		}
		return null;
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
		if(loader.getId()==FEEDS_LOADER_ID){
			mAdapter.swapCursor(cursor);
		}
	}


	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
		if(loader.getId()==FEEDS_LOADER_ID){
			mAdapter.swapCursor(null);
		}
	}
}
