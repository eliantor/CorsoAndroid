package me.eto.helloworld.storage;

import java.io.File;

import android.app.Activity;
import android.os.Environment;

public class DiskStorage extends Activity{

	private void openInternalStorage(){
		File directory = getFilesDir();
		getCacheDir();
	}
	
	private void openExternalStorage(){

		String storageState = Environment.getExternalStorageState();
		
		if(Environment.MEDIA_MOUNTED.equals(storageState)){
			File externalPrivate = Environment.getExternalStorageDirectory();
			Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			
		}
	}
}
