package com.one.products.goods;

public class Bread extends Product{

	public Bread(String name, Type type) {
		super(name, type);
	}

	@SuppressWarnings("unchecked")
	public Bread(String name, double price, double quantity, Type type) {
		super(name, price, quantity, type);
		// TODO Auto-generated constructor stub
	}

	
	

}
