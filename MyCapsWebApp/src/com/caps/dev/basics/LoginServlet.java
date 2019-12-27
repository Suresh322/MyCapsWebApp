package com.caps.dev.basics;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet
{
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
	{
		String username =req.getParameter("name");
		String password =req.getParameter("password");
		
		PrintWriter out =resp.getWriter();
		
		resp.setContentType("text/html");
		
		
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		try
		{
			  Class.forName("com.mysql.cj.jdbc.Driver");
			   
			   String url = "jdbc:mysql://localhost:3306/CapSample?user=root&password=root";
			   con=DriverManager.getConnection(url);
			   
			   
			   String query = "select * from Form_Table where name=? and password=?";
			   pstmt = con.prepareStatement(query);
			   pstmt.setString(1, username);
			   pstmt.setString(2,password);
			   
			   rs=pstmt.executeQuery();
			  
			   if(rs.next())
			   {  
				   HttpSession s = req.getSession();
				   resp.sendRedirect("./Homepage.html");
				  /* long number =rs.getInt("phone_no");
				    String name   =req.getParameter("name");
					String email =req.getParameter("email");
					String pass =req.getParameter("pass");
					String gender =req.getParameter("gen");
					
					out.print("<h2>"+name+"</h2>");
					out.print("<h2>"+number+"</h2>");
					out.print("<h2>"+email+"</h2>");
					out.print("<h2>"+pass+"</h2>");
					out.print("<h2>"+gender+"</h2>"); */
			   }
			   else 
			   {
				   resp.sendRedirect("./Login.html");
				  //out.print("<h1>"+"Entered Entities Are Not Present"+"</h1>");
			   }
			   
			   
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.print("<h1>"+"Something went Wrong"+"</h1>");
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
			  if(rs!=null)
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
