package com.niit.AyuProduct_Frontend.Controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;

import com.niit.AyuProduct_Backend.Dao.UserDao;
import com.niit.AyuProduct_Backend.Model.User;


@Controller
public class LoginController 
{
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/login")
	public String login(@RequestParam(value="error",required=false)String error,
			@RequestParam(value="logout",required=false)String logout,Model model){
	if(error!=null)
		model.addAttribute("error","invalid User name or password");
	if(logout!=null)
		model.addAttribute("logout", "login seccessfull");
	return "redirect:/";
	}
//	
	@RequestMapping(value="/j_spring_security_check",method=RequestMethod.POST)
    public String processRegistration(@RequestParam("j_username")String email,@RequestParam("j_password")String pwd,
   		 Model model,HttpSession session )
    {
		System.out.println("sdfads");
		
		User u=userDao.isvalid(email, pwd);
		if(u==null)
		{
			System.out.println("AyuProducts");
			 model.addAttribute("msg","Invalid user name and password");
	    		return "redirect:/"; 
	    }
		else 
		{
			 session.setAttribute("user", u);
    		 session.setAttribute("name",u.getU_F_Name());
    		 session.setAttribute("items",u.getCart().getGrandtotal());
    		 return "redirect:/"; 
		}
		
		
	}
	
	@RequestMapping(value= "/j_spring_security_logout")
	public String logout(HttpServletRequest request, HttpSession Session, Model model){
		Session.invalidate();
		Session =request.getSession(true);
		model.addAttribute("logout", "logout successful");
		return "redirect:/";
	}


}
