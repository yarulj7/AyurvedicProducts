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

import com.niit.AyuProduct_Backend.Dao.SupplierDao;
import com.niit.AyuProduct_Backend.Model.Supplier;

@Repository("supplierDao")
@EnableTransactionManagement
@Transactional

public class SupplierDaoImpl implements SupplierDao
{

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDaoImpl (SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

    public boolean saveOrupdate(Supplier supplier) 
	 {
    	try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}	
	 }

	public boolean delete(Supplier supplier) 
	{
		 try
			{
			 sessionFactory.getCurrentSession().delete(supplier);
			 return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				 return false;
			}
	}

	public Supplier getSupplier(String id) 
	{
		String s="from Supplier where S_Id='" +id +"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		@SuppressWarnings("unchecked")
		List<Supplier> list=(List<Supplier>)q.list();
		if(list==null||list.isEmpty()){
		return null;
		}
		else
		{
			return list.get(0);
		}
	}

	public List<Supplier> list() 
	{
		@SuppressWarnings("unchecked")
		List<Supplier> suppliers = (List<Supplier>) sessionFactory.getCurrentSession().createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return suppliers;
	}


}
