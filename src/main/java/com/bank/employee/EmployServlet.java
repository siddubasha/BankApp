package com.bank.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bank.dbconnections.DBoperations;
import com.bank.utils.HibernateUtils;
import com.customer.model.Customer;
import com.employee.model.Employee;

public class EmployServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		int id=Integer.parseInt(req.getParameter("id"));
		Session session=null;
		Transaction transaction=null;
		Employee emp=null;
		PrintWriter out= out=res.getWriter();
		HttpSession s=req.getSession();
		try {
			session=HibernateUtils.getSessionFactory().openSession();
			transaction= session.beginTransaction();
			emp=session.get(Employee.class,id);

			if(emp.getName().equals(name)&&emp.getPassword().equals(password)) {


				RequestDispatcher rd=req.getRequestDispatcher("EmployeeOperations.html");
				rd.include(req, res);
//				res.sendRedirect("get");
//				res.sendRedirect("with");
//				res.sendRedirect("deposit");



			}
			else {
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
