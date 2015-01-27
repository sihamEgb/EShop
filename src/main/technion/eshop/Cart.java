package technion.eshop;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cart {

	private String customerName;
	private Integer sum;
	private Set<Product> productsInCart;

	// TODO delete,,,
	public Cart() {

	}

	private Cart(String name) {
		this.customerName = name;
		this.sum = 0;
		this.productsInCart = new HashSet<Product>();
	}

	// TODO up to 8 chars ...is 0 allowed?
	public static Cart init(String name) throws Exception {

		Pattern p = Pattern.compile("[a-zA-Z0-9]*");
		Matcher m = p.matcher(name);
		boolean b = m.matches();

		if ((name.length() == 8) && (b == true)) {
			Cart cart = new Cart(name);
			return cart;
		}
		throw new Exception("choose another name");
	}

	public void addProduct(Product p) {

		if (isDateBad(p.getYear(), p.getMonth(), p.getDay()) == true) {
			// TODO bleep

		}

		// if (p.getDate() - getDate() < 2)
		sum = sum + p.getPrice();
		productsInCart.add(p);

	}

	public void removeProduct(Product p) {
		sum = sum - p.getPrice();
		productsInCart.remove(p);

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
}
