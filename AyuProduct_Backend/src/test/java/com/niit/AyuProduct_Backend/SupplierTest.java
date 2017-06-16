package com.niit.AyuProduct_Backend;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import com.niit.AyuProducts.Dao.ProductsDao;
import com.niit.AyuProduct_Backend.Dao.SupplierDao;
//import com.niit.AyuProducts.DaoImpl.SupplierDaoImpl;
//import com.niit.AyuProducts.Model.Products;
import com.niit.AyuProduct_Backend.Model.Supplier;
public class SupplierTest 
{
   public static void main(String arg[])
   {
	  AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	   context.scan("com.niit.*");
	   context.refresh();   
	   
	   Supplier supplier =(Supplier)context.getBean("supplier");
	   SupplierDao supplierDao=(SupplierDao)context.getBean("supplierDao");
	      
	     	supplier.setS_Name("Yarul");
	     	supplier.setS_Id("ASD");
	     	supplier.setS_Address("Bangalore");
	     	supplier.setS_Phone(9481816863l);
	     	supplier.setS_Email("y@gmail.com");
	    
//  Save Or Update
 	   if(supplierDao.saveOrupdate(supplier))
         {
 		  System.out.println("\t Save is successfull"); 
         }
 	      else
 	       {
 	    	 System.out.println("\t Failed to Save the Supplier"); 
 	       }
//  Delete Supplier 
 	   
// 	  if(supplierDao.delete("AbS"))
//      {
//		  System.out.println("\t Deleted the Supplier"); 
//      }
//	      else
//	       {
//	    	 System.out.println("\t Failed to Delete the Supplier "); 
//	       }
 	   
 	   Supplier supplier2 = supplierDao.getSupplier("ASD");
 	    if(supplier2 == null)
 	    {
 	    	System.out.println("\t Sorry");
 	    }
 	    else
 	    {
 	    	System.out.println("Supplier Name = "+supplier2.getS_Name());
 	    }
 	  context.close();
   }
}
