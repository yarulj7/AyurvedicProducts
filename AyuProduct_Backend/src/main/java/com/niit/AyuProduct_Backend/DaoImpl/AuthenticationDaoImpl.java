package com.niit.AyuProduct_Backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.AyuProduct_Backend.Dao.AuthenticationDao;
import com.niit.AyuProduct_Backend.Model.Authentication;

@Repository("authenticationDao")
@EnableTransactionManagement
@Transactional
public class AuthenticationDaoImpl  implements AuthenticationDao
{

	@Autowired
	private SessionFactory sessionFactory;

	public AuthenticationDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	public boolean saveOrupdate(Authentication authentication) 
	{
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(authentication);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Authentication authentication) 
	{
		try
		{
		 sessionFactory.getCurrentSession().delete(authentication);
		 return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			 return false;
		}
	}

	public Authentication getBilling(String id) 
	{
		String s="from Authentication where role_Id='" +id +"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		@SuppressWarnings("unchecked")
		List<Authentication> list=(List<Authentication>)q.list();
		if(list==null||list.isEmpty()){
		return null;
		}
		else
		{
			return list.get(0);
		}
	}

	public List<Authentication> list() 
	{
		@SuppressWarnings("unchecked")
		List<Authentication> authenticationlist = (List<Authentication>) sessionFactory.getCurrentSession().createCriteria(Authentication.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return authenticationlist;

	}

}
