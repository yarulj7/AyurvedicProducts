package com.niit.AyuProduct_Frontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.AyuProduct_Backend.Dao.SupplierDao;
import com.niit.AyuProduct_Backend.Model.Supplier;

@Controller
public class SupplierController
{
  @Autowired
   Supplier supplier;
  @Autowired
   SupplierDao supplierDao;
	@RequestMapping("/Add_Supplier")
	public ModelAndView add_Supplier()
	{
		List<Supplier> supplierlist=supplierDao.list();	 
		ModelAndView obj=new ModelAndView("Add_Supplier");//jsp page
		obj.addObject("supplier", new Supplier());// Null category Object 
		obj.addObject("supplierlist",supplierlist);//List Of Categories
		return obj;

	}
 
	
	@RequestMapping(value="/supplier_Processing", method=RequestMethod.POST)
	public ModelAndView category(@ModelAttribute("supplier")Supplier supplier)
	{
		ModelAndView obj = new ModelAndView("redirect:/Add_Supplier");
		if(supplierDao.saveOrupdate(supplier))
		{
			obj.addObject("msg","\t Sucessfully Saved the Supplier");
		}
		else
			obj.addObject("msg","\t Sorry!  Failed to Save the Supplier Please re-try");
		return obj;
	}
	
	@RequestMapping("/EditSupplier/{S_Id}")
	public ModelAndView editcategory(@PathVariable("S_Id")String id)
	{
//		System.out.println("\t Editing the Supplier ");
		List<Supplier> supplierlist=supplierDao.list();
		ModelAndView obj=new ModelAndView("Add_Supplier");
		supplier=supplierDao.getSupplier(id);
		obj.addObject("supperlist",supplierlist);
		obj.addObject("supplier",supplier);
		return obj;
	}
	@RequestMapping("/DeleteSupplier/{S_Id}")
	public ModelAndView deletecategory(@PathVariable("S_Id")String id)
	{
		ModelAndView obj=new ModelAndView("redirect:/Add_Supplier");
		supplier=supplierDao.getSupplier(id);
		if(supplierDao.delete(supplier))
		{
			obj.addObject("msg","\t Supplier is Deleted successfully");
		}
		else
		{
			obj.addObject("msg","\t Supplier Cannot be Deleted");
		}
		return obj;
	}
}
