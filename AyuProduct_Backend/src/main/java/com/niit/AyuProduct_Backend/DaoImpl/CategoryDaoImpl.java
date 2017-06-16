package com.niit.AyuProduct_Backend.DaoImpl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.AyuProduct_Backend.Dao.CategoryDao;
import com.niit.AyuProduct_Backend.Model.Category;

@Repository("categoryDao")
@EnableTransactionManagement
@Transactional
public class CategoryDaoImpl implements CategoryDao 
{
	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	public boolean saveOrupdate(Category category) 
	{
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	 public boolean delete(Category category)
	 {
	try
			{
			 sessionFactory.getCurrentSession().delete(category);
			 return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				 return false;
			}
	 }
	
	// public List<Category> list()
	// {
	//   return null;
	// }
	//

	 public Category getCategory(String id)
	 {
			String s="from Category where C_Id='" +id +"'";
			Query q=sessionFactory.getCurrentSession().createQuery(s);
			@SuppressWarnings("unchecked")
			List<Category> list=(List<Category>)q.list();
			if(list==null||list.isEmpty()){
			return null;
			}
			else
			{
				return list.get(0);
			}

	 }


	public List<Category> list() 
	{
		@SuppressWarnings("unchecked")
		List<Category> categorylist = (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return categorylist;
	}

	public Category getCategory_By_Product(String id) {
		
			String q1 = "from Products where C_Id='" + id + "'";
			Query w = sessionFactory.getCurrentSession().createQuery(q1);
			@SuppressWarnings("unchecked")
			List<Category> list = (List<Category>) w.list();
			if (list == null || list.isEmpty()) 
			{
				return null;
			}
			   return list.get(0);
	}

}