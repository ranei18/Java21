
import java.io.*;
import nu.xom.*;

public class DomainEditor{
    public static void main(String[] args) throws IOException {
        try {
            Builder builder = new Builder();
            File xmlFile = new File("feed.rss");
            Document doc = builder.build(xmlFile);
            
            //get root element
            Element root = doc.getRootElement();
            //get its channel
            Element channel = root.getFirstChildElement("channel");
            
            //get link elements
            Elements children = channel.getChildElements();
            for(int i = 0; i < children.size(); i++) {
                //get a link element
                Element link = children.get(i);
                //get text
                Text linkText = (Text) link.getChild(0);
                //update any link matching a URL
                if(linkText.getValue().equals("http://workbench.cadenhead.org/")){
                    //update link text
                    link.removeChild(0);
                    link.appendChild("http://www.cadenhead.org/");
                }
            }
            // create new elements and attributes to add
            Element item = new Element("item");
            Element itemTitle = new Element("title");
            
            //add to channel element
            itemTitle.appendChild("Free the bound periodicals");
            item.appendChild(itemTitle);
            channel.appendChild(item);
            
            //save document
            try (FileWriter fw = new FileWriter("feed2.rss");
                   BufferedWriter out = new BufferedWriter(fw); ){
                out.write(doc.toXML());
            } catch (IOException ioe){
                System.out.println(ioe.getMessage());
            }
            System.out.println(doc.toXML());
                   
        } catch (ParsingException pe) {
            System.out.println(pe.getMessage());
            pe.printStackTrace();
            System.exit(-1);
        }
    }
}