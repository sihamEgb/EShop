package technion.eshop.entities;

import java.util.HashSet;
import java.util.Set;

public class Box {

	private static Integer idGenerator = 1;
	private String id;
	private String shipmentId;
	// private Integer count;
	private Set<Product> products;

	public Box(String shipmentId) {
		// count = 0;
		id = idGenerator.toString();
		idGenerator++;
		this.shipmentId = shipmentId;
		products = new HashSet<Product>();
	}

	public boolean addProduct(Product addedProduct) {
		if (products.size() >= 5)
			return false;
		products.add(addedProduct);
		return true;
	}

	@Override
	public String toString() {
		return id;
	}

	public String getBoxContent() {
		String s = "";
		for (Product p : products)
			s += p + "\n";
		return s;
	}

	public String getShipmentId() {
		return this.shipmentId;
	}

	public Set<Product> getProducts() {
		return this.products;
	}
}
