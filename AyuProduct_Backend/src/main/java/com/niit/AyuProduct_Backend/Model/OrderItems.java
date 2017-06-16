package com.niit.AyuProduct_Backend.Model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "OrderItems")
@Component
public class OrderItems 
{
   @Id
   private String orderItem_id;
   private String ProductId;//Product Id
   
   @ManyToOne(cascade  = CascadeType.ALL)
   @JoinColumn(name="order_id")
   private Order order;

   public OrderItems()
   {
   	this.orderItem_id="ORDERitems"+UUID.randomUUID().toString().substring(30).toUpperCase();
   }
// OrderItem ID
   public String getOrderItem_id() 
   {
	return orderItem_id;
   }

   public void setOrderItem_id(String orderItem_id) 
   {
	   this.orderItem_id = orderItem_id;
   }
// Product ID
  
public String getProductId() 
{
	return ProductId;
}

public void setProductId(String productId) 
{
	ProductId = productId;
}

// Order 
   public Order getOrder() 
   {
	return order;
   }

   public void setOrder(Order order) 
   {
	this.order = order;
   }   
}
