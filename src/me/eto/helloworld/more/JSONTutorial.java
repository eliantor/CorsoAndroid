package me.eto.helloworld.more;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.util.JsonReader;
import android.util.JsonToken;

@SuppressLint("NewApi")
public class JSONTutorial {

	/*
	 * {
	 * 	"channel": [
	 * 		{"title" : "Fuck XML JSON IS THE BEST",
	 * 		 "date": 10231}
	 * 	]
	 * }
	 */
	public static List<String> parse(Reader reader) throws IOException{
		JsonReader jpp = new JsonReader(reader);
		while(jpp.hasNext()){
			JsonToken type = jpp.peek();
			switch (type) {
			case NAME:
				if(jpp.nextName().equals("title")){
					String value = jpp.nextString();
					
				}
				break;

			default:
				break;
			}
		}
		return null;
	}
	
	public static void parseAll(String json) throws JSONException{
		JSONObject obj = new JSONObject(json);
		
	}
}

