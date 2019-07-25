import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EcommerceSystemTest {

	@Test
	void testAddFeature() {
		Cart cart = new Cart(1,1);
		assertEquals(0, cart.getProducts().size());
		
		cart.addProduct(new Product(1, "Apple", 100));
		assertEquals(1, cart.getProducts().size());
		assertEquals(1, cart.getProducts().get(0).getProductId());
		assertEquals("Apple", cart.getProducts().get(0).productName);
		assertEquals(100, cart.getProducts().get(0).getPrice());
		
		cart.addProduct(new Product(2, "Nokia", 2300));
		assertEquals(2, cart.getProducts().size());
		assertEquals(2, cart.getProducts().get(1).getProductId());
		assertEquals("Nokia", cart.getProducts().get(1).productName);
		assertEquals(2300, cart.getProducts().get(1).getPrice());
	}
	
	@Test
	void testRemoveFeature() {
		Cart cart = new Cart(1,1);
		assertEquals(0, cart.getProducts().size());
		
		cart.addProduct(new Product(1, "Apple", 100));
		cart.addProduct(new Product(2, "Nokia", 2300));
		cart.addProduct(new Product(3, "Samsung", 1111));
		cart.removeProduct(2);
		assertEquals(2, cart.getProducts().size());
		assertEquals("Nokia", cart.getProducts().get(cart.getProducts().size()-1).getProductName(),"the last product in the cart should be Nokia");
		
		cart.removeProduct(0);
		assertEquals(1, cart.getProducts().size());
		assertEquals("Nokia", cart.getProducts().get(0).getProductName(),"the first element of the cart should be Nokia");
		
		cart.removeProduct(0);
		assertEquals(0, cart.getProducts().size());
		
	}

}
