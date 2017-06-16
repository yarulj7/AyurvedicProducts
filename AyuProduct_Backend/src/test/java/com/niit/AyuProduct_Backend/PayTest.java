package com.niit.AyuProduct_Backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.AyuProduct_Backend.Dao.PayDao;
import com.niit.AyuProduct_Backend.Model.Pay;

public class PayTest 
{
	public static void main(String args[])
	   {
	      AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	      context.scan("com.niit.*");
	      context.refresh();
	       
	     Pay pay=(Pay)context.getBean("pay");
	     PayDao payDao=(PayDao)context.getBean("payDao"); 
	     
	     pay.setPay_id("asd");
	     pay.setPaying_way("Debit Card");
	     
	     
	      switch(pay.getPaying_way().toUpperCase())
	      {
	        case "DEBIT CARD"  :
	        case "CREDIT CARD" :
	        case "NET BANKING" :  pay.setStatus("\t Paied the Amount");
	        						break;
	        case  "CASH ON DELIVERY" : pay.setStatus("\t Not Paied the Amount");
	         						break;
	        default : pay.setStatus(null);
	        						break;
	      }

	      
	    if(payDao.saveOrupdate(pay))
	    {
	    	System.out.println("\t  ============= Saved Sucessfully Pay Object ");
	    }
	    else
	    	System.out.println("\t  ============= Failed to  Saved Pay Object ");
	    
//	    if(payDao.delete(pay))
//	    {
//	    	System.out.println("\t  ============= Sucessfully  Deleted  Pay Object ");
//	    }
//	    else
//	    	System.out.println("\t  ============= Failed to Delete Pay Object  ");
//	    
	    Pay pay2 = payDao.getPay("asd");
	     if(pay2 == null)
	     {
	    	 System.out.println("\t Sorry ");
	     }
	     else
	     {
	    	 System.out.println("\t Pay Statuts is = "+pay2.getStatus());
	     }
	     context.close();
	      
	   }
}
