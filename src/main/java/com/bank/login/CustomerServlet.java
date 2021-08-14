package com.bank.login;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bank.utils.HibernateUtils;
import com.customer.model.Customer;
import com.employee.model.Employee;


public class CustomerServlet extends HttpServlet {
	private static final Logger log=Logger.getLogger(CustomerServlet.class);
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name= req.getParameter("name");
		String password= req.getParameter("password");
		int id=Integer.parseInt(req.getParameter("id"));
		
		
		Session session=null;
		Transaction transaction=null;
		Customer cust=null;
		PrintWriter out= out=res.getWriter();
		HttpSession s=req.getSession();
		s.setAttribute("id",id);
		try {
			session=HibernateUtils.getSessionFactory().openSession();
			transaction= session.beginTransaction();
			cust=session.get(Customer.class,id);
			log.warn("customer name and password  verification is started");
			if(cust.getName().equals(name)&&cust.getPassword().equals(password)) {

				log.info("customer name and password verification is sucessful");
				RequestDispatcher rd=req.getRequestDispatcher("CustomerOperations.html");
				rd.include(req, res);
//				res.sendRedirect("get");
//				res.sendRedirect("with");
//				res.sendRedirect("deposit");



			}
			else {
				log.warn("customer name and password verification is sucessful");
				out.println("<h2 style=color:red; background-color:yellow;>invalid password</h2>");
			}
			transaction.commit();
		}
		catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
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
