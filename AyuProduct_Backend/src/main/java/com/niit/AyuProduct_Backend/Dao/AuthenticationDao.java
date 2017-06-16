package com.niit.AyuProduct_Backend.Dao;

import java.util.List;

import com.niit.AyuProduct_Backend.Model.Authentication;;

public interface AuthenticationDao 
{
	public boolean saveOrupdate(Authentication authentication);
	public boolean delete(Authentication authentication);
	public Authentication getBilling(String id);
	public List<Authentication> list();
}
