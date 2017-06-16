package com.niit.AyuProduct_Backend.Dao;

import java.util.List;

//import java.util.List;
import com.niit.AyuProduct_Backend.Model.User;

 public interface UserDao
 {
	public boolean saveOrupdate(User user);
	public boolean delete(User user);
	public User getUser(String id);
	public List<User> list();
	public User getUserEmail(String email);
	public User isvalid(String email,String password);
}