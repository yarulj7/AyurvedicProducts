package com.niit.AyuProduct_Backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.AyuProduct_Backend.Dao.CartItemsDao;
import com.niit.AyuProduct_Backend.Model.Cart;
import com.niit.AyuProduct_Backend.Model.CartItems;
import com.niit.AyuProduct_Backend.Model.Products;

public class CartItemsTest 
{
	public static void main(String[] args)
	{
		 AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	      context.scan("com.niit.*");
	      context.refresh();
	       CartItems cartItems = (CartItems)context.getBean("cartItems");
	       CartItemsDao cartItemsDao = (CartItemsDao)context.getBean("cartItemsDao");
	       
	       Cart cart = (Cart)context.getBean("cart");
	       
	       Products products = (Products)context.getBean("products");
	       
	        cart.setCartId("123");
	        
	        products.setProductId("1234");
	        
	        cartItems.setCart_Items_Id("ghj");
	        cartItems.setPrice(100.0f);
	        cartItems.setCart(cart);
	        cartItems.setProducts(products);
	        
	        if(cartItemsDao.saveOrupdate(cartItems))
	        {
	        	try
	        	{
	        		System.out.println("\t Sucessfuly saved the CartItem ");
	        	}
	        	  catch(Exception e)
	        	   {
	        		 System.out.println("\t Error created while saving cartItem ");  
	        	   }
	        }
	        else
	        {
	        	System.out.println("\t Sorry failed to save the CartItem");
	        }
	        
//	        if(cartItemsDao.delete(cartItems))
//	        {
//	        	try
//	        	{
//	        		System.out.println("\t Sucessfuly deleted the CartItem ");
//	        	}
//	        	  catch(Exception e)
//	        	   {
//	        		 System.out.println("\t Error created while deleting cartItem ");  
//	        	   }
//	        }
//	        else
//	        {
//	        	System.out.println("\t Sorry failed to delete the CartItems");
//	        }
	        
	         CartItems cartitem = cartItemsDao.getCartItems("ghj");
	         if(cartitem != null)
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
