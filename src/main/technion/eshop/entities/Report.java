package technion.eshop.entities;

import java.awt.Component;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Report {

	Set<Shipment> myShipments;
	Set<Cart> myCarts;

	int[] week; // every day in the week traffic report
	int[] day; // every hour in the day traffic report
	Map<String, Integer> productCount;

	// Set<String> products;

	public Report() {
		myShipments = new HashSet<Shipment>();
		myCarts = new HashSet<Cart>();
		productCount = new HashMap<String, Integer>();
		week = new int[7];
		day = new int[24];

		productCount.put("Bamba", 0);
		productCount.put("Milk", 0);
		productCount.put("Besly", 0);
		productCount.put("Cola", 0);
	}

	public void addBill(Cart c) {
		myCarts.add(c);
		for (Product p : c.getProductsInCart()) {
			System.out.println(p.getName());
			System.out.println(productCount.get(p.getName()));
			productCount.put(p.getName(), (productCount.get(p.getName()) + 1));
		}

		Calendar now = Calendar.getInstance(); // Gets the current date and

		//System.out.println("FFFFFFF");
		//System.out.println(now.get(Calendar.DAY_OF_WEEK));
		//System.out.println(now.get(Calendar.HOUR));
		
		week[now.get(Calendar.DAY_OF_WEEK)-1]++;
		day[now.get(Calendar.HOUR)]++;

	}

	public void addShipment(Shipment s) {
		myShipments.add(s);
	}

	// TODO return shipments statistic
	public void getShipmentStat() {

		System.out.println("shipment statisics are...");
	}

	public Set<Shipment> getMyShipments() {

		return myShipments;
	}

	public Integer getNumberOfBoxes() {
		Integer count = 0;
		for (Shipment s : myShipments)
			count += s.getBoxes().size();
		return count;
	}

	public Set<Box> getBoxes() {
		Set<Box> myBoxes = new HashSet<Box>();
		for (Shipment s : myShipments) {
			for (Box b : s.getBoxes()) {
				myBoxes.add(b);
			}
		}
		return myBoxes;
	}

	public String getShipmentAddressByBoxId(String id) {

		System.out.println("the id requested id" + id);

		for (Shipment s : myShipments)
			for (Box b : s.getBoxes())
				if (b.getId().equals(id)) {
					System.out.println("the address found is" + s.getAddress());

					return s.getAddress();
				}

		return "";
	}

	public Set<String> getProducts() {
		Set<String> products = new HashSet<String>();
		products.add("Bamba");
		products.add("Milk");
		products.add("Besly");
		products.add("Cola");

		return products;
	}

	public Set<String> getDays() {
		Set<String> days = new HashSet<String>();
		days.add("Sunday");
		days.add("Monday");
		days.add("Tuesday");
		days.add("Wednesday");
		days.add("Thursday");
		days.add("Friday");
		days.add("Saturday");

		return days;
	}

	public Set<String> getHours() {
		Set<String> hours = new HashSet<String>();

		for (Integer i = 1; i <= 24; i++)
			hours.add(i.toString());

		return hours;
	}

	public String getNumByDay(String day) {
		if (day.equals("Sunday"))
			return ((Integer)week[0]).toString();
		if (day.equals("Monday"))
			return ((Integer)week[1]).toString();
		if (day.equals("Tuesday"))
			return ((Integer)week[2]).toString();
		if (day.equals("Wednesday"))
			return ((Integer)week[3]).toString();
		if (day.equals("Thursday"))
			return ((Integer)week[4]).toString();
		if (day.equals("Friday"))
			return ((Integer)week[5]).toString();
		if (day.equals("Saturday"))
			return ((Integer)week[6]).toString();
		return null;
	}

	public String getNumByHour(String hourStr) {
		Integer hour = Integer.parseInt(hourStr);
		return  ((Integer)day[hour]).toString();
	}

	public String getNumByProduct(String productName) {
		return productCount.get(productName).toString();
	}

}
