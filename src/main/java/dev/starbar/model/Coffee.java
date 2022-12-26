package dev.starbar.model;

public class Coffee {
	private int id;
	private String name;
	private String size;
	private int price;
	
	
	public Coffee(int id, String name, String size, int price) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.price = price;
	}
	
	public Coffee(String name, String size, int price) {
		super();
		this.name = name;
		this.size = size;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSize() {
		return size;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Coffee [id=" + id + ", name=" + name + ", size=" + size + ", price=" + price + "]";
	}

	
	
}
