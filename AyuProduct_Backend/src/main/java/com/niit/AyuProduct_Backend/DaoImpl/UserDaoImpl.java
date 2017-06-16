package com.niit.AyuProduct_Backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.AyuProduct_Backend.Dao.UserDao;
import com.niit.AyuProduct_Backend.Model.Authentication;
import com.niit.AyuProduct_Backend.Model.Billing;
import com.niit.AyuProduct_Backend.Model.Cart;
import com.niit.AyuProduct_Backend.Model.User;

@Repository("userDao")
@EnableTransactionManagement
@Transactional
public class UserDaoImpl  implements UserDao
{

	@Autowired
	private SessionFactory sessionFactory;

	public UserDaoImpl (SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	
	public boolean saveOrupdate(User user)
	{
		try 
		{	
			Authentication authentication=new Authentication();
			authentication.setUser_Name(user.getU_Email());
			Billing bill= new Billing();
			user.setBill(bill);
			user.getBill().setB_City(user.getCity());
			user.getBill().setB_State(user.getState());
			user.getBill().setB_Landmark(user.getLandMark());
//			user.getBill().setB_Pincode(user.getPincode());
			user.getBill().setUser(user);
			
			Cart cart = new Cart();
			user.setCart(cart);
//			user.getCart().setUser(user);

			sessionFactory.getCurrentSession().saveOrUpdate(user);
			sessionFactory.getCurrentSession().saveOrUpdate(authentication);
			sessionFactory.getCurrentSession().saveOrUpdate(user.getBill());
			sessionFactory.getCurrentSession().saveOrUpdate(user.getCart());
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}	
	 }


	public boolean delete(User user)
	{
		try
		{
		 sessionFactory.getCurrentSession().delete(user);
		 return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			 return false;
		}
	}
	

	public User getUser(String id)
	{
		String s="from User where User_ID='" +id +"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		@SuppressWarnings("unchecked")
		List<User> list=(List<User>)q.list();
		if(list==null||list.isEmpty())
		{
		return null;
		}
		else
		{
			return list.get(0);
		}	
	}
	
	public List<User> list()
	{
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return users;
		}


	public User getUserEmail(String email) 
	{
		String q1= "from User where U_Email='"+email+"'";
		Query w =sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<User>list = (List<User>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}
	public User isvalid(String email,String password)
	{
		String q1="from User where U_Email='"+email+"'and U_Password='"+password+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		 @SuppressWarnings("unchecked")
		List<User>list=(List<User>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}
	}