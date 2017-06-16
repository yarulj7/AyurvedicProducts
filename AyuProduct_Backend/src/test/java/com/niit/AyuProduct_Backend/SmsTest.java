package com.niit.AyuProduct_Backend;

import com.niit.AyuProduct_Backend.Model.SendSms;

public class SmsTest 
{
	public static void main(String arg[])
	{
	  SendSms ss = new SendSms();
	 
	  //System.out.println("\t Enter Who is Entering the Message ");
	   ss.setFrom(10);
	   ss.setTo(12);
	   ss.setMessage("HI");
	   ss.setSubject("Hi");
	   
	     if(ss.getFrom() == 0l ||ss.getTo() == 0l || ss.getMessage() == null || ss.getSubject() == null)
	     {
	    	 ss.setErrorCode(404);
	    	 ss.setMessageError("Undelivered");
	    	 ss.setStatus("Failed");
	     }
	     else
	     {
	    	 ss.setErrorCode(202);
	    	 ss.setMessageError("Delivered");
	    	 ss.setStatus("Sucess");
	     }
	     
	       System.out.println(ss.getErrorCode());
	       System.out.println(ss.getMessageError());
	       System.out.println(ss.getStatus());
	}
	
}
