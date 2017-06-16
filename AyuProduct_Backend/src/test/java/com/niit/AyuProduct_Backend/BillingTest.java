package com.niit.AyuProduct_Backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.AyuProduct_Backend.Dao.BillingDao;
//import com.niit.AyuProduct_Backend.Dao.OrderDao;
import com.niit.AyuProduct_Backend.Dao.UserDao;
import com.niit.AyuProduct_Backend.Model.Billing;
//import com.niit.AyuProduct_Backend.Model.Order;
import com.niit.AyuProduct_Backend.Model.User;

public class BillingTest 
{

	public static void main(String[] args)
	{
		 AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	      context.scan("com.niit.*");
	      context.refresh();
	     
	    Billing billing=(Billing)context.getBean("billing");
	    BillingDao billingDao =(BillingDao)context.getBean("billingDao");
	    User user;
	    UserDao userDao = (UserDao) context.getBean("userDao");
	    user=userDao.getUser("yarulj7@gmail.com");
//	    Order order;
//	    OrderDao orderDao =(OrderDao)context.getBean("orderDao");
	    
//	    order=orderDao.getOrder("");
	    
//	    billing.setB_Id(user.getBill().getB_Id());
//	    billing.setB_House_Number(user.getU_Address());
//	    billing.setB_Landmark("St.Martin High School");
//	    billing.setB_City(user.getCity());
//	    billing.setB_State(user.getState());
//	    billing.setB_Pincode("560023");
//	    billing.setUser(user);
////	    billing.setOrder(order);
//	    if(billingDao.saveOrupdate(billing))
//	    {
//	      try
//	      {
//	    	System.out.println("\t Save has been done");
//	      }
//	       catch(Exception e)
//	        {
//	    	   System.out.println("\t Error has been created while saving the billing details");  
//	        }
//	    }
//	    else
//	    {
//	    	System.out.println("\t Sorry failed to save the billing details0");
//	    }
	    
	    billing.setB_Id("Billing20343B");
	    if(billingDao.delete(billing))
	    {
	      try
	      {
	    	System.out.println("\t Delete has been done");
	      }
	       catch(Exception e)
	        {
	    	   System.out.println("\t Error has been created while deleting the billing details");  
	        }
	    }
	    else
	    {
	    	System.out.println("\t Sorry failed to delete the billing details0");
	    }
	    Billing bill = billingDao.getBilling(user.getBill().getB_Id());
	   if(bill != null)
	   {
	     try
	      {
	    	System.out.println("\t Getting of has been done");
	      }
	       catch(Exception e)
	        {
	    	   System.out.println("\t Error has been created while getting the billing details");  
	        }
	    }
	    else
	    {
	    	System.out.println("\t Sorry failed to get the billing details");
	    }
	    context.close();
	}

}
