import java.util.*;

public class CodeKeeper{
    ArrayList list;
    String[] codes = {"alpha","lambda","gamma","delta","zeta"};
    
    public CodeKeeper(String[] userCodes){
        list = new ArrayList();
        for (int i = 0; i < codes.length; i++){
            addCode(codes[i]);
        }
        for (int j = 0; j < userCodes.length; j++){
            addCode(userCodes[j]);
        }
        
        for (Iterator it = list.iterator(); it.hasNext();){
            String output = (String) it.next();
            System.out.println(output);
        }
        
    }
    
    private void addCode(String code){
        if(!list.contains(code)){
            list.add(code);
        }
    }
    
    public static void main(String[] args){
        CodeKeeper keeper = new CodeKeeper(args);
    }
    
}