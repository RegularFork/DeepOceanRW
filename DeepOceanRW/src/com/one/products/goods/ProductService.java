package com.one.products.goods;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {
	@SuppressWarnings("rawtypes")
	public static List<Product>productList = new ArrayList<>();
	public static final String FILE_PATH = "../cars2.txt";
	
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
	public static void writeProductToFile(Product<?>product, String path) {
		try(FileWriter fileWriter = new FileWriter(path, true)){
			String str = product.getStringProductInfo();
			fileWriter.write(str);
			fileWriter.append('\n');
			System.out.println("File created!");
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public static void writeAllProductsToFile() {
		try (FileWriter fileWriter = new FileWriter(FILE_PATH)){
			fileWriter.write("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Product<?> prod : productList) {
			writeProductToFile(prod, FILE_PATH);
		}
	}
	public static List<Product> readProductsFromFile(String path){
		List<Product> prodList = new ArrayList<>();
		
		return prodList;
	}
}
