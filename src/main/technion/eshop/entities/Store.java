package technion.eshop.entities;

import java.util.HashSet;
import java.util.Set;

public class Store {
	private Set<Product> storeProducts;

	private Set<Cart> currentCarts;
	// TODO add more info like sum and address...
	private Integer shipmentsNumber;
	private Integer billsNumber;

	// private Stats ??

	public Store() {
		storeProducts = new HashSet<Product>();
		initProducts();
		currentCarts = new HashSet<Cart>();
	}

	public void addShipment() {
		shipmentsNumber++;
	}

	public void addBill() {
		billsNumber++;
	}

	/**
	 * adds the products in the store...
	 */
	private void initProducts() {
		Product p1 = new Product("milk1", 10, 3, 4, 2015);
		storeProducts.add(p1);
		Product p2 = new Product("milk2", 10, 3, 4, 2015);
		storeProducts.add(p2);
		Product p3 = new Product("milk3", 10, 3, 4, 2015);
		storeProducts.add(p3);
		Product p4 = new Product("milk4", 10, 3, 4, 2015);
		storeProducts.add(p4);
		Product p5 = new Product("milk5", 10, 3, 4, 2015);
		storeProducts.add(p5);

	}
}
