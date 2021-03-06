package technion.eshop;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import technion.eshop.entities.Cart;
import technion.eshop.entities.Product;
import technion.eshop.entities.Shipment;
import technion.eshop.entities.Store;


public class StoreTest {

	@Test
	public final void testStore() {
		Store myStore = new Store();
		assertEquals(myStore.getCurrentCarts().size(),0);
		assertEquals(false,myStore.getProducts().size()==0);
		//assertEquals(0,myStore.getBillsNumber());
		//assertEquals(0,myStore.getShipmentsNumber());
	}

	@Test
	public final void testAddShipment() {
		Store myStore = new Store();
		Cart cart = new Cart("345re",myStore);
		Shipment ship = new Shipment(cart);
		myStore.addShipment(ship);
	}

	@Test
	public final void testAddBill() {
		Store myStore = new Store();
		Cart cart = new Cart("345re",myStore);
		myStore.addBill(cart);
	}

	@Test
	public final void testGetProducts() {
		Store myStore = new Store();
		assertEquals(false,myStore.getProducts().size()==0);
	}

	@Test
	public final void testProdductTaken() {
		Store myStore = new Store();
		int size = myStore.getProducts().size();
		int i=0;
		Set<Product> s = new HashSet<Product>();
        s.addAll(myStore.getProducts());
		for(Product p : s){
			 myStore.productTaken(p);
			 i++;
			 assertEquals(myStore.getProducts().size(),size-i);
			 assertEquals(false,myStore.getProducts().contains(p));
		}
	    assertEquals(myStore.getProducts().size(),0);
	}

	@Test
	public final void testProdductReturned() {
		Store myStore = new Store();
		int size = myStore.getProducts().size();
		Product p = myStore.getProducts().get(1);
		myStore.productTaken(p);
		myStore.productReturned(p);
		assertEquals(true,myStore.getProducts().contains(p));
		Set<Product> s = new HashSet<Product>();
        s.addAll(myStore.getProducts());
		for(Product p1 : s){
			 myStore.productTaken(p1);
			 p=p1;
		}
		myStore.productReturned(p);
		assertEquals(true,myStore.getProducts().contains(p));
	}

	@Test
	public final void testAddCart() {
		Store myStore = new Store();
		for(int i=1;i<=100;i++){
			myStore.addCart(String.valueOf(i));
			assertEquals(myStore.getCurrentCarts().size(),i);
		}
		assertEquals(myStore.getCurrentCarts().size(),100);
		myStore.addCart("343lk24ss");
		assertEquals(myStore.getCurrentCarts().size(),100);
		myStore.addCart("343lk4ss");
		assertEquals(myStore.getCurrentCarts().size(),101);
		myStore.addCart("343lk4ss");
		assertEquals(myStore.getCurrentCarts().size(),102);
	}

	@Test
	public final void testGetCurrentCarts() {
		Store myStore = new Store();
		assertEquals(myStore.getCurrentCarts().size(),0);
		myStore.addCart("33lk24s");
		assertEquals(myStore.getCurrentCarts().size(),1);
		myStore.addCart(" ");
		assertEquals(myStore.getCurrentCarts().size(),1);
	}

}
