package me.eto.helloworld.storage;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class FeedContract {
	final static String AUTHORITY = "me.eto.helloworld.provider";
	
	public final static Uri CONTENT_URI = Uri.parse("content://"+AUTHORITY);
	
	public final static class Feeds{
		public final static String TABLE = "feeds";
		//content://+AUTHORITY/+TABLE
		public final static Uri URI = CONTENT_URI.buildUpon().appendPath(TABLE).build();
		// MIME TYPE VALIDI PER DATI TABULARI
		public final static String MIME_DIR = ContentResolver.CURSOR_DIR_BASE_TYPE+"/vnd.me.eto.helloworld.feeds";
		public final static String MIME_ITEM = ContentResolver.CURSOR_ITEM_BASE_TYPE+"/vnd.me.eto.helloworld.feeds";
		public final static class Columns{
			public final static String ID = BaseColumns._ID; // "_id"
			public final static String TITLE = "title";
			public final static String DESCRIPTION = "description";
			public final static String URL = "url";
			public final static String DATE = "pubdate";
		}
	}
}
