
import java.sql.*;
import java.util.*;

public class DmozHandlerImpl implements DmozHandler {
    public HashMap getRandomSite(){
        Connection conn = getMySqlConnection();
        HashMap<String, String> response = new HashMap<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rec = st.executeQuery(
                "SELECT * FROM cooldata ORDER BY RAND() LIMIT 1");
            if (rec.next())
            {
                response.put("url", rec.getString("url"));
                response.put("title", rec.getString("title"));
                response.put("description", rec.getString("description"));
                
            } else {
                response.put("error", "no database record found");
            }
            st.close();
            rec.close();
            conn.close();
            
        } catch (SQLException sqe) {
            System.out.println("Error: " + sqe.getMessage());
        }
        return response;
    }
    
    private Connection getMySqlConnection(){
        Connection conn = null;
        String data = "jdbc:mysql://localhost/cool";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(data, "cool","mrfreeze");
        } catch(SQLException s){
            System.out.println("Error: " + s.getMessage());
        } catch(Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        return conn;
    }
}