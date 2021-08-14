package com.bank.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.dbconnections.DBoperations;


public class CheckBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		      int id=Integer.parseInt (req.getParameter("id"));
		      DBoperations db= new DBoperations();
				long money= db.getBalace(id);
				PrintWriter out= out=res.getWriter();
				 out.println("<html>"+
						  "<center>"+
						  "<body style= background-color:#33CCFF\r\n"
						  + "; text-align:center;>"+
						  "<h2 >Available Balance: "+money+"</h2>"+
						  "<body>"+
						  "</center>"+
								 "</html>" );
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
