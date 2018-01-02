import java.io.*;

class HexSourceReader{
    public HexSourceReader(){
        try(FileReader file = new FileReader("test.txt");
                BufferedReader buff = new BufferedReader(file)){
            boolean eof = false;
            while(!eof){
                String line = buff.readLine();
                if(line == null){
                    eof = true;
                } else {
                    readString(line);
                }
 
            }
            buff.close();
        } catch (IOException e){
            System.out.println("Error -- " + e.getMessage());
        }
        
    }
    
    private void readString(String code){
        try {
            for (int j = 0; j+1 < code.length(); j+=2){
                String sub = code.substring(j,j+2);
                int num = Integer.parseInt(sub,16);
                if(num == 255){
                    return;
                }
                System.out.print(num + " ");
            }
        } finally {
            System.out.println("**");
        }
    }
    
    public static void main(String[] args){
        new HexSourceReader();
    }
}