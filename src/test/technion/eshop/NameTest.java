package technion.eshop;

import static org.junit.Assert.*;

import org.junit.Test;

import technion.eshop.entities.Cart;
import technion.eshop.entities.Store;

public class NameTest {

	@Test
	public void acceptNameLength() {
		String name = "4rt5";
		Store myStore = new Store();
		Cart newCart = myStore.addCart(name);
		assertEquals(true,newCart!=null);
		assertEquals(1,myStore.getCurrentCarts().size());
	}

	@Test
	public void refuseBecauseOfNameLength() {
		String name = "4rTRY975Yt5";
		Store myStore = new Store();
		Cart newCart = myStore.addCart(name);
		assertEquals(true,newCart==null);
		assertEquals(0,myStore.getCurrentCarts().size());
	}

	@Test
	public void acceptNameCharacters() {
		String name = "4OUrt5";
		Store myStore = new Store();
		Cart newCart = myStore.addCart(name);
		assertEquals(true,newCart!=null);
		assertEquals(1,myStore.getCurrentCarts().size());
	}

	@Test
	public void refuseBecauseOfCharacters() {
		String name = "&4rt*5";
		Store myStore = new Store();
		Cart newCart = myStore.addCart(name);
		assertEquals(true,newCart==null);
		assertEquals(0,myStore.getCurrentCarts().size());
	}

}
