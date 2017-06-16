package com.niit.AyuProduct_Backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.AyuProduct_Backend.Dao.PayDao;
import com.niit.AyuProduct_Backend.Model.Pay;

@Repository("payDao")
@EnableTransactionManagement
@Transactional
public class PayDaoImpl implements PayDao 
{
	@Autowired
	private SessionFactory sessionFactory;

	public PayDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	public boolean saveOrupdate(Pay pay) 
	{
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(pay);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		  
	}

	public boolean delete(Pay pay) 
	{
		try
		{
		 sessionFactory.getCurrentSession().delete(pay);
		 return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			 return false;
		}
	}

	public Pay getPay(String id) 
	{
		String s="from Pay where pay_id='" +id +"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		@SuppressWarnings("unchecked")
		List<Pay> list=(List<Pay>)q.list();
		if(list==null||list.isEmpty()){
		return null;
		}
		else
		{
			return list.get(0);
		}
	}
	
	public List<Pay> list() 
	{
		@SuppressWarnings("unchecked")
		List<Pay> pays = (List<Pay>) sessionFactory.getCurrentSession().createCriteria(Pay.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return pays;
	}

}
