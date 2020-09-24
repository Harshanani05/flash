package com.dxc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dxc.entities.Product;

public class ProductDAOImp implements IProductDAO {
	Connection conn;
	public ProductDAOImp() {
		conn =DBUtil.getDbConnection();
	}
	@Override
	public int addProduct(Product p) {
		String insertQuery = "insert into product values(?,?,?,current_date)";
		int n=0;
		try {
			PreparedStatement pst=conn.prepareStatement(insertQuery);
			
			pst.setInt(1,p.getPid());
			pst.setString(2,p.getPname());
			pst.setDouble(3, p.getPrice());

			
			n=pst.executeUpdate(); 
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return n;
		
	
	}

	@Override
	public int updateProduct(Product p) {
		// TODO Auto-generated method stub
		String updateQuery = "update product set pname=?,price=?,dop=current_date where pid=?";
		int n=0;
		try {
			PreparedStatement pst=conn.prepareStatement(updateQuery);
			
			pst.setString(1,p.getPname());
			pst.setDouble(2, p.getPrice());
			pst.setInt(3,p.getPid());
			
			n=pst.executeUpdate(); 
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return n;
	}

	@Override
	public int deleteProduct(int pid) {
		int n=0;
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst=conn.prepareStatement("delete from product where pid=?");
			pst.setInt(1,pid);
			n=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public Product getOneProduct(int pid){
		// TODO Auto-generated method stub
		String selectQuery="select *from product where pid=?";
		Product product = null;
		try {
			PreparedStatement pst=conn.prepareStatement(selectQuery);
			pst.setInt(1, pid);
			ResultSet rs=pst.executeQuery();
			
				rs.next();
				
			int pid1=rs.getInt("pid");
			String pname=rs.getString("pname");
			double price=rs.getDouble("price");
			Date dop=rs.getDate("dop"); 
			
			product.setPid(pid1);
			product.setPname(pname);
			product.setPrice(price);
			product.setDop(dop);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	@Override
	public List<Product> getAllProduct() {
		
		List<Product> list= new ArrayList<Product>();
		
		String selectall="select *from product";
		try {
			PreparedStatement pst =conn.prepareStatement(selectall);
			ResultSet rs=pst.executeQuery();
			while (rs.next()) {
				
				Product product=new Product();
				product.setPid(rs.getInt("pid"));
				product.setPname(rs.getString("pname"));
				product.setPrice(rs.getDouble("price"));
				product.setDop(rs.getDate("dop"));
				
				list.add(product);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
