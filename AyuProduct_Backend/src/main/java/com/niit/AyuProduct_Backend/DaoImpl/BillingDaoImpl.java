package com.niit.AyuProduct_Backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.AyuProduct_Backend.Dao.BillingDao;
import com.niit.AyuProduct_Backend.Model.Billing;

@Repository("billingDao")
@EnableTransactionManagement
@Transactional
public class BillingDaoImpl implements BillingDao 
{

	@Autowired
	private SessionFactory sessionFactory;

	public BillingDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	public boolean saveOrupdate(Billing billing) 
	{
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(billing);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Billing billing) 
	{
			try
			{
			 sessionFactory.getCurrentSession().delete(billing);
			 return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				 return false;
			}
	}

	public Billing getBilling(String id) 
	{
		String s="from Billing where b_Id='" +id +"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		@SuppressWarnings("unchecked")
		List<Billing> list=(List<Billing>)q.list();
		if(list==null||list.isEmpty()){
		return null;
		}
		else
		{
			return list.get(0);
		}
	}

	public List<Billing> list() 
	{
		@SuppressWarnings("unchecked")
		List<Billing> billinglist = (List<Billing>) sessionFactory.getCurrentSession().createCriteria(Billing.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return billinglist;

	}


	public Billing get(String u_Id) 
	{
	  String q1="from Billing where User_ID = '"+u_Id+"'";
	  Query q = sessionFactory.getCurrentSession().createQuery(q1);
	  @SuppressWarnings("unchecked")
	  List<Billing> list = (List<Billing>)q.list();
	   if(list.isEmpty() || list == null)
	   {
		   System.out.println("\t Billing User Is Not Availabe in the Database");
		return null;
	   }
	   else
	   {
		   return list.get(0);
	   }
	}
	
	

}
