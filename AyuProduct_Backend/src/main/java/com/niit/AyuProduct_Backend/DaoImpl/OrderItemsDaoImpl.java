package com.niit.AyuProduct_Backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.AyuProduct_Backend.Dao.OrderItemsDao;
//import com.niit.AyuProducts.Model.Billing;
import com.niit.AyuProduct_Backend.Model.OrderItems;

@Repository(value="orderItemsDao")
@EnableTransactionManagement
@Transactional

public class OrderItemsDaoImpl implements OrderItemsDao
{
	@Autowired
	private SessionFactory sessionFactory;

	public OrderItemsDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}


	public boolean saveOrupdate(OrderItems orderItems) 
	{
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(orderItems);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(OrderItems orderItems) 
	{
		try
		{
		 sessionFactory.getCurrentSession().delete(orderItems);
		 return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			 return false;
		}
	}

	public OrderItems getOrderItems(String id) 
	{
		String s="from OrderItems where orderItem_id='" +id +"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		@SuppressWarnings("unchecked")
		List<OrderItems> list=(List<OrderItems>)q.list();
		if(list==null||list.isEmpty()){
		return null;
		}
		else
		{
			return list.get(0);
		}
	}

	public List<OrderItems> list() 
	{
		@SuppressWarnings("unchecked")
		List<OrderItems> ordersitemss = (List<OrderItems>) sessionFactory.getCurrentSession().createCriteria(OrderItems.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return ordersitemss;
	}


	public List<OrderItems> getOrderItemsByOrder(String order_id) 
	{
		String q1 ="from OrderItems where order_id='"+order_id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<OrderItems> list = (List<OrderItems>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list;
	}
}
