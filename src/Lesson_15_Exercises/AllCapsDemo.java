import java.io.*;
import java.nio.file.*;

public class AllCapsDemo{
    public static void main(String[] args){
        if(args.length < 1){
            System.out.println("You must specify a filename");
            System.exit(-1);
        }
        AllCaps cap = new AllCaps(args[0]);
        cap.convert();
    }
}
class AllCaps{
    String sourceName;
    
    AllCaps(String sourceArg){
        sourceName = sourceArg;
    }
    
    void convert(){
        try {
            FileSystem fs = FileSystems.getDefault();
            Path source = fs.getPath(sourceName);
            Path temp = fs.getPath("tmp_" + sourceName);
            
            FileReader fr = new FileReader(source.toFile());
            BufferedReader in = new BufferedReader(fr);
            
            FileWriter fw = new FileWriter(temp.toFile());
            BufferedWriter out = new BufferedWriter(fw);
            
            boolean eof = false;
            int inChar;
            do {
                inChar = in.read();
                if(inChar != -1){
                    char outChar = Character.toUpperCase((char) inChar);
                    out.write(outChar);
                } else {
                    eof = true;
                }
            } while (!eof);
            in.close();
            out.close();
            
            Files.delete(source);
            Files.move(temp, source);
            
        } catch (IOException e) {
            System.out.println("Error -- " + e.getMessage());
        }
    }
}