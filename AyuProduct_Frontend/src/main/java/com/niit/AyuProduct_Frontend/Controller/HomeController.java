package com.niit.AyuProduct_Frontend.Controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{

	@RequestMapping("/")
	public String home()
	{
		return "Navbar";
	}
	
	@RequestMapping("/Navbar")
	public String navbar()
	{
		return "Navbar";
	}
	
	@RequestMapping("/Payment")
	public String payment()
	{
		return "Payment";
	}
	
	@RequestMapping("/ThankYou")
	public String thank()
	{
		return "ThankYou";
	}
	
}
