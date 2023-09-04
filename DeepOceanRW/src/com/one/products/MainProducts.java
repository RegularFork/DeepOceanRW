package com.one.products;

import com.one.products.goods.*;
//import com.one.products.goods.ProductService;

public class MainProducts {
	public static void main (String[] args) {
		System.out.println("=====  Hello!  =====\n");
		ProductService.getDefaultProductList();
		for (Product<?> p : ProductService.productList) {
			System.out.println(p);
		}
		ProductService.addProduct();
		for (Product<?> p : ProductService.productList) {
			System.out.println(p);
		}
		
	}

}
