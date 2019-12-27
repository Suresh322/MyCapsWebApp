package com.caps.dev.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/cookie")
public class CookieServlet  extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		resp.setContentType("text/html");
		PrintWriter out =resp.getWriter();
		
		Cookie cooki = new Cookie("name","suresh");
		resp.addCookie(cooki);
		
		Cookie cookie = new Cookie("cookiee","Dark-Fantancy");
		resp.addCookie(cookie);
		
		out.println("<h1>"+"Cookie Created Sucessfully"+"</h1>");
		
		
		
		
	}
   
}
