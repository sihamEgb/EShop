package technion.eshop.entities;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cart {

	private static Integer idGenerator = 1;
	private String id;
	private String customerName;
	private Integer sum;
	private Set<Product> productsInCart;

	private Store myStore;

	public Cart(String name, Store myStore) {
		this.customerName = name;
		this.sum = 0;
		this.productsInCart = new HashSet<Product>();
		this.myStore = myStore;

		id = idGenerator.toString();
		idGenerator++;
	}

	public void addProduct(Product p) {

		if (isDateBad(p.getYear(), p.getMonth(), p.getDay()) == true) {
			// TODO bleep + remove product from store/stock

		}

		// if (p.getDate() - getDate() < 2)
		sum = sum + p.getPrice();
		productsInCart.add(p);
		myStore.prodductTaken(p);

	}

	public void removeProduct(Product p) {
		sum = sum - p.getPrice();
		productsInCart.remove(p);
		myStore.prodductReturned(p);

	}

	public void exitStore() {

	}

	public void sendGrocery() {

	}

	/**
	 * is the date more than two days?
	 */
	public boolean isDateBad(Integer year, Integer month, Integer day) {
		{
			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();

			// TODO - save a date 20/1/2015
			start.set(Calendar.DAY_OF_MONTH, 20);
			start.set(Calendar.YEAR, 2015);
			start.set(Calendar.MONTH, 0);

			end.set(Calendar.DAY_OF_MONTH, day);
			end.set(Calendar.YEAR, year);
			end.set(Calendar.MONTH, month);

			Date startDate = start.getTime();
			Date endDate = end.getTime();
			long startTime = startDate.getTime();
			long endTime = endDate.getTime();
			long diffTime = endTime - startTime;
			long diffDays = diffTime / (1000 * 60 * 60 * 24);
			DateFormat dateFormat = DateFormat.getDateInstance();
			System.out
					.println("The difference between "
							+ dateFormat.format(startDate) + " and "
							+ dateFormat.format(endDate) + " is " + diffDays
							+ " days.");

			if (diffDays <= 2)
				return true;
			return false;
		}
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public ArrayList<Product> getStoreProducts() {
		// TODO Auto-generated method stub
		return myStore.getProducts();
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", customerName=" + customerName + ", sum="
				+ sum + ", productsInCart=" + productsInCart + ", myStore="
				+ myStore + "]";
	}

	public Store getMyStore() {
		return myStore;
	}
	public Set<Product> getProductsInCart() {
		return productsInCart;
	}

}
