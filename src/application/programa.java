package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Produto;
import entities.enums.OrderStatus;

public class programa {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Scanner scD=new Scanner(System.in);
		Scanner sc=new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		
		
		System.out.println("Enter client data:");
		System.out.println("Name: ");
		String name=sc.nextLine();
		System.out.println("Email: ");
		String email=sc.next();
		System.out.println("Birth date (DD/MM/YYYY): ");
		Date birthdate=sdf.parse(sc.next());
		
		Client client=new Client(name,email,birthdate);
		
		System.out.println("Enter order data: ");
		System.out.println("status: ");
		OrderStatus status=OrderStatus.valueOf(sc.next());
		
		Order order=new Order(new Date(),status,client);
		
		System.out.println("how many items to this order?");
		int N=sc.nextInt();
		
		for(int i=1;i<=N;i++) {
			System.out.println("Enter #" + i +" item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName=sc.nextLine();
			System.out.print("product price: ");
			double productPrice=scD.nextDouble();
			System.out.print("Quantity: ");
			int quantity=sc.nextInt();
			
			Produto product=new Produto(productName,productPrice);
			
			OrderItem it=new OrderItem(quantity,productPrice,product);
			
			order.addItem(it);
			
			}
		System.out.println();
		System.out.println(order);
		
		sc.close();
		scD.close();
		
		

	}

}
