package com.niit.AyuProduct_Backend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Card")
@Component
public class Card 
{
	  @Id
	    private String card_Id;
		private long card_No;
		private String card_HolderName;
		private int card_expdate;
		private int card_ExpYear;
		private int card_ExpMonth;
		
		@ManyToOne
		@JoinColumn(name="User_ID")
		private User user;
		
		public Card()
		{
	    	this.card_Id= "CARD"+UUID.randomUUID().toString().substring(30).toUpperCase();
		}

// Card ExpDate
		public int getCard_expdate() 
		{
			return card_expdate;
		}

		public void setCard_expdate(int card_expdate) 
		{
			this.card_expdate = card_expdate;
		}

// Card ID
		public String getCard_Id() 
		{
			return card_Id;
		}

		public void setCard_Id(String card_Id) 
		{
			this.card_Id = card_Id;
		}

// Card Number
		public long getCard_No() 
		{
			return card_No;
		}

		public void setCard_No(long card_No) 
		{
			this.card_No = card_No;
		}

// Card Holder Name
		public String getCard_HolderName() 
		{
			return card_HolderName;
		}

		public void setCard_HolderName(String card_HolderName) 
		{
			this.card_HolderName = card_HolderName;
		}

// Card Express Year
		public int getCard_ExpYear() 
		{
			return card_ExpYear;
		}

		public void setCard_ExpYear(int card_ExpYear) 
		{
			this.card_ExpYear = card_ExpYear;
		}

// Card Exp Month
		public int getCard_ExpMonth() 
		{
			return card_ExpMonth;
		}

		public void setCard_ExpMonth(int card_ExpMonth) 
		{
			this.card_ExpMonth = card_ExpMonth;
		}

		public User getUser() 
		{
			return user;
		}

		public void setUser(User user) 
		{
			this.user = user;
		}
		
		
}
