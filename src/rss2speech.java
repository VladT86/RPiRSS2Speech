import java.io.*;
import java.util.ArrayList;

public class rss2speech {
	public static void main(String[] args) throws IOException{
		
		getRSS BBC = new getRSS("http://feeds.bbci.co.uk/news/world/rss.xml?edition=uk");
		
		ArrayList<String> title = BBC.returnTitles();
		ArrayList<String> description = BBC.returnDescription();
		
		
		for (int i = 0; i<title.size(); i++){
			//System.out.println(title.get(i));
			//new tts(title.get(i));
			//System.out.println(description.get(i));
			//new tts(description.get(i));
			
		}
		
		getRSS CNN = new getRSS("http://rss.cnn.com/rss/edition_world.rss");
		
		ArrayList<String> CNNtitle = CNN.returnTitles();
		
		for (String s:CNNtitle){
			//System.out.println(s);
		}
		
		getRSS weather = new getRSS("http://www.rssweather.com/wx/ro/bucuresti/rss.php");
		
		ArrayList<String> weatherNow = weather.returnTitles();
		//System.out.println(weather.returnRawRSS());
		for (String s:weatherNow){
			if (s.toLowerCase().contains("bucuresti")!=false)  System.out.println(s);
		}
	}
}
