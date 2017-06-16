package com.niit.AyuProduct_Backend.Dao;

import java.util.List;

import com.niit.AyuProduct_Backend.Model.Card;

public interface CardDao 
{
	public boolean saveOrupdate(Card card);
	public boolean delete(Card card);
	public Card getCard(String id);
	public List<Card> list();
	public List<Card> getCardByUser(String u_Id);
}
