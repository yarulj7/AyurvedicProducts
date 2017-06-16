package com.niit.AyuProduct_Backend.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name ="Orders")
@Component
public class Order 
{
	@Id
  private String order_id;
  private double grand_total;
  private String order_date;
  private String order_time;
  
  private static final DateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
  private static final DateFormat stf = new SimpleDateFormat("HH:MM:SS");
  
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name ="b_Id")
  private Billing billing;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name ="s_Id")
  private Shipping shipping;
  
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name ="pay_id")
  private Pay pay;
  
  @OneToOne(cascade = CascadeType.ALL)//FetchType.LAZY tells not to create the table when User Register
  @JoinColumn(name ="User_ID")
  private User user;

  @OneToMany(mappedBy = "order")
  private List<OrderItems> orderItems;

  Order()
  {
	  Date date = new Date();
	  order_date =sdf.format(date);
//	  Calendar calendar = Calendar.getInstance();
	  Date date1 = new Date();
	  order_time = stf.format(date1);
	  this.order_id ="ORDER"+ UUID.randomUUID().toString().substring(30).toUpperCase();
  }

// Order ID
  public String getOrder_id() 
  {
	return order_id;
  }

  public void setOrder_id(String order_id) 
  {
	this.order_id = order_id;
  }

// Order Grand Total
  public double getGrand_total() 
  {
	return grand_total;
  }

  public void setGrand_total(double grand_total) 
  {
	this.grand_total = grand_total;
  }

// Order Date
  public String getOrder_date() 
  {
	return order_date;
  }

  public void setOrder_date(String order_date) 
  {
	this.order_date = order_date;
  }

// Order Time
  public String getOrder_time() 
  {
	return order_time;
  }

  public void setOrder_time(String order_time) 
  {
	this.order_time = order_time;
  }

// Order Items 
  public List<OrderItems> getOrderItems() 
  {
	return orderItems;
  }

  public void setOrderItems(List<OrderItems> orderItems) 
  {
	this.orderItems = orderItems;
  }

// Billing 
  public Billing getBilling() 
  {
	return billing;
  }
 
  public void setBilling(Billing billing) 
  {
	this.billing = billing;
  }

//  Shipping
  public Shipping getShipping() 
  {
	return shipping;
  }

  public void setShipping(Shipping shipping) 
  {
	this.shipping = shipping;
  }

// Pay
  public Pay getPay() 
  {
	return pay;
  }

  public void setPay(Pay pay) 
  {
	this.pay = pay;
  }

// User
  public User getUser() 
  {
	return user;
  }

  public void setUser(User user) 
  {
	this.user = user;
  }
}