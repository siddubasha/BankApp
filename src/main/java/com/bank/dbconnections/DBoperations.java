package com.bank.dbconnections;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import org.hibernate.Transaction;

import com.bank.login.CustomerServlet;
import com.bank.utils.HibernateUtils;
import com.customer.model.Customer;
import com.employee.model.Employee;

/**
 * Hello world!
 *
 */
public class DBoperations 
{
	private static final Logger log=Logger.getLogger(DBoperations.class);
    public void addCustomer(Customer customer) {
    	Session session=null;
    	Transaction transaction=null;
    	log.info("customer registration method is started");
    	try {
    		session=HibernateUtils.getSessionFactory().openSession();
    		transaction= session.beginTransaction();
    		session.save(customer);
    		
    		transaction.commit();
    		log.info("added sucessfully");
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
    
    
    public long getBalace(int id) {
		Session session=null;
    	Transaction transaction=null;
    	Customer c=null;
    	long money=0;
    	log.info("customer getting balance is started");
    	try {
    		session=HibernateUtils.getSessionFactory().openSession();
    		transaction= session.beginTransaction();
    		c=session.get(Customer.class,id);
    		money=c.getMoney();
    		transaction.commit();
    		log.info("customer getting balance sucessfully");
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
		 
		 return money;
		
	}


	public void depositMoney(int id, long deposit) {
		Session session=null;
    	Transaction transaction=null;
    	Customer c=null;
    	long money=0;
    	try {
    		session=HibernateUtils.getSessionFactory().openSession();
    		transaction= session.beginTransaction();
    		c=session.get(Customer.class,id);
    		money=c.getMoney();
    		money=money+deposit;
    		c.setMoney(money);
    		session.update(c);
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


	public void wthdrawMoney(int id, long withdraw) {
          
		Session session=null;
    	Transaction transaction=null;
    	Customer c=null;
    	long money=0;
    	try {
    		session=HibernateUtils.getSessionFactory().openSession();
    		transaction= session.beginTransaction();
    		c=session.get(Customer.class,id);
    		money=c.getMoney();
    		money=money-withdraw;
    		c.setMoney(money);
    		session.update(c);
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


	public void transferMoney(int id, int idN, long transfer) {
		Session session=null;
    	Transaction transaction=null;
    	Customer c=null;
    	long money=0;
    	try {
    		session=HibernateUtils.getSessionFactory().openSession();
    		transaction= session.beginTransaction();
    		c=session.get(Customer.class,id);
    		money=c.getMoney();
    		money=money-transfer;
    		c.setMoney(money);
    		session.update(c);
    		transaction.commit();
    		validateTransfer(idN,transfer);
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


	private void validateTransfer(int idN, long transfer) {
		Session session=null;
    	Transaction transaction=null;
    	Customer c=null;
    	long money=0;
    	try {
    		session=HibernateUtils.getSessionFactory().openSession();
    		transaction= session.beginTransaction();
    		c=session.get(Customer.class,idN);
    		money=c.getMoney();
    		money=money+transfer;
    		c.setMoney(money);
    		session.update(c);
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


	public List<Customer> getCustomer() {
		
		  try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	            return session.createQuery("from Customer", Customer.class).list();
	        }
	}

}


