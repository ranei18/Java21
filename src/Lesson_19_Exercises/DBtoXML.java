import java.sql.*;
import java.io.*;
import nu.xom.*;

public class DBtoXML {
    public static void main(String[] args){
        String data="jdbc:derby://localhost:1527/sample";
        try(Connection conn = DriverManager.getConnection(data,"app","app");
                Statement st = conn.createStatement()){
            ResultSet results = st.executeQuery(
                    "select Customer_ID, Name, City " +
                    "from APP.Customer"
            );
            
            //build base of xml document
            Element xml = new Element("database");
            
            while(results.next()) {
                Element customer = new Element("customer");
                Attribute customerId = new Attribute("Id",results.getString(1));
                customer.addAttribute(customerId);
                Element name = new Element("name");
                Text nameText = new Text(results.getString(2));
                name.appendChild(nameText);
                customer.appendChild(name);
                
                xml.appendChild(customer);
            }
            st.close();
            Document doc = new Document(xml);
            try(FileWriter fw = new FileWriter("DBtoXML.xml");
                    BufferedWriter out = new BufferedWriter(fw);) {
                
                out.write(doc.toXML());
            } catch(IOException ioe) {
                System.out.println("IO Error: " + ioe.getMessage());
            }
            
            Serializer output = new Serializer(System.out);
            output.setIndent(2);
            output.write(doc);
            
        } catch(SQLException s) {
            System.out.println("SQL Error: " + s.getMessage());
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());

    }

    }
}