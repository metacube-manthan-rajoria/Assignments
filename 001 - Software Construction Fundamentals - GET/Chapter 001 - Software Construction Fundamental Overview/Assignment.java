import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

class Item {
	private String itemID = "";
	private String itemName = "";
	private String itemDescription = "";
	private double itemPrice = 0.0;
	private boolean isValidItem = true;

	public Item(String itemID, String itemName, String itemDescription, double itemPrice) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
		
		boolean validID = !this.itemID.equals("") || this.itemID == null;
		boolean validName = !this.itemName.equals("") || this.itemName == null;
		boolean validPrice = this.itemPrice >= 0;
		boolean validInputs = validID && validName && validPrice;
		if(!validInputs){
			isValidItem = false;
		}
	}

	public void printDetails() {
		System.out.println("Item ID     : " + this.itemID);
		System.out.println("Item Name   : " + this.itemName);
		System.out.println("Item Desc   : " + this.itemDescription);
		System.out.println("Item Price  : " + this.itemPrice);
	}

	// Getters
	public String getItemID() {
		return this.itemID;
	}

	public String getItemName() {
		return this.itemName;
	}

	public double getItemPrice() {
		return this.itemPrice;
	}

	public boolean getIsValidItem(){
		return this.isValidItem;
	}
}

class Cart {
	ArrayList<Item> itemsList = new ArrayList<Item>();
	HashMap<String, Integer> cart = new HashMap<String, Integer>();

	public void addToCart(Item item, int quantity) {
		if (item == null || !item.getIsValidItem()) {
			System.out.println("Invalid Item");
			return;
		}

		if(quantity < 0){
			System.out.println("Cannot add negative items");
			return;
		}

		Item itemAlreadyExists = getItem(item.getItemID());
		if (itemAlreadyExists == null) {
			itemsList.add(item);
			cart.put(item.getItemID(), quantity);
		} else {
			int itemsInCart = cart.getOrDefault(item.getItemID(), 0);
			cart.put(item.getItemID(), itemsInCart + quantity);
		}
	};

	public void updateQuantity(Item item, int quantity) {
		if (item == null || !item.getIsValidItem()) {
			System.out.println("Invalid Item");
			return;
		}

		if (cart.containsKey(item.getItemID())) {
			int oldValue = cart.get(item.getItemID());
			cart.put(item.getItemID(), oldValue + quantity);
		}
	};

	public void deleteItem(Item item) {
		if (item == null)
			return;
		cart.remove(item.getItemID());
	};

	public int displayQuantity(Item item) {
		if (item == null)
			return 0;
		String itemId = item.getItemID();
		return cart.getOrDefault(itemId, 0);
	};

	public double displayBill() {
		double totalPrice = 0;

		for (Map.Entry<String, Integer> entry : cart.entrySet()) {
			String itemId = entry.getKey();
			int itemQuantity = (int) entry.getValue();

			for (int i = 0; i < itemsList.size(); i++) {
				if (itemsList.get(i).getItemID().equals(itemId)) {
					double price = itemsList.get(i).getItemPrice();
					totalPrice = totalPrice + (price * itemQuantity);
				}
			}
		}

		return totalPrice;
	};

	// Search for item using ID
	public Item getItem(String itemIDtobeSearched) {
		for (int i = 0; i < itemsList.size(); i++) {
			if (itemsList.get(i).getItemID().equals(itemIDtobeSearched)) {
				return itemsList.get(i);
			}
		}

		return null;
	}
}

class Assignment {
	public static void main(String[] args) {
		System.out.println("Shopping Cart");

		Cart cart = new Cart();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of items to add : ");
		int itemsToAdd = 0;
		itemsToAdd = scanner.nextInt();
		scanner.nextLine();
		System.out.println();

		// Adding items to cart
		for (int i = 0; i < itemsToAdd; i++) {

			// Getting user input
			try {
				System.out.print("Item ID : ");
				String itemId = scanner.nextLine();
				System.out.print("Item Name : ");
				String itemName = scanner.nextLine();
				System.out.print("Item Description : ");
				String itemDescription = scanner.nextLine();
				System.out.print("Item Price : ");
				double itemPrice = scanner.nextDouble();
				System.out.print("Item Quantity : ");
				int itemQuantity = scanner.nextInt();
				scanner.nextLine();
				System.out.println();

				Item item = new Item(itemId, itemName, itemDescription, itemPrice);
				if(item.getIsValidItem()){
					cart.addToCart(item, itemQuantity);
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Inputs - Mismatch Error");
			}
		}

		// Testing Functions below
		double totalBill = cart.displayBill();
		System.out.println("Total Bill : " + totalBill);

		scanner.close();
	}
}
