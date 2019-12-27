package com.caps.dev.dto;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/request")
public class RequestAttribute extends HttpServlet
{
	 protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	    {
	    	Employee e = new Employee();
	    	e.setE_name("Suresh");
	    	e.setE_sal(15800);
	    	e.setEmp_id(442);
	    	e.setRoll("Developer");
	    	
	    	RequestDispatcher r = req.getRequestDispatcher("/attribute");
	    	r.forward(req, resp);
	    	 
	    	
	    	
	    	
	    	
	   } 

}
