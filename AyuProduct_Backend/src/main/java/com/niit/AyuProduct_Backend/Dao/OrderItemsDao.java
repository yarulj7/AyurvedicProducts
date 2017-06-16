package com.niit.AyuProduct_Backend.Dao;

import java.util.List;

import com.niit.AyuProduct_Backend.Model.OrderItems;

public interface OrderItemsDao 
{
	public boolean saveOrupdate(OrderItems orderItems);
	public boolean delete(OrderItems orderItems);
	public OrderItems getOrderItems(String id);
	public List<OrderItems> list();
	public List<OrderItems> getOrderItemsByOrder(String order_id);
}
