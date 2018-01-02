import java.io.*;

class FileWiper{
    public FileWiper(){
        String fileName = "junkfile.dat";
        int count;
        count = readFile(fileName);
        writeFile(fileName,count);
   
    }
    
    public int readFile(String fileName){
       try(FileInputStream file = new FileInputStream(fileName)){
            boolean eof = false;
            int count = 0;
            while(!eof){
                int input = file.read();
                System.out.print(input + " ");
                if(input == -1){
                    eof = true;
                } else {
                    count++;
                }
            }
            file.close();
            System.out.println("\nBytes read: " + count);
            return count;
        } catch (IOException e){
            System.out.println("Error -- " + e.getMessage());
            return 0;
        } 
    }
    
    public void writeFile(String fileName,int count){
        try (FileOutputStream file = new FileOutputStream(fileName)){
            for (int i = 0; i < count; i++){
                file.write( (byte) 0);
            }
            file.close();
        } catch(IOException e) {
            System.out.println("Error -- " + e.getMessage());
        }
    }
    
    public static void main(String[] args){
        new FileWiper();

    }
    
}