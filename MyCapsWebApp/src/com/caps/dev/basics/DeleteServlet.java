package com.caps.dev.basics;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet  
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		 PrintWriter out =resp.getWriter();
		  resp.setContentType("text/html");
		  
		 long phone =Long.parseLong(req.getParameter("phone"));
		 String password =req.getParameter("password");
		 
		
		
		Connection con =null;
		PreparedStatement pstmt = null;
		
		try
		{
			  Class.forName("com.mysql.cj.jdbc.Driver");
			   
			   String url = "jdbc:mysql://localhost:3306/CapSample?user=root&password=root";
			   con=DriverManager.getConnection(url);
			   
			   
			   String query = "delete from  Form_Table where phone_no=? and password=? ";
			   pstmt = con.prepareStatement(query);
			  
			   pstmt.setString(2,password);
			   pstmt.setLong(1, phone);
			   
			    
			   int count=pstmt.executeUpdate();
			   if(count>0)
			   {
				   out.print("<h1>"+"Data Deleted Sucessfully"+"</h1>");
			   }
			   else 
			   {
				   out.print("<h1>"+"Data Not Deleted "+"</h1>"); 
			   }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Something Fuked Your Program");
		}
		finally 
		{
			 if(con!=null)
			 {
				  try 
				  {
					con.close();
				   } 
				  catch (SQLException e) 
				  {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
			 }
			  if(pstmt!=null)
			  {
				  try 
				 {
					con.close();
				 } 
				  catch (SQLException e) 
				  {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
				   
			  }
			 
			  
			  
		  }
			
		
		
	}

}
