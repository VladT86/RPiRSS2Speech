import java.io.*;
import java.util.ArrayList;

public class rss2speech {
	public static void main(String[] args) throws IOException{
		
		getRSS BBC = new getRSS("http://feeds.bbci.co.uk/news/world/rss.xml?edition=uk");
		
		ArrayList<String> title = BBC.returnTitles();
		ArrayList<String> description = BBC.returnDescription();
		
		
		for (int i = 0; i<title.size(); i++){
			System.out.println(title.get(i));
			new tts(title.get(i));
			System.out.println(description.get(i));
			new tts(description.get(i));
			
		}
		
		
	}
}
