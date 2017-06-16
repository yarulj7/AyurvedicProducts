package com.niit.AyuProduct_Backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.AyuProduct_Backend.Dao.AuthenticationDao;
import com.niit.AyuProduct_Backend.Model.Authentication;

public class AuthenticationTest 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	     context.scan("com.niit.*");
	     context.refresh();
		Authentication authentication = (Authentication)context.getBean("authentication");
		AuthenticationDao authenticationDao = (AuthenticationDao)context.getBean("authenticationDao");
		
//		authentication.setRole_Name("ROLE_ADMIN");
		authentication.setUser_Name("yarul");
		
//		if(authenticationDao.saveOrupdate(authentication))
//		{
//			System.out.println("\t "+authentication.getRole_Name()+" Has been added to database");
//		}
//		else
//		{
//			System.out.println("\t Admin has benn failed to save in the database");
//		}
		
		authentication =  authenticationDao.getBilling("ROLEE4681A");
		  if(authentication == null)
		  {
			  System.out.println("\t Sorry No Data Found ");
		  }
		  else
		  {
			  if(authenticationDao.delete(authentication))
			  {
				  System.out.println("\t Deleted the user of type "+authentication.getRole_Name()+" and the User name is :"+authentication.getUser_Name());
			  }
			  else
			  {
				  System.out.println("\t Deleting has been failed");
			  }
		  }
		context.close();
	}

}
