package me.eto.helloworld.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import me.eto.helloworld.more.XmlTutorial;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

public class SimpleIntentService extends IntentService{

	public SimpleIntentService() {
		super(SimpleIntentService.class.getSimpleName());
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		
	}
	@Override
	protected void onHandleIntent(Intent intent) {
		//CONNETTERSI ALLA RETE PER SCARICARE UN FILE
		String downloaded = download(intent);
		// RESTITUIRE LA STRINGA AL CHIAMANTE
		ResultReceiver receiver = intent.getParcelableExtra("REPLY_TO");
		if(receiver!=null){
			Bundle b = new Bundle();
			b.putString("RESULT", downloaded);
			receiver.send(1, b);
		}else{
			sendBroadcast(new Intent("REPLY")
						.putExtra("RESULT", downloaded));
		}
	}
	
	private String download(Intent intent) {
		BufferedReader in = null;
		try {
			URL url = new URL("http://www.google.com");
			in = new BufferedReader(new InputStreamReader( url.openStream()));
//			List<String> parseData = XmlTutorial.parseData(in);
			StringWriter sw = new StringWriter();
			String line;
			while((line = in.readLine())!=null){
				sw.append(line).append('\n');
			}
			return sw.toString();
		} catch (MalformedURLException e) {
			return "WRONG URL "+e.getMessage();
		} catch (IOException e) {
			return "ERROR "+e.getMessage();
		}finally{
			if(in!=null){
				try{
					in.close();
				}catch(IOException e){}
			}
		}
		
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

}
