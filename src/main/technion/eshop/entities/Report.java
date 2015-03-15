package technion.eshop.entities;

import java.util.HashSet;
import java.util.Set;

public class Report {

	Set<Shipment> myShipments;
	Integer[] week; // every day in the week traffic report
	Integer[] day; // every hour in the day traffic report

	public Report() {
		myShipments = new HashSet<Shipment>();
		week = new Integer[7];
		day = new Integer[24];

	}

	// TODO
	public void addBill() {

	}

	// TODO
	public void addShipment() {

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

}
