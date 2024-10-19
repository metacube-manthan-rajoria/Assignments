# Shopping Cart
The program below assumes that the Items will be saved in a list and the Quantity in cart.
I'm storing the Items in an ArrayList and Cart using the HashMap.

```java
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Item {
	private String itemID = "";
	private String itemName = "";
	private String itemDescription = "";
	private double itemPrice = 0.0;

	public Item(String itemID, String itemName, String itemDescription, double itemPrice) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
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

	public String getItemDescription() {
		return this.itemDescription;
	}

	public double getItemPrice() {
		return this.itemPrice;
	}

	// Setters - I Commented them because they have no use right now. 
	/*public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}*/
}

class Cart {
	ArrayList<Item> itemsList = new ArrayList<Item>();
	HashMap<String, Integer> cart = new HashMap<String, Integer>();

	public void addToCart(Item item, int quantity) {
		if(item == null) {
			System.out.println("Invalid Item - Enter correct inputs.");
			return;
		}

		Item itemAlreadyExists = getItem(item.getItemID());
		if (itemAlreadyExists == null) {
			itemsList.add(item);
			cart.put(item.getItemID(), quantity);
		}else{
			int itemsInCart = cart.getOrDefault(item.getItemID(), 0);
			cart.put(item.getItemID(), itemsInCart + quantity);
		}
	};

	public void updateQuantity(Item item, int quantity) {
		if(item == null) {
			System.out.println("Invalid Item - Enter correct inputs.");
			return;
		}

		if (cart.containsKey(item.getItemID())) {
			int oldValue = cart.get(item.getItemID());
			cart.put(item.getItemID(), oldValue + quantity);
		}
	};

	public void deleteItem(Item item) {
		if(item == null) return;
		cart.remove(item.getItemID());
	};

	public int displayQuantity(Item item) {
		if (item == null) return 0;
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

	public Item getItem(String itemIDtobeSearched) {
		for (int i = 0; i < itemsList.size(); i++) {
			if (itemsList.get(i).getItemID().equals(itemIDtobeSearched)) {
				return itemsList.get(i);
			}
		}

		return null;
	}
}

class GFG {
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

			// Validation
			boolean validID = !itemId.equals("");
			boolean validName = !itemName.equals("");
			boolean validPrice = itemPrice >= 0;
			boolean validQuantity = itemQuantity >= 0;
			boolean validInputs = validID && validName && validPrice && validQuantity;

			if (validInputs) {
				Item item = new Item(itemId, itemName, itemDescription, itemPrice);
				cart.addToCart(item, itemQuantity);
			} else {
				System.out.println("Invalid Inputs for Object");
				continue;
			}
		}

		Item item1 = cart.getItem("002");

		// Testing Functions below
		System.out.println(cart.displayQuantity(item1));
		cart.updateQuantity(item1, 5);
		System.out.println(cart.displayQuantity(item1));

		double totalBill = cart.displayBill();
		System.out.println(totalBill);

		scanner.close();
	}
}
```