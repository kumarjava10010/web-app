package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.service.CalculatorService;

public class CalculatorServlet extends HttpServlet{
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String str1 = req.getParameter("a");
		
		String str2 = req.getParameter("b");
		
		CalculatorService service = new CalculatorService();
		
		int results = service.add(Integer.valueOf(str1), Integer.valueOf(str2));
		
		PrintWriter out = res.getWriter();
		out.println(results);

		
		
	}

}
