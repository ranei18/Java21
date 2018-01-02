import java.io.*;
import nu.xom.*;

public class LibraryReader {
    public static void main(String[] args) throws IOException {
        try {
            Builder builder = new Builder();
            File xmlFile = new File("Library.xml");
            Document doc = builder.build(xmlFile);
            
            //get root element
            //Element root = doc.getRootElement();
            //Element library = root.getFirstChildElement("library");
            Element library = doc.getRootElement();
            
            Elements books = library.getChildElements("book");
            //get library elements
            
            for (int i = 0; i < books.size(); i++) {
                //get book
                Element book = books.get(i);
                Element author = book.getFirstChildElement("author");
                Text authorText = (Text) author.getChild(0);
                Element title = book.getFirstChildElement("title");
                Text titleText = (Text) title.getChild(0);
                
                //System.out.println(authorText.getValue());
                if(authorText.getValue().equals("Author 1")){
                    System.out.println("Title: " + titleText.getValue());
                    System.out.println("Author: " + authorText.getValue());
                    System.out.println();
                } else {
                    library.removeChild(book);
                }    
        }

        System.out.println(doc.toXML());
    } catch (ParsingException pe){
        System.out.println(pe.getMessage());
        System.exit(-1);
    }

    }
    
}