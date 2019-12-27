package com.caps.dev.basics;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sample")
public class SampleServlet  extends HttpServlet
{
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
    {

    	resp.setContentType("text/html");
    	RequestDispatcher dis = req.getRequestDispatcher("/forward");
    	dis.forward(req, resp);
    }
}

