
import java.io.*;
import nu.xom.*;

public class RssStarter{
    public static void main(String[] args){
        //rss root element
        Element rss = new Element("rss");
        //version attribute
        Attribute version = new Attribute("version","2.0");
        rss.addAttribute(version);
        
        //create channel element, child of rss
        Element channel = new Element("channel");
        rss.appendChild(channel);
        //creat channel's title
        Element title = new Element("title");
        Text titleText = new Text("Workbench");
        title.appendChild(titleText);
        channel.appendChild(title);
        //create channel's link
        Element link = new Element("link");
        Text lText = new Text("http://workbench.cadenhead.org/");
        link.appendChild(lText);
        channel.appendChild(link);
        
        //create a new document with rss as root element
        Document doc = new Document(rss);
        try (FileWriter fw = new FileWriter("feed.rss");
                BufferedWriter out = new BufferedWriter(fw);){
            out.write(doc.toXML());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());            
        }
        System.out.println(doc.toXML());
    }
}