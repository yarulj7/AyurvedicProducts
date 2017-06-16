package com.niit.AyuProduct_Backend.Dao;

import java.util.List;

import com.niit.AyuProduct_Backend.Model.Pay;

public interface PayDao 
{
	public boolean saveOrupdate(Pay pay);
	public boolean delete(Pay pay);
	public Pay getPay(String id);
	public List<Pay> list();
}