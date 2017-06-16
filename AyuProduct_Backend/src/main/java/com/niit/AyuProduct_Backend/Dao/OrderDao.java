package com.niit.AyuProduct_Backend.Dao;

import java.util.List;

import com.niit.AyuProduct_Backend.Model.Order;

public interface OrderDao 
{
	public boolean saveOrupdate(Order order);
	public boolean delete(Order order);
	public Order getOrder(String id);
	public List<Order> list();
}
