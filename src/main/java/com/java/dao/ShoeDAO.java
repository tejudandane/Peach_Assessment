package com.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java.model.*;

public class ShoeDAO {	
	public static Connection getConnection() {
		Connection con=null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shoevendor","root","password");
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return con;
	}

	public static int save(Shoe u) {
		
		int status=0;
		try {
		Connection con = ShoeDAO.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into vendor values(?,?,?)");
		ps.setInt(1, u.getId());
		ps.setString(2, u.getName());
		ps.setString(3, u.getAddress());
		status=ps.executeUpdate();
		con.close();
		
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	
	public static List<Shoe> getShoeVendor(){  
		 List<Shoe> list=new ArrayList<Shoe>(); 
	      
	    try{  
	        Connection con=ShoeDAO.getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from vendor");   
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	Shoe s= new Shoe();
	            s.setId(rs.getInt(1));  
	            s.setName(rs.getString(2));  
	            s.setAddress(rs.getString(3));
	            list.add(s);
	           System.out.println(s);
	        }  
	        con.close();  
	    }catch(Exception ex){ex.printStackTrace();}  
	      
	    return list;  
	} 
	
	public static int getIds() {
		 Shoe s= new Shoe();
		 int count=0;
		   try{  
		        Connection con=ShoeDAO.getConnection();  
		        PreparedStatement ps=con.prepareStatement("select max(id) from vendor");   
		        ResultSet rs=ps.executeQuery();  
		        if(rs.next()){  
		        
		            count =rs.getInt(1)+1;
		          
		          
		        }  
		        con.close();  
		    }catch(Exception ex){ex.printStackTrace();}  
		      
		 return count;
	}

}
