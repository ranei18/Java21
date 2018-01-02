import java.sql.*;

public class CustomerReporter2 {
    public static void main(String[] args) {
        String data = "jdbc:derby://localhost:1527/sample/";
        try (Connection conn = DriverManager.getConnection(data,"app","app");
                Statement st = conn.createStatement()) {
        
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            ResultSet rec = st.executeQuery(
                    "select Product_ID, Description, Purchase_Cost, Quantity_on_Hand, Markup " +
                    "from APP.Product");
            
            while(rec.next()){
                System.out.println("Product ID: " + rec.getString(1));
                System.out.println("Description: " + rec.getString(2));
                System.out.println("Purchase Cost: " + rec.getString(3));
                System.out.println("Quantity on Hand: " + rec.getString(4));
                System.out.println();
            }
            st.close();
        } catch (SQLException s) {
            System.out.println("SQL Error: " + s.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}