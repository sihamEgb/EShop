package technion.eshop.entities;

import java.awt.Toolkit;
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
			System.out.println("pay attention to expiration date");
			Toolkit.getDefaultToolkit().beep();
			// TODO bleep + remove product from store/stock
            return;
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
	 * is the product more than two days expired
	 */
	public boolean isDateBad(Integer year, Integer month, Integer day) {
		{
			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			
			Calendar now = Calendar.getInstance();   // Gets the current date and time
			
			start.set(Calendar.DAY_OF_MONTH, now.get(Calendar.DAY_OF_MONTH));
			start.set(Calendar.YEAR, now.get(Calendar.YEAR));
			start.set(Calendar.MONTH, now.get(Calendar.MONTH));

			end.set(Calendar.DAY_OF_MONTH, day);
			end.set(Calendar.YEAR, year);
			end.set(Calendar.MONTH, month-1);

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

			if (diffDays <= -2)
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

	public String getCartId(){
		return id;
	}
}
