# This file Is only for planning and trying out ideas.

```java
Class Item {
	private String itemID 			= "";
	private String itemName 		= "";
	private String itemDescription 	= "";
	private double itemPrice 		= 0.0;
	
	public Item(String itemID, String itemName, String itemDescription, double itemPrice){
		boolean validID 			= !itemID.equals("");
		boolean validName 			= !itemName.equals("");
		boolean validPrice 			= itemPrice>=0;
		
		if(validID && validName && validPrice){
			this.itemID 			= itemID;
			this.itemName 			= itemName;
			this.itemDescription 	= itemDescription;
			this.itemPrice 			= itemPrice;
		}else{
			System.out.println("Invalid Inputs for Object");
		}
		
	}

	//Getters
	//...
	
	//Setters
	//...
}

Class Cart {
	ArrayList<Item> itemsList = new ArrayList<Items>();
	Hashmap<String, int> cart = new HashMap<String, int>();
	
	public void 	addToCart(Item item, int quantity){
		// Get values using Scanner
		Item item = new Item(params...);
		
		//If item validated
		//	Check if item in Arraylist
		//  Add item to cart using itemID
	};
	public void 	updateQuantity(Item item, int quantity);
	public void 	deleteItem(Item item);
	
	public int 	displayQuantity(Item item){
		/*
		Goes over every key in hashmap using itemID from item. 
		Returns price if id matches.
		*/
	};
	public double 	displayBill(){
		double totalPrice = 0;
		
		/*
		Goes over every key in hashmap and iterates over itemsList. 
		Returns price if id matches and multiplies it with hash value to get price for the item.
		Adds that price to totalPrice.
		*/
		
		return totalPrice;
	};
	
}
```