import java.util.Scanner;

public class EcommerceSystem {
	private static Product[] inventory;
	private static Cart cart;
	private static Scanner input;
	private static int menuChoice;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stockInventory();
		input = new Scanner(System.in);
		System.out.println("Welcome to the Ecommerce System");
		System.out.println("Please enter your User ID to start:");
		int userID = positiveInteger(input);
		System.out.println("Welcome User:"+userID);
		cart = new Cart(1, userID);
		
		//loop until user hits exit
		do {
			System.out.println("Ecommerce Menu:\n1:Add Product\n2:Remove product\n3.Exit");
			menuChoice = positiveInteger(input);
			switch (menuChoice) {
			case 1:
				addProduct();
				break;	
			case 2:
				removeProduct();
				break;
			case 3:
				System.out.println("System Exiting... Thank you for using Ecommerce System");
				break;
			default:
				System.out.println("Please select a valid menu option.");
			}
		}while(menuChoice != 3);
		
	}
	
	//adding products to inventory
	public static void stockInventory() {
		inventory = new Product[8];
		inventory[0] = new Product(1, "Iphone x", 2000);
		inventory[1] = new Product(2, "Samsung S8", 1800);
		inventory[2] = new Product(3, "Huawei P30", 1000);
		inventory[3] = new Product(4, "Apple Watch", 400);
		inventory[4] = new Product(5, "Air Pods", 299);
		inventory[5] = new Product(6, "Samsung S9", 1900);
		inventory[6] = new Product(7, "Beats Headset", 600);
		inventory[7] = new Product(8, "Huawei Mate20", 1700);		
	}	
	
	//inventory display
	public static void displayInventory() {
		System.out.println("Please select the prodcut you want to add.\nProduct ID\tProduct Name\n1\t\tIphone x\n2\t\tSamsung S8"
				+ "\n3\t\tHuawei P30\n4\t\tApple Watch"
				+ "\n5\t\tAir Pods\n6\t\tSamsung S9"
				+ "\n7\t\tBeats Headset\n8\t\tHuawei Mate 20");
	}
	
	//scans user input until a positive integer is provided
	public static int positiveInteger(Scanner input) {
		int choice;
		while(!input.hasNextInt()) {
			System.out.println("Wrong Input!!! Please try again.");
			input.next();	
		}
		choice = input.nextInt();
		return choice;
	}
		
	//adding product to your cart
	public static void addProduct() {
		int productChoice;
		displayInventory();
		productChoice = positiveInteger(input);
		if(productChoice>=0 && productChoice <= inventory.length) {
			cart.addProduct(new Product(inventory[productChoice-1].productId, inventory[productChoice-1].productName, inventory[productChoice-1].price));
			System.out.println(inventory[productChoice-1].productName+ " is added to your cart");
			displayCart();
		}
		else
		{
			System.out.println("Please enter a valid product ID");
			addProduct();		//recursion to get a valid product ID
		}
		
	}
	
	//remove the item from the cart
	public static void removeProduct() {
		int productChoice;
		//if the cart is empty return to menu selection
		if(displayCart()) {
			System.out.println("Please enter the product number to remove");
			productChoice = positiveInteger(input);
			if (productChoice >= 0 && productChoice <= cart.getProducts().size()) {
				System.out.println(cart.getProducts().get(productChoice-1).getProductName()+ "is removed from your cart");
				cart.removeProduct(productChoice-1);
				displayCart();
				
			}
			else {
				System.out.println("There is no product with ID: "+productChoice+" Please try again");
				removeProduct();	//recursion to get a valid product number in the cart
			}
		}
		
	}
	
	//displays cart items
	public static boolean displayCart() {
		if(cart.getProducts() == null ||cart.getProducts().isEmpty()) {
			System.out.println("Your cart is empty");
			return false;
		}
		else {
			int totalPrice = 0;
			System.out.println("Product Name\t\tPrice");
			//looping through all the products in the cart
			for(int i=0;i<cart.products.size();i++) {
				totalPrice += cart.getProducts().get(i).getPrice();
				System.out.println(i+1+"."+cart.getProducts().get(i).productName+"\t\t$"+cart.getProducts().get(i).price);
			}
			System.out.println("Total Price:$"+totalPrice);
			return true;
		}
	}
}

		