import java.util.ArrayList;


public class Cart {
	int cartId;
	int userId;
	ArrayList<Product> products;
	
	public Cart(int cartId, int userId, ArrayList<Product> products) {
		this.cartId = cartId;
		this.userId = userId;
		this.products = products;
	}
	
	public int getCartId() {
		return cartId;
	}
	
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	public int getUserId() {
		return cartId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public void removeProduct(int index) {
		products.remove(index);
	}

}
