/*package whatever //do not write package name here */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

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
	public void getItemID(String itemID){
	    this.itemID = itemID;
	}
	public void getItemName(String itemName){
	    this.itemName = itemName;
	}
	public void getItemDescription(String itemDescription){
	    this.itemDescription = itemDescription;
	}
	public void getItemPrice(double itemPrice){
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
	    
	};
	
	public void deleteItem(Item item){
	    
	};
	
	public int displayQuantity(Item item){
		/*
		Goes over every key in hashmap using itemID from item. 
		Returns price if id matches.
		*/
		return 0;
	};
	
	public double displayBill(){
		double totalPrice = 0;
		
		/*
		Goes over every key in hashmap and iterates over itemsList. 
		Returns price if id matches and multiplies it with hash value to get price for the item.
		Adds that price to totalPrice.
		*/
		
		return totalPrice;
	};
	
}


class GFG {
	public static void main (String[] args) {
	    System.out.println("Shopping Cart\n");
	    
	    Cart cart = new Cart();
	    Scanner scanner = new Scanner(System.in);
	    
	    int itemsToAdd = 0;
	    itemsToAdd = scanner.nextInt();
	    scanner.nextLine();
	    
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
	    
	    
	    
		
	}
}