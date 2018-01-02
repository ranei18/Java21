import java.awt.Point;

class FourDPoint extends Point{
    int w;
    int z;
    
    FourDPoint(int x,int y, int w, int z){
        super(x,y);
        this.w = w;
        this.z = z;
    }
    
    public static void main(String[] args){
        FourDPoint pt = new FourDPoint(5,5,6,7);
        
    }
    
}