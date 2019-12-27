package com.caps.dev.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QueryServ extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException 
	{
		String value1 = req.getParameter("fname");
		System.out.println(value1);
		String value2 = req.getParameter("lname");
		PrintWriter out = resp.getWriter();
		out.print("<h1>"+value1+"<h1>");
		out.print("<h2>"+value2+"<h2>");
		
		
		ServletConfig config = getServletConfig();
		ServletContext context = config.getServletContext();
		Object o = context.getInitParameter("name");
		
		String n = (String)o;
		
		out.print("<h1><Center>"+n+"</h1></Center>");
		
		String s = config.getInitParameter("name");
		
		out.print("<h1><Center>"+s+"</h1></Center>");
		
		
	}
}
