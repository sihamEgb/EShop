package technion.eshop.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;

public class Store {

	private Set<Cart> currentCarts;
	private ArrayList<Product> stockProducts;
	private Report storeReport;

	public Store() {
		stockProducts = new ArrayList<Product>();
		initProducts();
		currentCarts = new HashSet<Cart>();

		storeReport = new Report();
	}

	public void addShipment(Shipment s) {
		storeReport.addShipment(s);
	}

	public void addBill(Cart c) {
		System.out.println("add bill in store class");
		storeReport.addBill(c);
	}

	/**
	 * adds the products in the store...
	 */
	private void initProducts() {

		Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"res\\stock.json"));
			Product[] arr = gson.fromJson(br, Product[].class);
			for (Product p : arr) {
				stockProducts.add(p);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Product> getProducts() {
		return stockProducts;
	}

	public void productTaken(Product p) {
		stockProducts.remove(p);
	}

	public void productReturned(Product p) {
		stockProducts.add(p);
	}

	// TODO up to 8 chars ...is 0 allowed?
	public Cart addCart(String name) {

		Pattern p = Pattern.compile("[a-zA-Z0-9]*");
		Matcher m = p.matcher(name);
		boolean b = m.matches();

		if ((name.length() <= 8) && (b == true)) {
			Cart cart = new Cart(name, this);
			currentCarts.add(cart);
			return cart;
		}
		return null;
	}

	public Set<Cart> getCurrentCarts() {
		return currentCarts;
	}

	public Report getReport() {
		return storeReport;
	}

}
