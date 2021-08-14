package com.bank.employee;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.dbconnections.DBoperations;
import com.customer.model.Customer;

public class VeiwCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out= res.getWriter();
		DBoperations db=new DBoperations();
		List<Customer> custList=db.getCustomer();
		 
		 out.println("<table id=\"customers\">");  
         out.println("<tr><th>CustomerId</th><th>CustomerName</th><th>customerAdhaarNo</th><th>customerMobileNo</th><tr>");  
         
		for(int i=0;i<custList.size();i++) {
			int cAccountNo=custList.get(i).getId();
			String cName=custList.get(i).getName();
			long cAdhaarNo=custList.get(i).getAdhaarNo();
			long cMobileNo=custList.get(i).getMobileNo();
			
			out.println("<tr><td>" + cAccountNo+ "</td><td>" + cName + "</td><td>" + cAdhaarNo + "</td><td>"+ cMobileNo+ "</td></tr>"); 
			
		}
		
		  
		  
		  
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
