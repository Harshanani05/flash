package com.dxc.ui;


import java.util.List;
import java.util.Scanner;

import com.dxc.dao.IProductDAO;
import com.dxc.dao.ProductDAOImp;
import com.dxc.entities.Product;

public class User {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		IProductDAO pd = new ProductDAOImp();
		
		Scanner s=new Scanner(System.in);
		
		do {
			
		
		System.out.println("welcome to product system");
		System.out.println("1.add product");
		System.out.println("2.update product");
		System.out.println("3.delete by pid");
		System.out.println("4.select pid");
		System.out.println("5.select all products");
		System.out.println("6.exit");
		
		int choice = s.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("enter product id");
			int pid=s.nextInt();

			s.nextLine();
			System.out.println("enter name");
			String pname=s.nextLine();
			
			System.out.println("enter price");
			double price=s.nextDouble();
			
			Product p=new Product();
			
			p.setPid(pid);
			p.setPname(pname);
			p.setPrice(price);
			
			int count=pd.addProduct(p);
			if(count>0) {
				System.out.println(count+" record inserted...");
			}
			else {
				System.out.println("insert failed");
			}
			break;
		case 2:
			
			System.out.println("enter product id");
			int pid1=s.nextInt();
			
			s.nextLine();
			System.out.println("enter name");
			String pname1=s.nextLine();
			
			System.out.println("enter price");
			double price1=s.nextDouble();
			
			Product p1=new Product();
			
			p1.setPid(pid1);
			p1.setPname(pname1);
			p1.setPrice(price1);
			
			int count1=pd.updateProduct(p1);
			if(count1>0) {
				System.out.println(count1+" record inserted...");
			}
			else {
				System.out.println("insert failed");
			}
			break;
	
		case 3:
			System.out.println("enter pid");
			int pid3=s.nextInt();
			int count3=pd.deleteProduct(pid3);
			
			if(count3>0) {
				System.out.println(count3+" record deleted...");
			}
			else {
				System.out.println("insert failed");
			}
			
			break;
	
		case 4:
			System.out.println("enter pid ");
			int pid4=s.nextInt();
			
			Product count4=pd.getOneProduct(pid4);
			
			if(count4 != null)
			{
				System.out.println("success");
				System.out.println(count4);
			}
			else {
				System.err.println("select fail");
			}
			
			break;
		case 5:
			List<Product> productList=pd.getAllProduct();
			for(Product pro: productList) {
				System.out.println(pro);
			}
			
			break;
		case 6:
			System.exit(0);
		default:
			break;
		}
		
		}while(true);
		
	}
}
