package technion.eshop.entities;

import java.awt.Component;
import java.util.HashSet;
import java.util.Set;

public class Report {

	Set<Shipment> myShipments;
	Set<Cart> myCarts;
	Integer[] week; // every day in the week traffic report
	Integer[] day; // every hour in the day traffic report

	Set<String> products;

	public Report() {
		myShipments = new HashSet<Shipment>();
		myCarts = new HashSet<Cart>();

		week = new Integer[7];
		day = new Integer[24];
	}

	public void addBill(Cart c) {
		myCarts.add(c);

	}

	public void addShipment(Shipment s) {
		myShipments.add(s);
	}

	public void getProductsStat() {

	}

	public void getWeeklyStat() {

	}

	public void getDailyStat() {

	}

	// TODO return shipments statisci
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
					System.out.println("the address found is"
							+ s.getAddress());

					return s.getAddress();
				}

		return "";
	}

}
