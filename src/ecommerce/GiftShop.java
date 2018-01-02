package ecommerce;

public class GiftShop{
    public static void main(String[] args){
        StoreFront store = new StoreFront();
        
        store.addItem("c01","Mug","9.99","150",true);
        store.addItem("c02","LG Mug","12.99","82",false);
        store.addItem("c03","Mousepad","10.49","800",false);
        store.addItem("c04","Shirt","16.99","90",false);        
        
        store.sort();
        
        for (int i = 0; i < store.getSize(); i ++){
            Item show = (Item) store.getItem(i);
            System.out.println("\nItem ID: " + show.getId());
            System.out.println("\nRetail Price: " + show.getRetail());
            System.out.println("\nPrice: " + show.getPrice());
            System.out.println("\nQuantity: " + show.getQuantity());
        }
        
    }
}