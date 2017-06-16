package com.niit.AyuProduct_Backend.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Supplier")
@Component

public class Supplier 
{
	@Id	
     private String S_Id;
     private String S_Name;
     private String S_Address;
     private String S_Email;
     private long S_Phone;
    
     public Supplier()
     {
     	this.S_Id="SUPPlier"+UUID.randomUUID().toString().substring(30).toUpperCase(); 
     }
     
     @OneToMany(mappedBy="supplier")
     List<Products>products;


	public String getS_Id() {
		return S_Id;
	}


	public void setS_Id(String s_Id) {
		S_Id = s_Id;
	}


	public String getS_Name() {
		return S_Name;
	}


	public void setS_Name(String s_Name) {
		S_Name = s_Name;
	}


	public String getS_Address() {
		return S_Address;
	}


	public void setS_Address(String s_Address) {
		S_Address = s_Address;
	}


	public String getS_Email() {
		return S_Email;
	}


	public void setS_Email(String s_Email) {
		S_Email = s_Email;
	}


	public long getS_Phone() {
		return S_Phone;
	}


	public void setS_Phone(long s_Phone) {
		S_Phone = s_Phone;
	}


	public List<Products> getProduct() {
		return products;
	}


	public void setProduct(List<Products> products) {
		this.products = products;
	}
     

}