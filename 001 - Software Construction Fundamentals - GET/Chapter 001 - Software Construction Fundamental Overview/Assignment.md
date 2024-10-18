
```java
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Item {
	private String itemID 			= "";
	private String itemName 		= "";
	private String itemDescription 	= "";
	private double itemPrice 		= 0.0;
	
	public Item(String itemID, String itemName, String itemDescription, double itemPrice){
		this.itemID 			= itemID;
		this.itemName 			= itemName;
		this.itemDescription 	= itemDescription;
		this.itemPrice 			= itemPrice;
		
		// Delete the sout's during production
		System.out.println("Item ID     : " + this.itemID);
		System.out.println("Item Name   : " + this.itemName);
		System.out.println("Item Desc   : " + this.itemDescription);
		System.out.println("Item Price  : " + this.itemPrice);
	}

	//Getters
	public String getItemID(){
	    return this.itemID;
	}
	public String getItemName(){
	    return this.itemName;
	}
	public String getItemDescription(){
	    return this.itemDescription;
	}
	public double getItemPrice(){
	    return this.itemPrice;
	}
	
	//Setters
	public void setItemID(String itemID){
	    this.itemID = itemID;
	}
	public void setItemName(String itemName){
	    this.itemName = itemName;
	}
	public void setItemDescription(String itemDescription){
	    this.itemDescription = itemDescription;
	}
	public void setItemPrice(double itemPrice){
	    this.itemPrice = itemPrice;
	}
}

class Cart {
	ArrayList<Item> itemsList = new ArrayList<Item>();
	HashMap<String, Integer> cart = new HashMap<String, Integer>();
	
	public void addToCart(Item item, int quantity){
		if(!itemsList.contains(item)){
		    itemsList.add(item);
		}
		cart.put(item.getItemID(), quantity);
		
		// Delete the sout's during production
		System.out.println("Item ID : " + item.getItemID() + " - " + cart.get(item.getItemID()) + "\n");
	};
	
	public void updateQuantity(Item item, int quantity){
	    if(cart.containsKey(item.getItemID())){
	        int oldValue = cart.get(item.getItemID());
	        cart.put(item.getItemID(), oldValue + quantity);
	    }
	};
	
	public void deleteItem(Item item){
	    cart.remove(item);
	};
	
	public int displayQuantity(Item item){
	    if(item == null) return 0;
		String itemId = item.getItemID();
		return cart.getOrDefault(itemId, 0);
	};
	
	public double displayBill(){
		double totalPrice = 0;
		
		for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String itemId = entry.getKey();
            int itemQuantity = (int)entry.getValue();
            
            for(int i = 0; i<itemsList.size(); i++){
                if(itemsList.get(i).getItemID().equals(itemId)){
                    double price = itemsList.get(i).getItemPrice();
                    totalPrice = totalPrice + (price * itemQuantity);
                    
                }
                
            }
        }
		
		return totalPrice;
	};
	
	public Item getItem(String itemIDtobeSearched){
	    for(int i = 0; i<itemsList.size(); i++){
	        if(itemsList.get(i).getItemID().equals(itemIDtobeSearched)){
	            return itemsList.get(i);
	        }
	    }
	    
	    return null;
	}
	
}


class GFG {
	public static void main (String[] args) {
	    System.out.println("Shopping Cart\n");
	    
	    Cart cart = new Cart();
	    Scanner scanner = new Scanner(System.in);
	    
	    int itemsToAdd = 0;
	    itemsToAdd = scanner.nextInt();
	    scanner.nextLine();
	    
	    // Adding items to cart
	    for(int i = 0; i<itemsToAdd; i++){
	        String itemId           = scanner.nextLine();
    	    String itemName         = scanner.nextLine();
    	    String itemDescription  = scanner.nextLine();
    	    double itemPrice        = scanner.nextDouble();
    	    int itemQuantity        = scanner.nextInt();
    	    scanner.nextLine();
    	    
    	    // Validation
    	    boolean validID 			= !itemId.equals("");
    		boolean validName 			= !itemName.equals("");
    		boolean validPrice 			= itemPrice>=0;
    		boolean validQuantity       = itemQuantity>=0;
    		boolean validInputs         = false;
    		
    		if(validID && validName && validPrice && validQuantity){
    			validInputs = true;
    		}else{
    			System.out.println("Invalid Inputs for Object");
    			continue;
    		}
    		
    		Item item = new Item(itemId, itemName, itemDescription, itemPrice);
    		
    		cart.addToCart(item, itemQuantity);
	    }
	    
	    Item item1 = cart.getItem("002");
	    
	    // Testing Functions below
	    System.out.println(cart.displayQuantity(item1));
	    cart.updateQuantity(item1, 5);
	    System.out.println(cart.displayQuantity(item1));
	    
	    double totalBill = cart.displayBill();
	    System.out.println(totalBill);
	}
}
```