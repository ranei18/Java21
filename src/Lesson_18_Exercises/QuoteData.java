
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

public class QuoteData{
    private String ticker;
    
    public QuoteData(String inTicker){
        ticker = inTicker;
    }
    
    private String retrieveQuote(){
        StringBuilder builder = new StringBuilder();
        try {
            URL page = new URL ("http://quote.yahoo.com/d/quotes.csv?s=" + ticker + "&f=sl1d1t1c1ohgv&e=.csv");
            String line;
            URLConnection conn = page.openConnection();
            conn.connect();
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader data = new BufferedReader(in);
            while((line = data.readLine()) != null ){
                builder.append(line);
                builder.append("\n");
            }
            
        } catch (MalformedURLException mue) {
            System.out.println("Bad URL: " + mue.getMessage());
        } catch (IOException ioe) {
            System.out.println("IO Error: " + ioe.getMessage());
        }
        return builder.toString();
                
    }
    
    private void storeQuote(String data) {
        StringTokenizer tokens = new StringTokenizer(data,",");
        String[] fields = new String[8];
        for (int i = 0; i < fields.length; i++){
            fields[i] = stripQuotes(tokens.nextToken());
            System.out.println(fields[i].toString());
        }
        String datasource = "jdbc:derby://localhost:1527/sample";
        try (Connection conn = DriverManager.getConnection (datasource,"app","app")){
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            PreparedStatement prep2 = conn.prepareStatement(
                    "insert into " +
                    "APP.STOCKS(Ticker, Price, Date, Change, Low, High, PriceOpen, Volume) " +
                    "values(?,?,?,?,?,?,?,?)");
            prep2.setString(1, fields[0]);
            prep2.setString(2, fields[1]);
            prep2.setString(3, fields[2]);
            prep2.setString(4, fields[3]);
            prep2.setString(5, fields[4]);
            prep2.setString(6, fields[5]);
            prep2.setString(7, fields[6]);
            prep2.setString(8, fields[7]);
            prep2.executeUpdate();
            prep2.close();
            conn.close();
        } catch (SQLException sqe) {
            System.out.println("SQL Error: " + sqe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        }
        
    }
    
    private String stripQuotes(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '\"'){
                output.append(input.charAt(i));
            }
        }
        return output.toString();
    }
    
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java QuoteData ticker");
            System.exit(0);
        }
        QuoteData qd = new QuoteData(args[0]);
        String data = qd.retrieveQuote();
        qd.storeQuote(data);
    }
}