package com.niit.AyuProduct_Backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.AyuProduct_Backend.Dao.OrderItemsDao;
import com.niit.AyuProduct_Backend.Model.Order;
import com.niit.AyuProduct_Backend.Model.OrderItems;

public class OrderItemsTest 
{
	public static void main(String[] args)
	{

		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	      context.scan("com.niit.*");
	      context.refresh();
	      
	      OrderItems orderItems = (OrderItems)context.getBean("orderItems");
	      OrderItemsDao orderItemsDao = (OrderItemsDao)context.getBean("orderItemsDao");
	      
	      Order order = (Order) context.getBean("order");
	      
	      order.setOrder_id("12");
	      
	      orderItems.setOrderItem_id("124");
	      orderItems.setProductId("123");
	      orderItems.setOrder(order);
	      
		if(orderItemsDao.saveOrupdate(orderItems))
        {
        	try
        	{
        		System.out.println("\t Sucessfuly saved the OrderItem ");
        	}
        	  catch(Exception e)
        	   {
        		 System.out.println("\t Error created while saving OrderItem ");  
        	   }
        }
        else
        {
        	System.out.println("\t Sorry failed to save the CartItem");
        }
        
//        if(orderItemsDao.delete(orderItems))
//        {
//        	try
//        	{
//        		System.out.println("\t Sucessfuly deleted the OrderItem ");
//        	}
//        	  catch(Exception e)
//        	   {
//        		 System.out.println("\t Error created while deleting OrderItem ");  
//        	   }
//        }
//        else
//        {
//        	System.out.println("\t Sorry failed to delete the OrderItems");
//        }
        
         OrderItems orderitem = orderItemsDao.getOrderItems("124");
         if(orderitem != null)
         {
        	try
        	{
        	 System.out.println("\t Received the cartItem data ");
        	}
        	catch(Exception e)
        	{
        		System.out.println("\t Error created while receving the data");
        	}
         }
         else
         {
        	 System.out.println("\t Sorry failed to recive the data");
         }
        
         context.close();
	}

}
