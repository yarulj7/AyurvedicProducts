package com.niit.AyuProduct_Backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.AyuProduct_Backend.Dao.CartDao;
import com.niit.AyuProduct_Backend.Model.Cart;


@Repository("cartDao")
@EnableTransactionManagement
@Transactional
public class CartDaoImpl implements CartDao 
{
	@Autowired
	private SessionFactory sessionFactory;

	public CartDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	public boolean saveOrupdate(Cart cart) 
	{
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Cart cart) 
	{
			try
			{
			 sessionFactory.getCurrentSession().delete(cart);
			 return true;
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
				 return false;
			}
	}

	public Cart getCart(String id) 
	{
		String s="from Cart where CartId='" +id +"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		@SuppressWarnings("unchecked")
		List<Cart> list=(List<Cart>)q.list();
		if(list==null||list.isEmpty()){
		return null;
		}
		else
		{
			return list.get(0);
		}

	}
	
	public List<Cart> list() 
	{
		@SuppressWarnings("unchecked")
		List<Cart> carts = (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return carts;
	}

}
