package technion.eshop;

import static org.junit.Assert.*;

import org.junit.Test;

import technion.eshop.entities.Cart;
import technion.eshop.entities.Product;
import technion.eshop.entities.Store;

public class CartTest {

	@Test
	public final void testCart() {
		String name= "Siham12egb";
		Store myStore = new Store();
		Cart cart = new Cart(name,myStore);
		assertEquals(true,(cart.getCustomerName()).equals(name));
		assertEquals(cart.getSum().intValue(),0);
		assertEquals(cart.getProductsInCart().size(),0);
		assertEquals(true,cart.getMyStore()==myStore);
		String name2 = "deema43543";
		Cart cart2 = new Cart(name2,myStore);
		assertEquals(false,(cart.getCartId()).equals(cart2.getCartId()));
	}

	@Test
	public final void testAddProduct() {
		String name= "Siham345egb";
		Store myStore = new Store();
		Cart cart = new Cart(name,myStore);
		Product product = new Product("Milk", "Tnova", 11, 15, 3,2018);
		Product product2 = new Product("Milki", "Tnova", 9, 14, 3,2012);
	    //Case1 : adding product with expired date - (Product should not be added to cart)
		cart.addProduct(product2);
		assertEquals(true,cart.getProductsInCart().contains(product2));
		//Cas2 : adding product with unexpired date - (Product should be added to cart)
		cart.addProduct(product);
		assertEquals(true,cart.getProductsInCart().contains(product));
	}

	@Test
	public final void testRemoveProduct() {
		String name= "Siham768egb";
		Store myStore = new Store();
		Cart cart = new Cart(name,myStore);
		Product product = new Product("Milk", "Tnova", 11, 15, 3,2018);
		Product product2 = new Product("Milki", "Tnova", 9, 14, 3,2012);
		Product product3 = new Product("Milk", "Tara", 9, 14, 9,2015);
		cart.addProduct(product2);
		cart.addProduct(product3);
		cart.addProduct(product);
		//Case1 : removing product exist in cart - (removing product from cart successfully)
		cart.removeProduct(product);
		assertEquals(false , cart.getProductsInCart().contains(product));
		assertEquals(true,cart.getProductsInCart().contains(product3));
		assertEquals(true , cart.getProductsInCart().contains(product2));
		//Case2 : removing product that does not exist in cart - (products in cart should not be changed)
		cart.removeProduct(product2);
		assertEquals(true,cart.getProductsInCart().contains(product3));
	}

	@Test
	public final void testGetCustomerName() {
		String name= "AsXwer345nM";
		Store myStore = new Store();
		Cart cart = new Cart(name,myStore);
		assertEquals(true,(cart.getCustomerName()).equals(name));
	}

	@Test
	public final void testSetCustomerName() {
		String name= "AsXwer345nM";
		Store myStore = new Store();
		Cart cart = new Cart(name,myStore);
		String name2 = "435435dfsbu";
		cart.setCustomerName(name2);
		assertEquals(true,(cart.getCustomerName()).equals(name2));
	}

	@Test
	public final void testGetSum() {
		String name= "AsXwer345nM";
		Store myStore = new Store();
		Cart cart = new Cart(name,myStore);
		Product product = new Product("Milk", "Tnova", 11, 15, 3,2018);
		Product product2 = new Product("Milki", "Tnova", 9, 14, 3,2012);
		Product product3 = new Product("Milk", "Tara", 9, 14, 9,2015);
		cart.addProduct(product2);
		assertEquals(cart.getSum().intValue(),product2.getPrice().intValue());
		cart.addProduct(product3);
		cart.addProduct(product);
		assertEquals(cart.getSum().intValue(),product.getPrice()+product3.getPrice()+product2.getPrice());
	}

	@Test
	public final void testSetSum() {
		String name= "AsXwer345nM";
		Store myStore = new Store();
		Cart cart = new Cart(name,myStore);
		Product product = new Product("Milk", "Tnova", 11, 15, 3,2018);
		Product product2 = new Product("Milki", "Tnova", 9, 14, 3,2012);
		Product product3 = new Product("Milk", "Tara", 9, 14, 9,2015);
		cart.addProduct(product2);
		cart.addProduct(product3);
		cart.addProduct(product);
		cart.setSum(898798798);
		assertEquals(cart.getSum().intValue(),898798798);
		cart.addProduct(product);
		cart.setSum(-44);
		assertEquals(cart.getSum().intValue(),-44);
	}

	@Test
	public final void testGetStoreProducts() {
		String name= "AsXwer345nM";
		Store myStore = new Store();
		Cart cart = new Cart(name,myStore);
		for(Product p : myStore.getProducts()){
			assertEquals(true,cart.getStoreProducts().contains(p));
		}
		Product p = myStore.getProducts().get(1);
		cart.addProduct(p);
		for(Product p1 : myStore.getProducts()){
			assertEquals(true,cart.getStoreProducts().contains(p1));
		}
	}

	@Test
	public final void testGetMyStore() {
		String name= "AsXwer345nM";
		Store myStore = new Store();
		Cart cart = new Cart(name,myStore);
		assertEquals(true, myStore==cart.getMyStore());
	}

	@Test
	public final void testGetProductsInCart() {
		String name= "AsXwer345nM";
		Store myStore = new Store();
		Cart cart = new Cart(name,myStore);
		Product product = new Product("Milk", "Tnova", 11, 15, 3,2018);
		Product product2 = new Product("Milki", "Tnova", 9, 14, 3,2012);
		Product product3 = new Product("Milk", "Tara", 9, 14, 9,2015);
		cart.addProduct(product2);
		cart.addProduct(product3);
		cart.addProduct(product);
		assertEquals(3,cart.getProductsInCart().size());
		assertEquals(true, cart.getProductsInCart().contains(product));
		assertEquals(true, cart.getProductsInCart().contains(product2));
		assertEquals(true, cart.getProductsInCart().contains(product3));
	}

}
