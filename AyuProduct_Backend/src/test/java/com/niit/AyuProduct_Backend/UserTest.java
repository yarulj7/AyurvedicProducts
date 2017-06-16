package com.niit.AyuProduct_Backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.AyuProduct_Backend.Dao.UserDao;
import com.niit.AyuProduct_Backend.Model.Billing;
import com.niit.AyuProduct_Backend.Model.Cart;
import com.niit.AyuProduct_Backend.Model.Order;
import com.niit.AyuProduct_Backend.Model.User;
public class UserTest 
{
    public static void main(String arg[])
    {
       AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
 	    context.scan("com.niit.*");
 	    context.refresh();   
 	   
 	   User user ;
 	   UserDao userDao=(UserDao)context.getBean("userDao");
 	   user=userDao.getUser("yarulj7@gmail.com");
 	   Billing billing=(Billing)context.getBean("billing");
 	   Cart cart=(Cart)context.getBean("cart");
 	   Order order=(Order)context.getBean("order");

    	 user.setU_F_Name("Yarul");
    	 user.setU_L_Name("Jain");
    	 user.setU_Address("No.34/2 6th Cross Magadi Road(Left)");
    	 user.setU_PhoneNum(948186863l);
    	 user.setU_dob("11/01/2002");
    	 user.setUser_ID("yarulj7@gmail.com");
    	 user.setU_Password("vandana@2002");
    	 user.setRole("ROLE_ADMIN");
    	 user.setTitle("MR");
    	 user.setU_Email(user.getUser_ID());
    	 user.setState("Karnataka");
    	 user.setCity("Bangalore");

    	 
//    	 cart.setCartId("I");
//    	 cart.setGrandtotal(1.0d);
//    	 cart.setTotalItems(1);
    	 
//    	 @OneToOne(cascade  = CascadeType.ALL)
//    	    @JoinColumn(name="b_Id")
//    	    Billing bill;
//
//    	    @OneToOne(cascade  = CascadeType.ALL)
//    	    @JoinColumn(name="CartId")
//    	    Cart cart; 
//    	    
//    	    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    	    @JoinColumn(name ="order_id")
//    	    private Order order;
//    	 billing.setB_Id("AS");
//    	 billing.setB_House_Number("fdsfcsd");
//    	 billing.setB_City("bdsb");
//    	 billing.setB_Landmark("dgt");
//    	 billing.setB_Pincode("60023");
//    	 billing.setB_State("Krnataka");
    	 
    	 user.setBill(billing);
    	 user.setCart(cart);
    	 user.setOrder(order);
    	 

//  Save Or Update
    	   if(userDao.saveOrupdate(user))
            {
    		  System.out.println("\t Save is successfull"); 
            }
    	      else
    	       {
    	    	 System.out.println("\t Sorry"); 
    	       }
//  Get User
//    	 User user2=userDao.getUser("Yarul@1972");
//    	  if(user2!=null)
//    	  {
//    		 System.out.println("\t User Name = "+user2.getU_Name());
//    	  }
//    	  else
//    	  {
//    		 System.out.println("\t Sorry Wrong ID ");
//    	  }
//  Delete User
//       if(userDao.delete(user2))
//       {
//    	   System.out.println("\t Deletion is Done");
//       }
    	   
    	   
    	   context.close();
    }
}