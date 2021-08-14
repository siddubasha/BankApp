
package com.bank.ZzeroBank;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import com.bank.dbconnections.DBoperations;
import com.bank.utils.HibernateUtils;
import com.customer.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/cust")
public class CustomerResource {

	@Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/add")
    @POST
 public String getCustomerApplication(@FormParam("name") String name,@FormParam("password") String password,@FormParam("adhaarNo") Long adhaarNo,
		 @FormParam("mobileNo") Long mobileNo,@FormParam("mailId") String mailId,@FormParam("address") String address, @FormParam("money") Long money) {
	 Customer c1= new Customer();
	 c1.setName(name);
	 c1.setPassword(password);
	 c1.setAdhaarNo(adhaarNo);
	 c1.setMobileNo(mobileNo);
	 c1.setMailId(mailId);
	 c1.setAddress(address);
	 c1.setMoney(money);
	DBoperations db= new DBoperations();
	     db.addCustomer(c1);
	return "your details registered ";
 }
	

}
