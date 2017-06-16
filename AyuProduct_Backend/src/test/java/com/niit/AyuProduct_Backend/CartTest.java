package com.niit.AyuProduct_Backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.AyuProduct_Backend.Dao.CartDao;
import com.niit.AyuProduct_Backend.Model.Cart;

public class CartTest 
{
	public static void main(String[] args)
	{
		 AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	      context.scan("com.niit.*");
	      context.refresh();
	       
	      Cart cart = (Cart)context.getBean("cart");
	      CartDao cartDao = (CartDao)context.getBean("cartDao");
	      
	      cart.setCartId("123");
	      cart.setGrandtotal(10000.0);
	      cart.setTotalItems(190);
	      
	      if(cartDao.saveOrupdate(cart))
	        {
	        	try
	        	{
	        		System.out.println("\t Sucessfuly saved the Cart ");
	        	}
	        	  catch(Exception e)
	        	   {
	        		 System.out.println("\t Error created while saving cart ");  
	        	   }
	        }
	        else
	        {
	        	System.out.println("\t Sorry failed to save the Cart");
	        }
	        
//	        if(cartDao.delete(cart))
//	        {
//	        	try
//	        	{
//	        		System.out.println("\t Sucessfuly deleted the Cart ");
//	        	}
//	        	  catch(Exception e)
//	        	   {
//	        		 System.out.println("\t Error created while deleting cart ");  
//	        	   }
//	        }
//	        else
//	        {
//	        	System.out.println("\t Sorry failed to delete the CartI");
//	        }
	        
	         Cart cart1 = cartDao.getCart("123");
	         if(cart1 != null)
	         {
	        	try
	        	{
	        	 System.out.println("\t Received the cart data ");
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
