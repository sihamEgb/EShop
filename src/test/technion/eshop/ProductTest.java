package technion.eshop;

import static org.junit.Assert.*;

import org.junit.Test;

import technion.eshop.entities.Product;

public class ProductTest {

	@Test
	public final void testProduct() {
		//Product(String name, String brand, Integer price, Integer day, Integer month,Integer year)
		Product p = new Product("Bamba", "Aosem", 5, 5, 9,2015);
		assertEquals("Bamba",p.getName());
		assertEquals("Aosem",p.getBrand());
		assertEquals(5,p.getDay().intValue());
		assertEquals(9,p.getMonth().intValue());
		assertEquals(2015,p.getYear().intValue());
		assertEquals(5,p.getPrice().intValue());
	    p = new Product("Bisly", "Aosem", 6, 11, 3,2015);
		assertEquals("Bisly",p.getName());
		assertEquals("Aosem",p.getBrand());
		assertEquals(11,p.getDay().intValue());
		assertEquals(3,p.getMonth().intValue());
		assertEquals(2015,p.getYear().intValue());
		assertEquals(6,p.getPrice().intValue());
	}

	@Test
	public final void testSetPrice() {
		Product p = new Product("Bamba", "Aosem", 5, 5, 9,2015);
		p.setPrice(3);
		assertEquals(3,p.getPrice().intValue());
		p = new Product("Bamba", "Aosem", 5, 5, 9,2012);
		p.setPrice(20);
		assertEquals(20,p.getPrice().intValue());
	}

	@Test
	public final void testSetId() {
		Product p = new Product("Bamba", "Aosem", 5, 5, 9,2015);
		p.setId("3sdfsdf");
		assertEquals(true, (p.getId()).equals("3sdfsdf"));
		p = new Product("Bamba", "Aosem", 5, 5, 9,2012);
		p.setId("34354353sdfsdf");
		assertEquals(true, (p.getId()).equals("34354353sdfsdf"));	
	}

	@Test
	public final void testSetName() {
		Product p = new Product("Bamba", "Aosem", 5, 5, 9,2015);
		p.setName("Milk");
		assertEquals(true, (p.getName()).equals("Milk"));
		p = new Product("Bamba", "Aosem", 5, 5, 9,2012);
		p.setName("Milki");
		assertEquals(true, (p.getName()).equals("Milki"));	
	}

	@Test
	public final void testSetDay() {
		Product p = new Product("Bamba", "Aosem", 5, 5, 9,2015);
		p.setDay(18);
		assertEquals(18,p.getDay().intValue());
		p.setDay(99);
		assertEquals(18,p.getDay().intValue());
		p = new Product("Bamba", "Aosem", 5, 5, 9,2012);
		p.setDay(68);
		assertEquals(5,p.getDay().intValue());
		p.setDay(6);
		assertEquals(6,p.getDay().intValue());
	}

	@Test
	public final void testSetMonth() {
		Product p = new Product("Bamba", "Aosem", 5, 5, 9,2015);
		p.setMonth(1);
		assertEquals(1,p.getMonth().intValue());
		p.setMonth(10);
		assertEquals(10,p.getMonth().intValue());
		p.setMonth(-11);
		assertEquals(10,p.getMonth().intValue());
		p.setMonth(12);
		assertEquals(12,p.getMonth().intValue());
		p.setMonth(0);
		assertEquals(12,p.getMonth().intValue());
		p.setMonth(14);
		assertEquals(12,p.getMonth().intValue());
	}

	@Test
	public final void testSetYear() {
		Product p = new Product("Bamba", "Aosem", 5, 5, 9,2015);
		p.setYear(1);
		assertEquals(1,p.getYear().intValue());
		p.setYear(-2010);
		assertEquals(1,p.getYear().intValue());
		p.setYear(134543535);
		assertEquals(134543535,p.getYear().intValue());
	}

	@Test
	public final void testEqualsObject() {
		Product p1 = new Product("Milk", "Tnova", 12, 1, 2,2016);
		Product p2 = new Product("Milk", "Tnova", 12, 1, 2,2016);
		assertEquals(false,p1.equals(p2));
		assertEquals(true,p1.equals(p1));
		
		p1 = new Product("Milk", "Tnova", 12, 1, 2,2016);
		p2 = new Product("Milki", "Tnova", 12, 1, 2,2016);
		assertEquals(false,p1.equals(p2));

		p1 = new Product("Milk", "Tnova", 12, 1, 2,2014);
		p2 = new Product("Milki", "Tnova", 12, 1, 2,2013);
		assertEquals(false,p1.equals(p2));
	}

	@Test
	public final void testToString() {
		String name = "Milki";
		String brand = "Tnova";
		int price = 7 ; 
		int day = 9; 
		int month = 12;
		int year = 2014;
		Product p = new Product(name, brand, price, day, month , year);
		String s = name + " from" + brand+ " price: " + price + ", expiration date: " + day + "/"
				+ month + "/" + year;
		assertEquals(true,s.equals(p.toString()));
	}
}
