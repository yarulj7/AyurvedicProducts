package com.niit.AyuProduct_Backend.Dao;

import java.util.List;
import com.niit.AyuProduct_Backend.Model.Category;

public interface CategoryDao
{
	public boolean saveOrupdate(Category category);
	public boolean delete(Category category);
	public Category getCategory(String id);
	public List<Category> list();
//	public Category getCategory_By_Product(String id);
}