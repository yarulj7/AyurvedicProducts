package com.niit.AyuProduct_Frontend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.AyuProduct_Backend.Dao.CategoryDao;
import com.niit.AyuProduct_Backend.Model.Category;

import java.util.List;

@Controller
public class CategoryController 
{
   @Autowired
     Category category;
   @Autowired
     CategoryDao categoryDao;
 
	@RequestMapping("/Add_Category")//same name as name as home handler
	public ModelAndView add_Product()
	{
		List<Category> categories=categoryDao.list();	 
		ModelAndView obj=new ModelAndView("Add_Category");//jsp page name 
		obj.addObject("category", new Category());// Null category Object same name as command name in form in jsp page 
		obj.addObject("categories",categories);//List Of Categories
//		obj.addObject("categories" same name as present in jsp list 
//		,categories);//refrence variable name mof LIst type
		return obj;
	}
	
	@RequestMapping(value="/category_Processing", method=RequestMethod.POST)
	public ModelAndView category(@ModelAttribute("category")Category category)
	 //@ModelAttribute("category") should be same name as commandName in .jsp page
	//@ModelAttribute will use to get the whole object from .jsp page
	{
		ModelAndView obj = new ModelAndView("redirect:/Add_Category");
		if(categoryDao.saveOrupdate(category))
		{
			obj.addObject("msg","\t Sucessfully Saved the Category");
		}
		else
			obj.addObject("msg","\t Sorry!  Failed to Save the Category Please re-try");
		return obj;
	}
	
	@RequestMapping("/EditCategory/{C_Id}")
	public ModelAndView editcategory(@PathVariable("C_Id")String id)
	{
//		 @PathVariable for varibale we can get 
//		C_ID  is should be same name as model in backend
		System.out.println("\t Editing the Category ");
		List<Category> categories=categoryDao.list();
		ModelAndView obj=new ModelAndView("Add_Category");//In this Add_Category Name should be same name as the Handler Name
		category=categoryDao.getCategory(id);
		obj.addObject("categories",categories);
		obj.addObject("category",category);
		return obj;
	}
	@RequestMapping("/DeleteCategory/{C_Id}")
	public ModelAndView deletecategory(@PathVariable("C_Id")String id)
	{
		ModelAndView obj=new ModelAndView("redirect:/Add_Category");
		category=categoryDao.getCategory(id);
		if(categoryDao.delete(category))
		{
			obj.addObject("msg","\t Category is Deleted successfully");
		}
		else
		{
			obj.addObject("msg","\t Category Cannot be Deleted");
		}
		return obj;
	}

}
