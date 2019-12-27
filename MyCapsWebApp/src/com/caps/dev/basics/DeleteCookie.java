package com.caps.dev.basics;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/deletecookie")
public class DeleteCookie extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		resp.setContentType("text/html");
		PrintWriter out =resp.getWriter();
		
		
		Cookie[]coookie =req.getCookies();
		
		for(Cookie c:coookie)
		{
			if(c.getName().equals("name"))
			{
				c.setMaxAge(0);
				resp.addCookie(c);
			}
		}
		
		
	}
   
}

