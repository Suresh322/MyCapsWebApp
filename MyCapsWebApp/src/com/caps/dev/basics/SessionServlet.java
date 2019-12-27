package com.caps.dev.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/sessionserv")
public class SessionServlet extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
	{
	
		PrintWriter out =resp.getWriter();
		
		resp.setContentType("text/html");
		
		HttpSession s = req.getSession();
		
		out.print("<h1>"+"Session Created"+"</h1>");
		
		
	}
}