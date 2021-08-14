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

public class TransferServlet extends HttpServlet {
	private static final Logger log=Logger.getLogger(TransferServlet.class);
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession s=req.getSession();
        int id=(int) s.getAttribute("id");
       int idN= Integer.parseInt(req.getParameter("idN"));
       long transfer= Integer.parseInt(req.getParameter("transfer"));
       log.warn("customer transfer money started");
       DBoperations db= new DBoperations();
	     db.transferMoney(id,idN,transfer);
	     PrintWriter out= out=res.getWriter();
	     out.println("<html>"+
				  "<center>"+
				  "<body style= background-color:#33CCFF\r\n"
				  + "; text-align:center;>"+
				  "<h2 >Money Transered Sucessfully</h2>"+
				  "<body>"+
				  "</center>"+
						 "</html>" );
		  log.warn("customer transfer money ended");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
