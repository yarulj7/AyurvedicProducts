package com.niit.AyuProduct_Backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.AyuProduct_Backend.Dao.CategoryDao;
import com.niit.AyuProduct_Backend.Model.Category;

public class CategoryTest
{
   public static void main(String args[])
   {
      AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
      context.scan("com.niit.*");
      context.refresh();
      
     Category category=(Category)context.getBean("category");
     CategoryDao categoryDao=(CategoryDao)context.getBean("categoryDao"); 
     
     category.setC_Id("1A");
     category.setC_Name("Juice");
     category.setC_Des("It is good for health");

    if(categoryDao.saveOrupdate(category))
    {
    	System.out.println("\t  ============= Saved Sucessfully the new Category "+category.getC_Name());
    }
    else
    	System.out.println("\t  ============= Failed to  Save Category "+category.getC_Name());
    
    
//    if(categoryDao.delete(category))
//    {
//    	System.out.println("\t  ============= Sucessfully  Deleted  Category ");
//    }
//    else
//    	System.out.println("\t  ============= Failed to Delete the Category ");
//  THE CATEGORY WILL ONLY DELETE WHEN THE CATEGORY IS NOT LINKED ANY WHERE IN THE DATABASE   

    
    Category category2 = categoryDao.getCategory("1A");
     if(category2 == null )
     {
    	 System.out.println("\t Sorry Category Not Found ");
     }
     
     else
     {
    	 System.out.println("Category Name = "+category2.getC_Name());
     }
    
    context.close();
	}
 
    
      
   }