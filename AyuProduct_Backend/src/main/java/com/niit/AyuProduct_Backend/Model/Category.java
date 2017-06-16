package com.niit.AyuProduct_Backend.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Category")
@Component
public class Category 
{
	@Id
	private String C_Id;
	private String C_Name;
	private String C_Des;
	
	@OneToMany(mappedBy = "category",cascade  = CascadeType.ALL)
	private List<Products> products;
	
	public Category()
	{
    	this.C_Id="Category"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
// Category Description
	public String getC_Des() 
	{
		return C_Des;
	}

// Category List<Products> products
	public List<Products> getProducts() 
	{
		return products;
	}

	public void setProducts(List<Products> products) 
	{
		this.products = products;
	}

	public void setC_Des(String c_Des) 
	{
		C_Des = c_Des;
	}

	// Category ID
	public String getC_Id() 
	{
		return C_Id;
	}
	
	public void setC_Id(String c_Id) 
	{
		C_Id = c_Id;
	}
	// Category Name
	public String getC_Name() 
	{
		return C_Name;
	}
	
	public void setC_Name(String c_Name) 
	{
		C_Name = c_Name;
	}


	
	

}
