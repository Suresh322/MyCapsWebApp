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
import javax.servlet.http.HttpSession;

public class CreateServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
	{
           
		HttpSession s = req.getSession(false);
		if(s!=null)
	  {
		String name =req.getParameter("name");
		String email =req.getParameter("email");
		String phone =req.getParameter("phn");
		String password =req.getParameter("pass");
		String gender =req.getParameter("gen");
		
		long num=Long.parseLong(phone);
		
		PrintWriter out =resp.getWriter();
		resp.setContentType("text/html");
		
		
		Connection con =null;
		PreparedStatement pstmt = null;
		
		try
		{
			  Class.forName("com.mysql.cj.jdbc.Driver");
			   
			   String url = "jdbc:mysql://localhost:3306/CapSample?user=root&password=root";
			   con=DriverManager.getConnection(url);
			   
			   
			   String query = "insert into Form_Table values(?,?,?,?,?)";
			   pstmt = con.prepareStatement(query);
			   pstmt.setString(1, name);
			   pstmt.setString(2,email);
			   pstmt.setLong(3,num);
			   pstmt.setString(4, password);
			   pstmt.setString(5, gender);
			    
			   int count=pstmt.executeUpdate();
			   if(count>0)
			   {
				   out.print("<h1>"+"Data Added Sucessfully"+"</h1>");
			   }
			   else 
			   {
				   out.print("<h1>"+"Data Not Added Sucessfully"+"</h1>"); 
			   }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
		else
		{
			resp.sendRedirect("./Login.html");
		}
		
	
		
	}
}
