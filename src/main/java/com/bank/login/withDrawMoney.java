package com.bank.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.bank.dbconnections.DBoperations;

public class withDrawMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(withDrawMoney.class);
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession s=req.getSession();
        int id=(int) s.getAttribute("id");
		long withdraw=Integer.parseInt(req.getParameter("withdraw"));
		log.warn("customer withdraw method started");
		DBoperations db= new DBoperations();
		db.wthdrawMoney(id, withdraw);
		PrintWriter out= out=res.getWriter();
		 out.println("<html>"+
				  "<center>"+
				  "<body style= background-color:#33CCFF\r\n"
				  + "; text-align:center;>"+
				  "<h2 >money withdrawed sucessfully</h2>"+
				  "<body>"+
				  "</center>"+
						 "</html>" );
		log.warn("customer withdraw method ended");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
