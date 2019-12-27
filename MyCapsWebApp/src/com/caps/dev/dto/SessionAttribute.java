package com.caps.dev.dto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionattribute")
public class SessionAttribute extends HttpServlet
{
	 protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	    {
	    	Employee e = new Employee();
	    	e.setE_name("CSK");
	    	e.setEmp_id(442);
	    	e.setRoll("Developer");
	    	
	    	HttpSession session = req.getSession(true);
	    	session.setAttribute("Employee", e);
	    	System.out.println("Attribute Set");
	    	
	    	
	    	
	    	
	    	
	   } 

}