package com.niit.AyuProduct_Backend.Model;

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
@Table(name = "Cart")
@Component
public class Cart 
{
  @Id	
	private String CartId;
	private double grandtotal=0.0;
	private int totalItems=0;

	@OneToMany(mappedBy = "cart")
	private List<CartItems> cartItems ;
	
//    @OneToOne(cascade  = CascadeType.ALL)
//    @JoinColumn(name="User_ID")
//    User user;
    
//  User  
//	public User getUser() 
//	{
//		return user;
//	}
//	
//	public void setUser(User user) 
//	{
//		this.user = user;
//	}
	public Cart()
	{
    	this.CartId="CART"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
// @One To Many List<CartItems>
	public List<CartItems> getCartItems() 
	{
		return cartItems;
	}

	public void setCartItems(List<CartItems> cartItems) 
	{
		this.cartItems = cartItems;
	}

// Cart Id
	public String getCartId() 
	{
		return CartId;
	}

	public void setCartId(String cartId) 
	{
		CartId = cartId;
	}
// Cart GrandTotal
	public double getGrandtotal() 
	{
		return grandtotal;
	}

	public void setGrandtotal(double grandtotal) 
	{
		this.grandtotal = grandtotal;
	}
// Cart TotalItems
	public int getTotalItems() 
	{
		return totalItems;
	}

	public void setTotalItems(int totalItems) 
	{
		this.totalItems = totalItems;
	} 
}