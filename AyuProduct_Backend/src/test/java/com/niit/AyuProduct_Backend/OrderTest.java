package com.niit.AyuProduct_Backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.AyuProduct_Backend.Dao.OrderDao;
import com.niit.AyuProduct_Backend.Model.Billing;
import com.niit.AyuProduct_Backend.Model.Order;
import com.niit.AyuProduct_Backend.Model.Pay;
import com.niit.AyuProduct_Backend.Model.Shipping;
import com.niit.AyuProduct_Backend.Model.User;

public class OrderTest 
{
	public static void main(String[] args)
	{
	   AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();   

		Order order =(Order)context.getBean("order");
		OrderDao orderDao = (OrderDao)context.getBean("orderDao");
		
		Billing billing =(Billing)context.getBean("billing");
		
		User user = (User)context.getBean("user");
		
		Pay pay = (Pay)context.getBean("pay");
		
		Shipping shipping =(Shipping)context.getBean("shipping");
		
		pay.setPay_id("abc");
		
		shipping.setS_Id("21");
		
		billing.setB_Id("abc");

		user.setUser_ID("Yarul@12");

		order.setOrder_id("abc");
		order.setOrder_time("11:22:12");
		order.setGrand_total(100);
		order.setOrder_date("22/05/2017");
		
		order.setBilling(billing);
		order.setUser(user);
		order.setPay(pay);
		order.setShipping(shipping);
		
		if(orderDao.saveOrupdate(order))
		{
			System.out.println("\t Save of the Order is Sucessfull");
		}
		else
		{
			System.out.println("\t Save not sucessfull");
		}
	  context.close();
	}

}
