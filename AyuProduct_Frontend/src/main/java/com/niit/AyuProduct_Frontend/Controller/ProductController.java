package com.niit.AyuProduct_Frontend.Controller;

import java.util.List;
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.AyuProduct_Backend.Dao.CategoryDao;
import com.niit.AyuProduct_Backend.Dao.ProductsDao;
import com.niit.AyuProduct_Backend.Dao.SupplierDao;
import com.niit.AyuProduct_Backend.Model.Category;
import com.niit.AyuProduct_Backend.Model.Products;
import com.niit.AyuProduct_Backend.Model.Supplier;
import com.niit.AyuProduct_Frontend.FileInput.FileInput;


@Controller
public class ProductController 
{
	@Autowired
	 Products products;
	
	@Autowired 
	 ProductsDao productDao;

	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDao supplierDao;
	
	String path ="D:\\Yarul Data\\Eclipse Workspace\\AyuProduct_Frontend\\src\\main\\webapp\\resources\\images\\";
	@RequestMapping("/Add_Product")
	public ModelAndView add_Product()
	{
		List<Products> productlist=productDao.list();	 
		List<Supplier> supplierlist = supplierDao.list();
		List<Category> categorylist = categoryDao.list();
		ModelAndView obj=new ModelAndView("Add_Product");//jsp page
		obj.addObject("products", new Products());// Null product Object so that when ever we feel the form this object will be intialzliaed 
		obj.addObject("productlist",productlist);//List Of Products
		obj.addObject("supplierlist",supplierlist);//List of Supplier
		obj.addObject("categorylist",categorylist);//List Of Category
		return obj;
	}
   
   
	@RequestMapping(value="/product_Processing", method=RequestMethod.POST)
	public ModelAndView category(@ModelAttribute("products")Products products)
	{
		ModelAndView obj = new ModelAndView("redirect:/Add_Product");
		if(productDao.saveOrupdate(products))
		{
			System.out.println("\t Starting to add Image also");
		  FileInput.upload(path, products.getPimg(), products.getProductId()+".jpg");
			obj.addObject("msg","\t Sucessfully Saved the Product");
		}
		else
			obj.addObject("msg","\t Sorry!  Failed to Save the Product Please re-try");
		return obj;
	}
	
	@RequestMapping(value="/EditProduct/{ProductId}")
	public ModelAndView editProduct(@PathVariable("ProductId")String id)
	{
		System.out.println("\t Editing the Product ");
		List<Products> productlist=productDao.list();
		ModelAndView obj=new ModelAndView("Add_Product");
		products=productDao.getProducts(id);
		obj.addObject("productlist",productlist);
		obj.addObject("products",products);
		return obj;
	}
	@RequestMapping("/DeleteProduct/{ProductId}")
	public ModelAndView deleteproduct(@PathVariable("ProductId")String id)
	{
		ModelAndView obj=new ModelAndView("redirect:/Add_Product");
		products=productDao.getProducts(id);
		if(productDao.delete(products))
		{
			obj.addObject("msg","\t Product is Deleted successfully");
		}
		else
		{
			obj.addObject("msg","\t Product Cannot be Deleted");
		}
		return obj;
	}
	
	@RequestMapping("/Canceling")
	public ModelAndView cancel()
	{
		return null;
	}
	
	
	@RequestMapping("/Product_Details{id}")
	public String imageDisplay(@PathVariable("id") String id,Model model)
	{
		System.out.println("\t Going for Description Of Image ");
		 Products product = productDao.getProducts(id);
		 model.addAttribute("products",product);
//		ModelAndView obj=new ModelAndView("DescriptioinOfImage");//jsp page
//		obj.addObject("products", new Products());// Null category Object 
		return "DescriptioinOfImage";
	}
	
	
//	@RequestMapping("/All_Products")
//	public ModelAndView allProducts()
//	{
//		List<Products> productlist= productDao.list();
//	  ModelAndView obj = new ModelAndView("All_Products");
//	  obj.addObject(productlist, productlist);
//		return obj;
//	}
	
	@RequestMapping("/All_Products")
	public String allproducts(Model model)
	{
		List<Products> productlist=productDao.list();
		model.addAttribute("productlist", productlist);
		return "All_Products";
	}
	}

