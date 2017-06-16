package com.niit.AyuProduct_Frontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.AyuProduct_Backend.Dao.UserDao;
import com.niit.AyuProduct_Backend.Model.User;

@Controller
public class UserController 
{
	
	@Autowired
	  User user;
	@Autowired
	  UserDao userDao; 
	
	@RequestMapping("/Register")
	public ModelAndView register()
	{
		List<User> userlist=userDao.list();	 
		ModelAndView obj=new ModelAndView("Register");//jsp page
		obj.addObject("user", new User());// Null category Object 
		obj.addObject("userlist",userlist);//List Of Categories
		return obj;
	}
	
	@RequestMapping(value="/user_Processing", method=RequestMethod.POST)
	public ModelAndView category(@ModelAttribute("user")User user)
	{
		ModelAndView obj = new ModelAndView("redirect:/Register");
		if(userDao.saveOrupdate(user))
		{
			obj.addObject("msg","\t Sucessfully Saved the User");
		}
		else
			obj.addObject("msg","\t Sorry!  Failed to Save the User Please re-try");
		return obj;
	}
	
	@RequestMapping("/EditUser/{User_ID}")
	public ModelAndView editcategory(@PathVariable("User_ID")String id)
	{
		System.out.println("\t Editing the User ");
		List<User> userlist=userDao.list();
		ModelAndView obj=new ModelAndView("Register");
		user=userDao.getUser(id);
		obj.addObject("userlist",userlist);
		obj.addObject("user",user);
		return obj;
	}
	@RequestMapping("/DeleteUser/{User_ID}")
	public ModelAndView deletecategory(@PathVariable("User_ID")String id)
	{
		ModelAndView obj=new ModelAndView("redirect:/Add_Category");
		user=userDao.getUser(id);
		if(userDao.delete(user))
		{
			obj.addObject("msg","\t User is Deleted successfully");
		}
		else
		{
			obj.addObject("msg","\t User Cannot be Deleted");
		}
		return obj;
	}
}
