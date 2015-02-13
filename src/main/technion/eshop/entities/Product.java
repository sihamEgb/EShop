package technion.eshop.entities;

import com.google.gson.Gson;

public class Product {

	private String id;
	private String name;
	private String brand;
	private Integer price;

	private Integer day;
	private Integer month;
	private Integer year;

	private static Integer idGenerator = 1;

	public Product(String name, String brand, Integer price, Integer day, Integer month,
			Integer year) {

		this.name = name;
		this.brand = brand;
		this.price = price;
		this.day = day;
		this.month = month;
		this.year = year;

		id = idGenerator.toString();
		idGenerator++;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name + " from" + brand+ " price: " + price + ", expiration date: " + day + "/"
				+ month + "/" + year;
	}

	public String toJson() {
		Gson gson = new Gson();
		String json = gson.toJson(this);
		return json;
	}

	public static Product constructFromJson(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, Product.class);
	}

}
