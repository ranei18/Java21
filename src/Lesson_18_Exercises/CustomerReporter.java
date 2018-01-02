import java.sql.*;

public class CustomerReporter{
    public static void main(String[] args){
        String data = "jdbc:derby://localhost:1527/sample";
        try (Connection conn = DriverManager.getConnection(data,"app","app");
                Statement st = conn.createStatement()) {
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            ResultSet rec = st.executeQuery(
                    "select Customer_ID, Name, City, State " +
                    "from APP.Customer " +
                    "order by Customer_ID");
            
            while (rec.next()){
                System.out.println("Customer_ID:\t" + rec.getString(1));
                System.out.println("Name:\t" + rec.getString(2));
                System.out.println("City:\t" + rec.getString(3));
                System.out.println("State:\t" + rec.getString(4));
                System.out.println();
            }
            st.close();
            
            
        } catch (SQLException s) {
            System.out.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
        } catch (Exception e) {
            System.out.println("Error: " + e.toString() + e.getMessage());
        }
    }
}