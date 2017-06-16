package com.niit.AyuProduct_Backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.AyuProduct_Backend.Model.Shipping;
import com.niit.AyuProduct_Backend.Dao.ShippingDao;

@Repository("shippingDao")
@EnableTransactionManagement
@Transactional
public class ShippingDaoImpl implements ShippingDao {

	@Autowired
	private SessionFactory sessionFactory;

	public ShippingDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	public boolean saveOrupdate(Shipping shipping) 
	{
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(shipping);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Shipping shipping) 
	{
			try
			{
			 sessionFactory.getCurrentSession().delete(shipping);
			 return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				 return false;
			}
	}

	public Shipping getShipping(String id) 
	{
		String s="from Shipping where s_Id='" +id +"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		@SuppressWarnings("unchecked")
		List<Shipping> list=(List<Shipping>)q.list();
		if(list==null||list.isEmpty()){
		return null;
		}
		else
		{
			return list.get(0);
		}
	}
	
	public List<Shipping> list() 
	{
		@SuppressWarnings("unchecked")
		List<Shipping> shippings = (List<Shipping>) sessionFactory.getCurrentSession().createCriteria(Shipping.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return shippings;
	}


	public List<Shipping> getAddByUser(String u_id) 
	{
		String q1 ="from Shipping where User_ID='"+u_id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Shipping>list = (List<Shipping>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list;

	}

}
