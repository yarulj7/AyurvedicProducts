package com.niit.AyuProduct_Backend.Dao;

import java.util.List;

import com.niit.AyuProduct_Backend.Model.CartItems;

public interface CartItemsDao 
{
	public boolean saveOrupdate(CartItems cartItems);
	public boolean delete(CartItems cartItems);
	public CartItems getCartItems(String id);
	public List<CartItems> list();
	public List<CartItems> getList(String cart_Id);
	public CartItems getListAll(String cart_Id,String product);
	public List<CartItems> getListByProId(String  p_id);
}
