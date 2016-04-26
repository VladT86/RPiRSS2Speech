import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.ElementFilter;
import org.jdom2.input.SAXBuilder;

public class getRSS {
	
	private String sURL;
	private String xml;
	private ArrayList<String> Titles = new ArrayList<String>();
	private ArrayList<String> Descriptions = new ArrayList<String>();
	
	public getRSS(String s) throws IOException{
		sURL = s;
		 try {
			URL url = new URL(sURL);
			InputStream is = url.openStream();
			int ptr = 0;
		    StringBuilder builder = new StringBuilder();
		    while ((ptr = is.read()) != -1) {
		           builder.append((char) ptr);
		    }
		    xml = builder.toString();
		    this.readXML();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readXML(){
		SAXBuilder sB = new SAXBuilder();
		try{
			Document doc = sB.build(new StringReader(xml));
	        Element root = doc.getRootElement();
            ElementFilter filter = new ElementFilter("item");
            for(Element item:root.getDescendants(filter))
            {
            	
            	Element title = item.getChild("title");
            	Element description = item.getChild("description");
            	Titles.add(title.getValue());
            	Descriptions.add(description.getValue());
            	//System.out.println(title.getValue());
            	//System.out.println(description.getValue());
            }
		} catch (JDOMException e){
			//
		} catch (IOException e){
			//
		}
	}
	
	public String returnRawRSS(){
		return xml;
	}
	
	public ArrayList<String> returnTitles(){
		return Titles;
	}
	
	public ArrayList<String> returnDescription(){
		return Descriptions;
	}

}
