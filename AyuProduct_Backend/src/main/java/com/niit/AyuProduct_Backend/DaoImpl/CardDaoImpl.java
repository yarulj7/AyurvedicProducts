package com.niit.AyuProduct_Backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.AyuProduct_Backend.Dao.CardDao;
import com.niit.AyuProduct_Backend.Model.Card;

@Repository("cardDao")
@EnableTransactionManagement
@Transactional
public class CardDaoImpl implements CardDao 
{
	@Autowired
	private SessionFactory sessionFactory;

	public CardDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	public boolean saveOrupdate(Card card) 
	{
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(card);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Card card) 
	{
			try
			{
			 sessionFactory.getCurrentSession().delete(card);
			 return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				 return false;
			}
	}

//	@Override
	public Card getCard(String id) 
	{
		String s="from Card where cart_Id='" +id +"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		@SuppressWarnings("unchecked")
		List<Card> list=(List<Card>)q.list();
		if(list==null||list.isEmpty()){
		return null;
		}
		else
		{
			return list.get(0);
		}

	}

	public List<Card> list() 
	{
		@SuppressWarnings("unchecked")
		List<Card> cardlist = (List<Card>) sessionFactory.getCurrentSession().createCriteria(Card.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return cardlist;
	}


	public List<Card> getCardByUser(String u_Id) 
	{
		String q1 ="from Card where User_ID='"+u_Id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Card> list = (List<Card>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list;
	}

}
