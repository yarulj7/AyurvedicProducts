package com.niit.AyuProduct_Backend.Dao;

import java.util.List;

//import java.util.List;
import com.niit.AyuProduct_Backend.Model.Supplier;

public interface SupplierDao 
{
	public boolean saveOrupdate(Supplier supplier);
	public boolean delete(Supplier supplier);
	public Supplier getSupplier(String id);
	public List<Supplier> list();
}