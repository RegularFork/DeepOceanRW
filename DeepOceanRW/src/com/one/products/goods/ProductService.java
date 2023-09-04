package com.one.products.goods;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ProductService {
	@SuppressWarnings("rawtypes")
	public static List<Product>productList = new ArrayList<>();
	public static final String FILE_PATH = "../cars2.txt";
	public static final String FILE_READ_PATH = "../products.txt";
	
	@SuppressWarnings("unchecked")
	public static void getDefaultProductList() {
		Product <Bread>p1 = new Bread("Regular Bread", Type.PIECES);
		Product<Bread> p2 = new Milk("Regular Milk", Type.LITRES);
		Product<Bread> p3 = new Rice("Regular Rice", Type.MASS);
		productList.add(p1);
		productList.add(p2);
		productList.add(p3);
	}
	
	// Add Product from user input
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
	
	// Add product at file end
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
	
	// Write Product List To File
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
	
	// Get Product List from String
	public static List<Product> readProductsString(String inputString){
		inputString = inputString.replace(',', '.');
		String[] products;
		String[] productsDetailed;
		List<Product> prodList = new ArrayList<>();
			Pattern pattern = Pattern.compile("\\n");
			products = pattern.split(inputString);
			pattern = Pattern.compile(";");
			for (String str : products) {
				productsDetailed = pattern.split(str);
				String whichType = productsDetailed[3];
				System.out.println(whichType);
					switch (whichType) {
					case "Pieces":
						prodList.add(new Bread(productsDetailed[0], Double.parseDouble(productsDetailed[1]), Double.parseDouble(productsDetailed[2]), Type.PIECES));
						break;
					case "kg":
						prodList.add(new Rice(productsDetailed[0], Double.parseDouble(productsDetailed[1]), Double.parseDouble(productsDetailed[2]), Type.MASS));
						break;
					case "L":
						prodList.add(new Milk(productsDetailed[0], Double.parseDouble(productsDetailed[1]), Double.parseDouble(productsDetailed[2]), Type.LITRES));
						break;
					}
			}
		return prodList;
	}
	
	// Get String List from File
	public static String getStringFromFile(String path) {
		String result = "";
		try (FileReader reader = new FileReader(path)){
			int c;
			while((c=reader.read())!=-1) {
				result += (char)c;
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println(result);
		return result;
	}
}
