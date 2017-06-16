package com.niit.AyuProduct_Backend.Model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="CartItems")
@Component
public class CartItems 
{
  @Id
      private String cart_Items_Id;
  	  private double price;
  	  
      @ManyToOne
	  @JoinColumn(name="CartId")
      private Cart cart;
      
      @OneToOne
      @JoinColumn(name="ProductId")
      private Products products; 
      
      
      public CartItems()
      {
      	this.cart_Items_Id="CARTitems"+UUID.randomUUID().toString().substring(30).toUpperCase();
      }
	  
// CartItems ID     
	

public String getCart_Items_Id() 
    {
		return cart_Items_Id;
	}

	public void setCart_Items_Id(String cart_Items_Id) 
	{
		this.cart_Items_Id = cart_Items_Id;
	}

	//  @Many to One = Cart cart
	public Cart getCart() 
	{
		return cart;
	}

	public void setCart(Cart cart) 
	{
		this.cart = cart;
	}

//@One to One  = Product 
	public Products getProducts() 
	{
		return products;
	}

	public void setProducts(Products products) 
	{
		this.products = products;
	}

// CartItems Price
	public double getPrice() 
	{
		return price;
	}

	public void setPrice(double price) 
	{
		this.price = price;
	}  
}
