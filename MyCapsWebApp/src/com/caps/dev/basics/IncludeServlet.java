package com.caps.dev.basics;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/include")
public class IncludeServlet  extends HttpServlet
{
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
    {
    	
    	resp.setContentType("text/html");
    	RequestDispatcher dis = req.getRequestDispatcher("/forward");
    	dis.include(req, resp);
    	
    	PrintWriter out = resp.getWriter();
    	out.print("<h1>"+"HAPPY UGADI"+"</h1>");
    }
}
