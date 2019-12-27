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

public class UpdateServlet extends HttpServlet
{
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
     {
    	  PrintWriter out =resp.getWriter();
 		  resp.setContentType("text/html");
 		  
 		 long phone =Long.parseLong(req.getParameter("phone"));
 		 String new_pass =req.getParameter("new");
 		 String old_pass =req.getParameter("old");
 		 
 		
 		
 		Connection con =null;
 		PreparedStatement pstmt = null;
 		
 		try
 		{
 			  Class.forName("com.mysql.cj.jdbc.Driver");
 			   
 			   String url = "jdbc:mysql://localhost:3306/CapSample?user=root&password=root";
 			   con=DriverManager.getConnection(url);
 			   
 			   
 			   String query = "update Form_Table set password=? where password=? and phone_no=?";
 			   pstmt = con.prepareStatement(query);
 			   pstmt.setString(1,new_pass);
 			   pstmt.setString(2,old_pass);
 			   pstmt.setLong(3, phone);
 			   
 			    
 			   int count=pstmt.executeUpdate();
 			   if(count>0)
 			   {
 				   out.print("<h1>"+"Data Updated Sucessfully"+"</h1>");
 			   }
 			   else 
 			   {
 				   out.print("<h1>"+"Data Not Updated "+"</h1>"); 
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
