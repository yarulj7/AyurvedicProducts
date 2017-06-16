package com.niit.AyuProduct_Backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;

//import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.AyuProduct_Backend.Dao.ProductsDao;
import com.niit.AyuProduct_Backend.Model.Products;


@Repository("productsDao")
@EnableTransactionManagement
@Transactional
public class ProductsDaoImpl implements ProductsDao
{
	@Autowired
	private SessionFactory sessionFactory;

	public ProductsDaoImpl (SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public boolean saveOrupdate(Products products)
	{
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(products);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}	
	}

	public boolean delete(Products products)
	{
	   
		try
		{
		   sessionFactory.getCurrentSession().delete(products);
		    return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			 return false;
		}
	}

	public Products getProducts(String id) 
	{
		String s="from Products where ProductId='" +id +"'";
		Query q=sessionFactory.openSession().createQuery(s);
		@SuppressWarnings("unchecked")
		List<Products> list=(List<Products>)q.list();
		if(list==null||list.isEmpty()){
		return null;
		}
		else
		{
			return list.get(0);
		}
	}

	public List<Products> list() 
	{
		@SuppressWarnings("unchecked")
		List<Products> products = (List<Products>) sessionFactory.getCurrentSession().createCriteria(Products.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return products;
	}

	
	public List<Products> getProductCategory(String id) 
	{
		String q1 = "from Products where C_Id='"+id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Products> list = (List<Products>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list;
	}

	
	public List<Products> getProductPrice() 
	{
		String q1 = "from Products where Product_Price between 100 and 500";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Products> list = (List<Products>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list;
	}

	
	public List<Products> getProductPrice2() 
	{
		String q1 = "from Products where Product_Price between 500 and 1000";
		Query w = sessionFactory.openSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Products> list = (List<Products>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list;
		
	}

	
	public List<Products> getProductPrice3() 
	{
		String q1 = "from Products where Product_Price between 1000 and 2000";
		Query w = sessionFactory.openSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Products> list = (List<Products>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list;
		
	}

	
	public List<Products> getProductName(String name) 
	{
		String q1 = "from Products where ProductName='"+name+"'";
		Query w = sessionFactory.openSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Products> list = (List<Products>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list;	
    }


}