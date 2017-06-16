package com.niit.AyuProduct_Backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.AyuProduct_Backend.Dao.OrderDao;
//import com.niit.AyuProducts.Model.Billing;
import com.niit.AyuProduct_Backend.Model.Order;

@Repository(value="orderDao")
@EnableTransactionManagement
@Transactional

public class OrderDaoImpl implements OrderDao
{
	@Autowired
	private SessionFactory sessionFactory;

	public OrderDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}


	public boolean saveOrupdate(Order order)
	{
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(order);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Order order) 
	{
		try
		{
		 sessionFactory.getCurrentSession().delete(order);
		 return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			 return false;
		}
	}

	public Order getOrder(String id) 
	{
		String s="from Order where order_id='"+id+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		@SuppressWarnings("unchecked")
		List<Order> list=(List<Order>)q.list();
		if(list==null||list.isEmpty()){
		return null;
		}
		else
		{
			return list.get(0);
		}
	}
	
	public List<Order> list() 
	{
		@SuppressWarnings("unchecked")
		List<Order> orders = (List<Order>) sessionFactory.getCurrentSession().createCriteria(Order.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return orders;
	}

}
