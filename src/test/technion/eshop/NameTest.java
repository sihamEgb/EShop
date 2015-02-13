package technion.eshop;

import static org.junit.Assert.*;

import org.junit.Test;

import technion.eshop.entities.Cart;

public class NameTest {

	@Test
	public void acceptNameLength() {
		try {
		//	Cart.init("12345678");
		//	Cart.init("abcdesgf");
		//	Cart.init("AB12fg23");
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}

	@Test
	public void refuseBecauseOfNameLength() {
		try {
			//Cart.init("1234567");
			fail("Not yet implemented");
		} catch (Exception e) {

		}
	}

	@Test
	public void acceptNameCharacters() {
		try {
			//Cart.init("12345678");
			//Cart.init("ABCVXGSJ");
			//Cart.init("zxcvbnma");
			//Cart.init("o12hglwJ");
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}

	@Test
	public void refuseBecauseOfCharacters() {
		try {
			//Cart.init("aaaaaaa/");
			fail("Not yet implemented");
		} catch (Exception e) {

		}
	}

}
