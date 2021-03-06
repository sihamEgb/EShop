package technion.eshop.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Siham
 * Class for shipment info 
 */
public class Shipment {
	private String id;
	private String address;
	private Set<Box> shipmentBoxes;
	private static Integer idGenerator = 1;
	private Integer count;

	private Set<Product> products;
	private Box currBox;

	public Shipment(Cart currCart) {
		products = currCart.getProductsInCart();
		id = idGenerator.toString();
		idGenerator++;
		shipmentBoxes = new HashSet<Box>();
		currBox = new Box(id);
		count = 0;

	}

	// TODO - check this !!
	public boolean addProductToBox(Product currProduct) {

		if (currBox.addProduct(currProduct) == true) {
			System.out.println("Product" + currProduct + " is added");
			count++;
			return true;
		} else {
			shipmentBoxes.add(currBox);
			currBox = new Box(id);
			addProductToBox(currProduct);
		}
		return false;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setAddress(String add) {
		address = add;
	}

	public Set<Box> getBoxes() {
		Set<Box> temp = shipmentBoxes;
		temp.add(currBox);
		return temp;
	}

	public Integer getProductsNum() {
		return count;
	}

	public String getAddress() {
		return address;
	}

}
