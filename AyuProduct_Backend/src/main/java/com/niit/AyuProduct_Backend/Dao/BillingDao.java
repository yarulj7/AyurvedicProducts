package com.niit.AyuProduct_Backend.Dao;

import java.util.List;

import com.niit.AyuProduct_Backend.Model.Billing;

public interface BillingDao 
{
	public boolean saveOrupdate(Billing billing);
	public boolean delete(Billing billing);
	public Billing getBilling(String id);
	public List<Billing> list();
	public Billing get(String u_Id);
}
