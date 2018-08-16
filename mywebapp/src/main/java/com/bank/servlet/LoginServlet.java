package com.bank.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet  extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String userName=request.getParameter("userName");  
	    String password=request.getParameter("password");  
	    
	    
	          
	    if(userName.equals(password)){  
	    	System.out.println("Log IN success "+userName);
	    	//request.getSession().setAttribute("LoggedInUser", userName);
	    	
	    	request.setAttribute("LoggedInUser", userName);
	    	
	        RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
	        
	        rd.forward(request,response);  
	    }  
	    else{  
	    	System.out.println("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
	        rd.include(request,response);  
	    }  
	          
	}

}
