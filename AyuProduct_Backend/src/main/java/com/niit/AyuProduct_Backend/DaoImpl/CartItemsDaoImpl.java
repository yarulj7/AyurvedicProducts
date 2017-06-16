package com.niit.AyuProduct_Backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.AyuProduct_Backend.Dao.CartItemsDao;
//import com.niit.AyuProducts.Model.Billing;
import com.niit.AyuProduct_Backend.Model.CartItems;

@Repository(value="cartItemsDao")
@EnableTransactionManagement
@Transactional

public class CartItemsDaoImpl implements CartItemsDao 
{

	@Autowired
	private SessionFactory sessionFactory;

	public CartItemsDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	public boolean saveOrupdate(CartItems cartItems) 
	{
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(cartItems);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(CartItems cartItems) 
	{
		try
		{
		 sessionFactory.getCurrentSession().delete(cartItems);
		 return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			 return false;
		}
	}

	public CartItems getCartItems(String id) 
	{
		String s="from CartItems where cart_Items_Id='"+id +"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		@SuppressWarnings("unchecked")
		List<CartItems> list=(List<CartItems>)q.list();
		if(list==null||list.isEmpty()){
		return null;
		}
		else
		{
			return list.get(0);
		}
	}

	public List<CartItems> list() 
	{
		@SuppressWarnings("unchecked")
		List<CartItems> cartitemss = (List<CartItems>) sessionFactory.getCurrentSession().createCriteria(CartItems.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return cartitemss;
	}

	public List<CartItems> getList(String cart_Id) 
	{
		String sql ="From CartItems where CartId = '"+cart_Id+"'";
		Query q1 = sessionFactory.getCurrentSession().createQuery(sql);
		@SuppressWarnings("unchecked")
		List<CartItems> list=(List<CartItems>)q1.list();
		if(list == null || list.isEmpty())
		{
			System.out.println("\t Item is Not Available in The DataBase ");
		  return null;
		}
		else
		{
			return list;
		}
	}

	public CartItems getListAll(String cart_Id, String product) 
	{
	  String sql = "From CartItems where ProductId = '"+product+"' +"+"cart_Items_Id ='"+cart_Id+"'";
	  Query q1 =sessionFactory.getCurrentSession().createQuery(sql);
	  @SuppressWarnings("unchecked")
	  List<CartItems> list = (List<CartItems>)q1.list();
	  if(list == null || list.isEmpty())
	  {
		  System.out.println("\t Item is Not Available in The DataBase ");
		return null;
	  }
	  else
		  return list.get(0);
	}


	public List<CartItems> getListByProId(String p_id) 
	{
			String Sq= "From CartItems  where ProductId='"+p_id+"'";
			Query q= sessionFactory.getCurrentSession().createQuery(Sq);
			@SuppressWarnings("unchecked")
			List<CartItems> list=(List<CartItems>) q.list();
			if(list== null || list.isEmpty()){
				return null;
			}
			else
			{
				return list;
			}

	}
	
}
