
public class EcommerceSystem {
	private static Product[] inventory;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stockInventory();
		System.out.print("Inventory Stocked"+inventory.length);

	}
	
	public static void stockInventory() {
		inventory = new Product[8];
		inventory[0] = new Product(1, "Iphone x", 2000);
		inventory[1] = new Product(2, "Samsung S8", 1800);
		inventory[2] = new Product(3, "Huawei P30", 1000);
		inventory[3] = new Product(4, "Apple Watch", 400);
		inventory[4] = new Product(5, "Air Pod", 299);
		inventory[5] = new Product(6, "Samsung S9", 1900);
		inventory[6] = new Product(7, "Beats Headset", 600);
		inventory[7] = new Product(8, "Huawei Mate20", 1700);		
	}	
}
