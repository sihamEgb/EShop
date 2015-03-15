package technion.eshop;

import static org.junit.Assert.*;

import java.lang.reflect.Array;

import org.junit.Test;

import technion.eshop.entities.Cart;
import technion.eshop.entities.Product;
import technion.eshop.entities.Shipment;
import technion.eshop.entities.Store;

public class ShipmentTest {

	@Test
	public final void testShipment() {
		Store store = new Store();
		Cart cart = new Cart("023RTY67",store);
		Shipment shipment = new Shipment(cart);
		assertEquals(shipment.getBoxes().size(),1);
		assertEquals(shipment.getProducts().size(),cart.getProductsInCart().size());
		for(Product p : shipment.getProducts())
			assertEquals(true,cart.getProductsInCart().contains(p));
		assertEquals(shipment.getProductsNum().intValue(),0);
		
		cart.addProduct(store.getProducts().get(1));
		cart.addProduct(store.getProducts().get(2));
		shipment = new Shipment(cart);
		assertEquals(shipment.getProducts().size(),cart.getProductsInCart().size());
		for(Product p : shipment.getProducts())
			assertEquals(true,cart.getProductsInCart().contains(p));
		assertEquals(shipment.getProductsNum().intValue(),0);
		assertEquals(shipment.getBoxes().size(),1);
	}

	@Test
	public final void testAddProductToBox() {
		Store store = new Store();
		Cart cart = new Cart("023RTY67",store);
		assert(store.getProducts().size()>=6);
		cart.addProduct(store.getProducts().get(1));
		cart.addProduct(store.getProducts().get(1));
		cart.addProduct(store.getProducts().get(1));
		cart.addProduct(store.getProducts().get(1));
		cart.addProduct(store.getProducts().get(1));
		cart.addProduct(store.getProducts().get(1));
		Shipment shipment = new Shipment(cart);
		Object[] productsArr = shipment.getProducts().toArray();
		shipment.addProductToBox((Product)productsArr[1]);
		shipment.addProductToBox((Product)productsArr[2]);
		assertEquals(shipment.getBoxes().size(),1);
		assertEquals(shipment.getProductsNum().intValue(),2);
		shipment.addProductToBox((Product)productsArr[3]);
		shipment.addProductToBox((Product)productsArr[4]);
		shipment.addProductToBox((Product)productsArr[5]);
		assertEquals(shipment.getBoxes().size(),1);
		assertEquals(shipment.getProductsNum().intValue(),5);
		shipment.addProductToBox((Product)productsArr[0]);
		assertEquals(shipment.getBoxes().size(),2);
		assertEquals(shipment.getProductsNum().intValue(),6);
	}

	@Test
	public final void testGetProducts() {
		Store store = new Store();
		Cart cart = new Cart("023RTY67",store);
		assert(store.getProducts().size()>=6);
		cart.addProduct(store.getProducts().get(1));
		cart.addProduct(store.getProducts().get(1));
		cart.addProduct(store.getProducts().get(1));
		cart.addProduct(store.getProducts().get(1));
		cart.addProduct(store.getProducts().get(1));
		cart.addProduct(store.getProducts().get(1));
		Shipment shipment = new Shipment(cart);
		for(Product p : cart.getProductsInCart())
			assertEquals(true,shipment.getProducts().contains(p));
		for(Product p : shipment.getProducts())
			assertEquals(true,cart.getProductsInCart().contains(p));
	}

	@Test
	public final void testGetBoxes() {
		//Testing of this method is included in the tests above
	}

	@Test
	public final void testGetProductsNum() {
		//Testing of this method is included in the tests above
	}

}
