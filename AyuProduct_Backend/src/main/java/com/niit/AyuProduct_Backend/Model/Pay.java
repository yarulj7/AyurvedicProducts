package com.niit.AyuProduct_Backend.Model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Pay")
@Component // to create a default object 
public class Pay 
{
  @Id
   private String pay_id;
   private String paying_way;
   private String status;

   @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   @JoinColumn(name ="order_id")
   private Order order;
   
   public Pay()
   {
   	this.pay_id="PAY"+UUID.randomUUID().toString().substring(30).toUpperCase();
   }
// Pay ID
     public String getPay_id() 
     {
    	 return pay_id;
     }

     public void setPay_id(String pay_id) 
      {
    	 this.pay_id = pay_id;
      }
 
// Pay Method
     public String getPaying_way() 
      {
         return paying_way;
      }

      public void setPaying_way(String paying_way) 
       {
         this.paying_way = paying_way;
       }

// Pay Status
      public String getStatus() 
       {
          return status;	
       }

       public void setStatus(String status) 
        {
          this.status = status;
        }
       
	public Order getOrder() 
	{
		return order;
	}
	
	public void setOrder(Order order) 
	{
		this.order = order;
	}  
       
}