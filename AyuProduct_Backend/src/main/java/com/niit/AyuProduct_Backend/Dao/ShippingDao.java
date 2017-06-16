package com.niit.AyuProduct_Backend.Dao;

import java.util.List;

import com.niit.AyuProduct_Backend.Model.Shipping;

public interface ShippingDao 
{
	public boolean saveOrupdate(Shipping shipping);
	public boolean delete(Shipping shipping);
	public Shipping getShipping(String id);
	public List<Shipping> list();
	public List<Shipping> getAddByUser(String u_id);
}
