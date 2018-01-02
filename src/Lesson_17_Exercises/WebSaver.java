import java.net.*;
import java.io.*;

public class WebSaver{
    
    void getData(String address) throws MalformedURLException {
        URL page = new URL(address);
        //String filename = page.getHost() + "_" + page.getFile() + "_file.html";
        //File output = new File(filename);
        
        //StringBuilder text = new StringBuilder();
        try {
            //FileWriter fw = new FileWriter(output);
            //BufferedWriter out = new BufferedWriter(fw);
            
            HttpURLConnection conn = (HttpURLConnection) page.openConnection();
            page.openConnection();
            conn.connect();
            InputStreamReader in = new InputStreamReader((InputStream) conn.getContent());
            BufferedReader buff = new BufferedReader(in);
            String line;
            do {
                line = buff.readLine();
                //text.append(line);
                //System.out.println(line.toString());
                //text.append("\n");
                //out.write(line,0,line.length());
            } while (line != null);
            //out.flush();
            //out.close();
            System.out.println("File saved.");
            
        } catch (IOException ioe){
            System.out.println("IO Error: " + ioe.getMessage());
        } 
    }
    
    
    
    public static void main(String[] args){
        if(args.length < 1){
            System.out.println("Usage: java WebSaver url");
            System.exit(1);
        }
        try {
            WebSaver app = new WebSaver();
            app.getData(args[0]);
        } catch (MalformedURLException mue){
            System.out.println(mue.getMessage());
        }
    }
    
}