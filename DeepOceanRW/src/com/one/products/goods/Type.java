package com.one.products.goods;

public enum Type {
	PIECES("Pieces"),
	PACKAGES("Packages"),
	MASS("kg"),
	LITRES("L"),
	EMPTY("not present");
	
	private String name;

	private Type(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	

}
