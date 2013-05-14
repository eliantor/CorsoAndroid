package me.eto.helloworld.more;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;
/*
 * <rss>
 * <channel>
 * <item>
 * 	<title>XmlPull the fastest way!!!</title>
 * </item>
 * </channel>
 * </rss>
 */
public class XmlTutorial {

	public static List<String> parseData(Reader reader) throws XmlPullParserException, IOException{
		List<String> results = new ArrayList<String>();
		XmlPullParser xpp = Xml.newPullParser();
		xpp.setInput(reader);
		int event = xpp.next();
		while(event != XmlPullParser.END_DOCUMENT){
			switch(event){
			case XmlPullParser.START_TAG:
				if(xpp.getName().equals("title")){
					String value = xpp.nextText();
					results.add(value);
				}
			}
			event = xpp.next();
		}
		
		return results;
	}
}
