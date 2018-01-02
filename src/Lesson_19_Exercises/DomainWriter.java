import java.io.*;
import nu.xom.*;

public class DomainWriter {
    public static void main(String[] args) throws IOException {
        try {
            Builder builder = new Builder();
            File xmlFile = new File("feed2.rss");
            Document doc = builder.build(xmlFile);
            
            //create comment with current time and date
            Comment timestamp = new Comment("File created " + new java.util.Date());
            
            //Add comments at the top level in the document
            doc.insertChild(timestamp, 0);
            
            //create file output stream to new file
            FileOutputStream f = new FileOutputStream("feed3.rss");
            
            //using serializer with indentation 2
            //write the file
            Serializer output = new Serializer(f, "ISO-8859-1");
            output.setIndent(2);
            output.write(doc);
            
        } catch (ParsingException pe) {
            System.out.println("Parsing error " + pe.getMessage());
            System.exit(-1);
        }
    }
}