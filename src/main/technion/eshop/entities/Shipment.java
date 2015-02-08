package technion.eshop.entities;

import java.util.HashSet;
import java.util.Set;

public class Shipment {
	private String id;
	private String address;
	private Set<Box> shipmentBoxes;
	private static Integer idGenerator = 1;

	public Shipment(String myAddress) {
		address = myAddress;
		id = idGenerator.toString();
		idGenerator++;
		shipmentBoxes = new HashSet<Box>();
	}

	// TODO
	public void addBox() {
		Box myBox = new Box(id);
		shipmentBoxes.add(myBox);
		// new Box
	}

}
