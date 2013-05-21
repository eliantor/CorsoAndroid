package me.eto.helloworld.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class FeedOpenHelper extends SQLiteOpenHelper{
	private final static String DB_NAME="pippo.db";
	private final static int DB_VERSION=1;
	
	
	private final static String CREATE_FEEDS = "CREATE TABLE IF NOT EXISTS "+ FeedContract.Feeds.TABLE +
			"("+FeedContract.Feeds.Columns.ID + " INTEGER PRIMARY KEY AUTOICREMENT , "+
			    FeedContract.Feeds.Columns.TITLE+ " TEXT NOT NULL, "+
			    FeedContract.Feeds.Columns.DESCRIPTION+ " TEXT, "+
			    FeedContract.Feeds.Columns.URL+ " TEXT NOT NULL, "+
			    FeedContract.Feeds.Columns.DATE+ " INTEGER)";
			
	private final static String DROP_FEEDS = "DROP TABLE IF EXISTS "+FeedContract.Feeds.TABLE;
	
	public FeedOpenHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_FEEDS);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if(newVersion>oldVersion){
			db.execSQL(DROP_FEEDS);
			onCreate(db);
		}
	}

}
