package com.niit.AyuProduct_Backend;

//import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.AyuProduct_Backend.Dao.ProductsDao;
import com.niit.AyuProduct_Backend.Model.Category;
import com.niit.AyuProduct_Backend.Model.Products;
import com.niit.AyuProduct_Backend.Model.Supplier;
public class ProductsTest 
{

	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	      context.scan("com.niit.*");
	      context.refresh();
		
	      Products products =(Products)context.getBean("products");
	      ProductsDao productsDao=(ProductsDao)context.getBean("productsDao"); 
	      
	      Category category=(Category)context.getBean("category");
	      Supplier supplier=(Supplier)context.getBean("supplier"); 
	      
	      category.setC_Id("1A");
	      category.setC_Name("NOODLES");
	      category.setC_Des("It is good for health");

	     
	     	supplier.setS_Id("ASD");
	       
	     products.setCategory(category);
	     products.setSupplier(supplier);

		 products.setProductName("ATTA NOODLES");
		 products.setProductId("1234");
		 products.setProduct_Qua(1000);
		 products.setProduct_Price(10);
		 products.setProductDes("it is a eating product ");
		 products.setProduct_weight(60);
		 products.setProduct_weight_in_grams("gm");
		 
		 
//  Save Or Update
		 if(productsDao.saveOrupdate(products))
	        {
			  System.out.println("\t Save is successfull"); 
	        }
		      else
		       {
		    	 System.out.println("\t Data is Not Saved "); 
		       }
		 
		 
//  Delete Product 
//		 if(productsDao.delete("123"))
//	        {
//			  System.out.println("\t Delete is successfull"); 
//	        }
//		      else
//		       {
//		    	 System.out.println("\t Data is Not Deleted "); 
//		       }
		 
		 	  Products  product = productsDao.getProducts("1234");
		 	   if(product == null)
		 	   {
		 		   System.out.println("\t No Product ");
		 	   }
		 	   
		 	   else
		 	   {
		 		  System.out.println(product.getProductName());
		 	   }
		 context.close();
	}

}
