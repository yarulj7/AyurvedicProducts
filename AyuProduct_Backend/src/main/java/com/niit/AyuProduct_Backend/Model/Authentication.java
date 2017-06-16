package com.niit.AyuProduct_Backend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Authentication")
@Component(value="authentication")
public class Authentication
{
	@Id
	private String role_Id;
	private String role_Name ="ROLE_USER";
	private String user_Name;
	
	public Authentication()
	{
		this.role_Id ="ROLE"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
//	Role ID
	public String getRole_Id() 
	{
		return role_Id;
	}
	
	public void setRole_Id(String role_Id) 
	{
		this.role_Id = role_Id;
	}
// Role Name
	public String getRole_Name() 
	{
		return role_Name;
	}
	
	public void setRole_Name(String role_Name) 
	{
		this.role_Name = role_Name;
	}
//	User name
	public String getUser_Name() 
	{
		return user_Name;
	}

	public void setUser_Name(String user_Name) 
	{
		this.user_Name = user_Name;
	}
}
