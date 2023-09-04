package com.one.products;

import java.util.*;

import com.one.products.goods.*;
//import com.one.products.goods.ProductService;

public class MainProducts {
	public static void main (String[] args) {
		System.out.println("=====  Hello!  =====\n");
		ProductService.getDefaultProductList();
		for (Product<?> p : ProductService.productList) {
			System.out.println(p);
		}
//		ProductService.addProduct();
		for (Product<?> p : ProductService.productList) {
			System.out.println(p.getStringProductInfo());
			System.out.println(p);
		}
		
		ProductService.writeAllProductsToFile();
		List<Product> productList = new ArrayList<>();
		String str = ProductService.getStringFromFile(ProductService.FILE_READ_PATH);
		productList = ProductService.readProductsString(str);
		for (Product<?> p : productList) {
			System.out.println(p.getStringProductInfo());
			System.out.println(p);
		}
		
	}

}
