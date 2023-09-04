package com.one.products.goods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {
	@SuppressWarnings("rawtypes")
	public static List<Product>productList = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	public static void getDefaultProductList() {
		Product <Bread>p1 = new Bread("Regular Bread", Type.PIECES);
		Product<Bread> p2 = new Milk("Regular Milk", Type.LITRES);
		Product<Bread> p3 = new Rice("Regular Rice", Type.MASS);
		productList.add(p1);
		productList.add(p2);
		productList.add(p3);
	}
	public static void addProduct() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose product type:\n 1. Bread\n 2. Milk\n 3. Rice\nInput number: ");
		int num = scanner.nextInt();
		switch (num) {
		case 1:
			System.out.println("Input bread name: ");
			productList.add(new Bread(scanner.nextLine(), Type.PIECES));
			break;
		case 2:
			System.out.println("Input milk name: ");
			String s = scanner.nextLine();
			s = scanner.nextLine();
			productList.add(new Milk(s, Type.PIECES));
			break;
		case 3:
			System.out.println("Input rice name: ");
			productList.add(new Rice(scanner.nextLine(), Type.PIECES));
			break;
		default:
			System.out.println("=====  Wrong input!  =====");
		}
		
	}
}
