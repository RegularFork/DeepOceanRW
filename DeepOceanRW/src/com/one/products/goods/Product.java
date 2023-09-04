package com.one.products.goods;


public class Product<T> {
	
	private String name;
	private T type;
	private double price = 0;;
	private double quantity = 0;;
	
	public Product(String name, T type) {
		this.name = name;
		this.type = type;
	}
	
	
	
	public Product(String name, double price, double quantity, T type) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public T getType() {
		return type;
	}
	@Override
	public String toString() {
		return String.format("Product name: %s and it's measured by %s\n", name, ((Type) type).getName());
	}
	public String getStringProductInfo() {
		return String.format("%s;%.2f;%.2f;%s", name, price, quantity,((Type) type).getName());
	}
	
}
