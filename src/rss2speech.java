import java.io.*;
import java.util.ArrayList;

public class rss2speech {
	public static void main(String[] args) throws IOException{
		
		readRSS("http://feeds.bbci.co.uk/news/world/rss.xml?edition=uk","europe");
		readRSS("http://rss.cnn.com/rss/edition_world.rss","europe");
		readRSS("http://www.rssweather.com/wx/ro/bucuresti/rss.php","bucuresti");
		readRSS("http://www.tomshardware.com/feeds/rss2/news.xml",null);
	}
	
	public static void readRSS (String feed, String filter){
		getRSS r;
		try {
			r = new getRSS(feed);
			ArrayList<String> titles = r.returnTitles();
			for (String s:titles){
				if (filter==null){
					System.out.println(s);
					//new tts(s);
				}
				else if(s.toLowerCase().contains(filter.toLowerCase())){
					System.out.println(s);
					//new tts(s);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
