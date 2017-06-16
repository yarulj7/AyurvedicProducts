package com.niit.AyuProduct_Backend.Dao;

import java.util.List;

import com.niit.AyuProduct_Backend.Model.Cart;

public interface CartDao 
{
	public boolean saveOrupdate(Cart cart);
	public boolean delete(Cart cart);
	public Cart getCart(String id);
	public List<Cart> list();
}