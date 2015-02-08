package technion.eshop.entities;

import java.util.HashSet;
import java.util.Set;

public class Box {

	private static Integer idGenerator = 1;
	private String id;
	private String shipmentId;
	private Integer count;
	private Set<Product> products;

	public Box(String shipmentId) {
		count = 0;
		id = idGenerator.toString();
		idGenerator++;
		this.shipmentId = shipmentId;
		products = new HashSet<Product>();
	}

	public boolean addProduct(Product addedProduct) {
		if (count < 5) {
			products.add(addedProduct);
			count++;
			return true;
		}
		return false;

	}
}
