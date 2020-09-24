package com.dxc.dao;

import java.util.List;

import com.dxc.entities.Product;

public interface IProductDAO
{
	public int addProduct(Product p);// insert intp product values(?,?,?,?)
	
	public int updateProduct(Product p);//update product set pname=?  where pid=?
	
	public int deleteProduct(int pid); //delete from product where pid=?
	
	public Product getOneProduct(int pid);//select *from product where pid=?
	
	public List<Product> getAllProduct();//select*from product
	
}
