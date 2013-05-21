package me.eto.helloworld.storage;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import android.annotation.TargetApi;
import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.BaseColumns;

public class FeedProvider extends ContentProvider{
	private FeedOpenHelper mDB;
	
	@Override
	public boolean onCreate() {
		mDB = new FeedOpenHelper(getContext());//Connessione al db
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteQueryBuilder q = new SQLiteQueryBuilder();
		final int match = MATCHER.match(uri);
		switch (match) {
		case ALL_FEEDS:
			q.setTables(FeedContract.Feeds.TABLE);
			/*
			 * SELECT * FROM FEEDS
			 */
			break;
		case ONE_FEED:
			q.setTables(FeedContract.Feeds.TABLE);
			q.appendWhere(BaseColumns._ID+ " = "+ContentUris.parseId(uri));
			/*
			 * SELECT * FROM FEEDS WHERE _id = 46
			 */
			break;
		default:
			throw new UnsupportedOperationException("Uri: "+uri + " is not supported");
		}
		SQLiteDatabase db = mDB.getReadableDatabase();
		
		Cursor cursor = q.query(db, projection, selection, selectionArgs, null, null, sortOrder);
		cursor.setNotificationUri(getContext().getContentResolver(), uri);
		return cursor;
	}

	private void versionDependentCode(){
		if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.HONEYCOMB){
			
		}else{
			
		}
	}

	@Override
	public String getType(Uri uri) {
		switch (MATCHER.match(uri)) {
		case ALL_FEEDS:return FeedContract.Feeds.MIME_DIR;
		case ONE_FEED: return FeedContract.Feeds.MIME_ITEM;
		default: return null;
		}
	}

	@Override
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public String[] getStreamTypes(Uri uri, String mimeTypeFilter) {
		// TODO Auto-generated method stub
		return super.getStreamTypes(uri, mimeTypeFilter);
	}
	
	@Override
	public int bulkInsert(Uri uri, ContentValues[] values) {
		final int match = MATCHER.match(uri);
		final String table;
		switch (match) {
		case ALL_FEEDS:
			table = FeedContract.Feeds.TABLE;
			break;
		default:
			throw new UnsupportedOperationException();
		}
		int count = 0;
		SQLiteDatabase db = mDB.getWritableDatabase();
		db.beginTransaction();
		try{
			for(ContentValues v:values){
				long success = db.insert(table, null, v);
				if(success!=-1)count++;
				db.yieldIfContendedSafely();
			}
			
			db.setTransactionSuccessful();
		}finally{
			db.endTransaction();
		}
		return count;
	}
	
	@Override
	public ContentProviderResult[] applyBatch(
			ArrayList<ContentProviderOperation> operations)
			throws OperationApplicationException {
		// TODO Auto-generated method stub
		return super.applyBatch(operations);
	}
	
	@Override
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public Bundle call(String method, String arg, Bundle extras) {
		// TODO Auto-generated method stub
		return super.call(method, arg, extras);
	}
	
	@Override
	public ParcelFileDescriptor openFile(Uri uri, String mode)
			throws FileNotFoundException {
		// TODO Auto-generated method stub
		return super.openFile(uri, mode);
	}
	
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		final int match = MATCHER.match(uri);
		final String table;
		switch (match) {
		case ALL_FEEDS:
			table = FeedContract.Feeds.TABLE;
			break;
		default:
			throw new UnsupportedOperationException("dsadasfas");
		}
		SQLiteDatabase db = mDB.getWritableDatabase();
		long id = db.insert(table, null, values);
		if(id!=-1){
			Uri ret = ContentUris.withAppendedId(uri, id);
			getContext().getContentResolver().notifyChange(uri, null);
			return ret;
		}
		return null;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private static final UriMatcher MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
	private static final int ALL_FEEDS=1;
	private static final int ONE_FEED =2;
	
	static{
		MATCHER.addURI(FeedContract.AUTHORITY, FeedContract.Feeds.TABLE, ALL_FEEDS);
		MATCHER.addURI(FeedContract.AUTHORITY, FeedContract.Feeds.TABLE+"/#", ONE_FEED);
	}

}
