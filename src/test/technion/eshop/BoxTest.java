package technion.eshop;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import technion.eshop.entities.Box;
import technion.eshop.entities.Product;

public class BoxTest {

	@Test
	public final void testBox() {
		String shipmentId,productId;
		Box newBox = new Box("ewr324ew");
		int boxId = Integer.valueOf(newBox.toString());
		for(int i=boxId+1;i<=10;i++){
			shipmentId = String.valueOf(i);
			productId = String.valueOf(i);
			newBox = new Box(shipmentId);
			assertEquals(true,newBox.getShipmentId().equals(shipmentId));
			assertEquals(true,(newBox.toString()).equals(String.valueOf(productId)));
			assertEquals(newBox.getProducts().size(),0);
		}
	}

	@Test
	public final void testAddProduct() {
		Box box;
		Product product = new Product("Milk", "Tnova", 11, 1, 4,2015);
		Product product1 = new Product("Milk", "Tnova", 11, 1, 4,2015);
		Product product2 = new Product("Milki", "Tara", 9, 1, 4,2015);
		Product product3 = new Product("MilkShake", "Tara", 8, 1, 5,2015);
		Product product4 = new Product("MilkShake", "Tara", 8, 1, 8,2016);
		Product product5 = new Product("Bamba", "Aosem", 5, 4, 3,2016);
		//Case1 : add product to empty box (Expected result: adding the product successfully)
		box = new Box("1234");
		assertEquals(true,box.addProduct(product));
		assertEquals(true,box.getProducts().contains(product));
		assertEquals(1,box.getProducts().size());
		//Case2 : add product to a box with 3 items (Expected result: adding the product successfully)
		assertEquals(true,box.addProduct(product1));
		assertEquals(true,box.addProduct(product2));
		assertEquals(3,box.getProducts().size());
		assertEquals(true,box.getProducts().contains(product));
		assertEquals(true,box.getProducts().contains(product1));
		assertEquals(true,box.getProducts().contains(product2));
		//Case3 : add product to a full box (Expected result: adding the product fails)
		box.addProduct(product4);
		box.addProduct(product3);
		assertEquals(5,box.getProducts().size());
        assertEquals(false,box.addProduct(product5));
        assertEquals(5,box.getProducts().size());
		//Case4 : add the same product twice (Expected result: the product will not be added twice)
        box= new Box("3252354");
        assertEquals(true,box.addProduct(product));
        assertEquals(1,box.getProducts().size());
        assertEquals(true,box.addProduct(product));
        assertEquals(1,box.getProducts().size());
	}

	@Test
	public final void testToString() {
		Box box = new Box("435435s7n5es43");
		//System.out.println(box.toString());
		int boxId1 = Integer.valueOf(box.toString());
		for(int i=boxId1;i<=100;i++)
			box = new Box("435435s7n5es43");
		box = new Box("43543");
		//System.out.println(box.toString());
		assertEquals(true,(box.toString()).equals(String.valueOf(102)));
	}

	@Test
	public final void testGetShipmentId() {
		Box box = new Box("67872316875");
		assertEquals(true, box.getShipmentId().equals("67872316875"));
		box = new Box("316875");
		assertEquals(true, box.getShipmentId().equals("316875"));
		box = new Box("67872316875");
		assertEquals(true, box.getShipmentId().equals("67872316875"));
	}

	@Test
	public final void testGetProducts() {
		//Case1 : get products of an empty box
		Box emptyBox = new Box("776876");
		assertEquals(true,emptyBox.getProducts().isEmpty());
		
		//Case2 : get products of a full box 
		Box fullBox = new Box("323");
		Set<Product> products = new HashSet<Product>();
		for(int i=1;i<=5;i++){
			Product product = new Product("Milk", "Tnova", i, 1, i+1 ,2015);
			products.add(product);
			fullBox.addProduct(product);
		}
		assertEquals(5,fullBox.getProducts().size());
		for(Product p : products)
			assertEquals(true,fullBox.getProducts().contains(p));
		
		//Case3 : get products of a half empty box
		Box halfEmptyBox = new Box("323");
		products = new HashSet<Product>();
		for(int i=1;i<=3;i++){
			Product product = new Product("bisly", "Aosem", i*i, 1, i+3 ,2016);
			products.add(product);
			halfEmptyBox.addProduct(product);
		}
		assertEquals(3,halfEmptyBox.getProducts().size());
		for(Product p : products)
			assertEquals(true,halfEmptyBox.getProducts().contains(p));
	}

}
