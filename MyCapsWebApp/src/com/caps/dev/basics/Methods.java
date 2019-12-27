package com.caps.dev.basics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


	
	public class Methods extends HttpServlet
	{ 
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException 
		{
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.print("<h1><Center>"+"CapGemini-Army"+"</h1></Center>");
			
			String name = req.getParameter("name");
			
			String method = req.getMethod();
			System.out.println(method);
			
			StringBuffer url = req.getRequestURL();
			System.out.println(url);
			
			String protocol= req.getProtocol();
			System.out.println(protocol);
			
			String [] a =req.getParameterValues(null);
			
			
			
			
		}

	}
