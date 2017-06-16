package com.niit.AyuProduct_Backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.AyuProduct_Backend.Dao.CardDao;
import com.niit.AyuProduct_Backend.Model.Card;

public class CardTest 
{
	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	     context.scan("com.niit.*");
	     context.refresh();
	     
	    Card card = (Card)context.getBean("card");
	    CardDao cardDao = (CardDao)context.getBean("cardDao");
	    
	    card.setCard_Id("ABC");
	    card.setCard_Id("124");
	    card.setCard_HolderName("yaruljain");
	    card.setCard_expdate(23);
	    card.setCard_ExpMonth(11);
	    card.setCard_ExpYear(2018);
	    
	    if(cardDao.saveOrupdate(card))
	    {
	    	System.out.println("\t Saving Of Card Is done ");
	    }
	    else
	    {
	    	System.out.println("\t Sorry Failed to Save the Details of the Card ");
	    }
	    
//	    if(cardDao.delete(card))
//	    {
//	    	System.out.println("\t Deleting Of Card Is done ");
//	    }
//	    else
//	    {
//	    	System.out.println("\t Sorry Failed to Delete the Details of the Card ");
//	    }

	    Card card2 = cardDao.getCard("124");
	    card2= cardDao.getCard("ABC");
	    
	    if(card2 != null)
	    {
	    	System.out.println("\t Card Holder Name is = "+card2.getCard_HolderName());
	    }
	    else
	    {
	    	System.out.println("\t Sorry Particular Id is not availabe Card ");
	    }

	    context.close();
	}
}
