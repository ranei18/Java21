import java.io.*;
import nu.xom.*;

public class DBtoXMLReader {
    public static void main(String[] args) {
        try {
            Builder builder = new Builder();
            File xmlFile = new File("DBtoXML.xml");
            Document doc = builder.build(xmlFile);
            Element database = doc.getRootElement();
            
            Elements customers = database.getChildElements("customer");
            
            for (int i = 0; i < customers.size(); i++) {
                Element customer = customers.get(i);
                String id = customer.getAttributeValue("Id");                
                Element name = customer.getFirstChildElement("name");
                Text nameText = (Text) name.getChild(0);
                System.out.println("Customer: " + nameText.getValue());
                System.out.println("ID: " + id);
                System.out.println();
                
            }
  
            
        } catch (ParsingException pe) {
            System.out.println("PE Error: " + pe.getMessage());
            System.exit(-1);
        } catch (IOException ioe) {
            System.out.println("IO Error: "  + ioe.getMessage());
        }
    }
}