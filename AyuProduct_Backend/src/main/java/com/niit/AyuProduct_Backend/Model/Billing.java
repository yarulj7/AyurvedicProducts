package com.niit.AyuProduct_Backend.Model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name ="Billing")
@Component
public class Billing 
{
	@Id
	 private String b_Id;
	 private String b_House_Number;
	 private String b_Landmark;
	 private String b_City;
	 private String b_State;
//	 private int b_Pincode;
	 
	    @OneToOne(cascade  = CascadeType.ALL)
	    @JoinColumn(name="User_ID")
	    private User user;
	    
//	    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	    @JoinColumn(name ="order_id")
//	    private Order order;


	public Billing()
	 {
		 this.b_Id="Billing"+UUID.randomUUID().toString().toString().substring(30).toUpperCase();
	 }

// Billing Id
	 public String getB_Id() 
	 {
		return b_Id;
	 }

	public void setB_Id(String b_Id) 
	{
		this.b_Id = b_Id;
	}

// Billing House Number
	public String getB_House_Number() 
	{
		return b_House_Number;
	}

	public void setB_House_Number(String b_House_Number) 
	{
		this.b_House_Number = b_House_Number;
	}

// Billing Landmark
	public String getB_Landmark() 
	{
		return b_Landmark;
	}

	public void setB_Landmark(String b_Landmark) 
	{
		this.b_Landmark = b_Landmark;
	}

// Billing City
	public String getB_City() 
	{
		return b_City;
	}

	public void setB_City(String b_City) 
	{
		this.b_City = b_City;
	}

// Billing State
	public String getB_State() 
	{
		return b_State;
	}

	public void setB_State(String b_State) 
	{
		this.b_State = b_State;
	}

// Billing PinCode
//	public int getB_Pincode() 
//	{
//		return b_Pincode;
//	}
//	public void setB_Pincode(int b_Pincode) 
//	{
//		this.b_Pincode = b_Pincode;
//	}
	
//    User
 public User getUser() 
 {
		return user;
  }

	public void setUser(User user) 
	{
		this.user = user;
	}

//	public Order getOrder() {
//		return order;
//	}
//
//	public void setOrder(Order order) {
//		this.order = order;
//	}

}