package com.caps.dev.dto;
import com.caps.dev.dto.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Attribute")
public class AttributeTest extends HttpServlet
{
	 protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	    {
	    	resp.setContentType("text/html");
	    	PrintWriter out = resp.getWriter();
	    	
	    	Employee e = (Employee)req.getAttribute("employee");
	    	
	    	out.print("<h1>"+new Date()+"</h1>");
	    	
	    } 
}
