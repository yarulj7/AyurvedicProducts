package com.niit.AyuProduct_Backend.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.AyuProduct_Backend.Dao.AuthenticationDao;
import com.niit.AyuProduct_Backend.Dao.BillingDao;
import com.niit.AyuProduct_Backend.Dao.CardDao;
import com.niit.AyuProduct_Backend.Dao.CartDao;
import com.niit.AyuProduct_Backend.Dao.CartItemsDao;
import com.niit.AyuProduct_Backend.Dao.CategoryDao;
import com.niit.AyuProduct_Backend.Dao.OrderDao;
import com.niit.AyuProduct_Backend.Dao.OrderItemsDao;
import com.niit.AyuProduct_Backend.Dao.PayDao;
import com.niit.AyuProduct_Backend.Dao.ProductsDao;
import com.niit.AyuProduct_Backend.Dao.ShippingDao;
import com.niit.AyuProduct_Backend.Dao.SupplierDao;
import com.niit.AyuProduct_Backend.Dao.UserDao;
import com.niit.AyuProduct_Backend.DaoImpl.AuthenticationDaoImpl;
import com.niit.AyuProduct_Backend.DaoImpl.BillingDaoImpl;
import com.niit.AyuProduct_Backend.DaoImpl.CardDaoImpl;
import com.niit.AyuProduct_Backend.DaoImpl.CartDaoImpl;
import com.niit.AyuProduct_Backend.DaoImpl.CartItemsDaoImpl;
import com.niit.AyuProduct_Backend.DaoImpl.CategoryDaoImpl;
import com.niit.AyuProduct_Backend.DaoImpl.OrderDaoImpl;
import com.niit.AyuProduct_Backend.DaoImpl.OrderItemsDaoImpl;
import com.niit.AyuProduct_Backend.DaoImpl.PayDaoImpl;
import com.niit.AyuProduct_Backend.DaoImpl.ProductsDaoImpl;
import com.niit.AyuProduct_Backend.DaoImpl.ShippingDaoImpl;
import com.niit.AyuProduct_Backend.DaoImpl.SupplierDaoImpl;
import com.niit.AyuProduct_Backend.DaoImpl.UserDaoImpl;
import com.niit.AyuProduct_Backend.Model.Authentication;
import com.niit.AyuProduct_Backend.Model.Billing;
import com.niit.AyuProduct_Backend.Model.Card;
import com.niit.AyuProduct_Backend.Model.Cart;
import com.niit.AyuProduct_Backend.Model.CartItems;
import com.niit.AyuProduct_Backend.Model.Category;
import com.niit.AyuProduct_Backend.Model.Order;
import com.niit.AyuProduct_Backend.Model.OrderItems;
import com.niit.AyuProduct_Backend.Model.Pay;
import com.niit.AyuProduct_Backend.Model.Products;
import com.niit.AyuProduct_Backend.Model.Shipping;
import com.niit.AyuProduct_Backend.Model.Supplier;
import com.niit.AyuProduct_Backend.Model.User;




@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class ApplicationContext 
{

	@Bean("dataSource")
	public DataSource getDataSource() 
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/AyuProduct_Backend");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");

		// Properties connectionProperties=new Properties();
		// connectionProperties.setProperty("hibernate.show_sql", "true");
		// connectionProperties.setProperty("hibernate.dialect",
		// "org.hibernate.dialect");
		return dataSource;
	}

	private Properties getHibernateProperties() 
	{
		Properties properties = new Properties();
		properties.put("hibernate.connection.pool_size", "10");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}

	@Autowired
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) 
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
     	sessionBuilder.addAnnotatedClass(Category.class);
     	sessionBuilder.addAnnotatedClass(Products.class);
     	sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Pay.class);
		sessionBuilder.addAnnotatedClass(Shipping.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(Billing.class);
		sessionBuilder.addAnnotatedClass(Card.class);
//		sessionBuilder.addAnnotatedClass(Seller.class);
//		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(CartItems.class);
		sessionBuilder.addAnnotatedClass(Authentication.class);
//		sessionBuilder.addAnnotatedClass(BillingAddress.class);
//		sessionBuilder.addAnnotatedClass(Shipping.class);
//		sessionBuilder.addAnnotatedClass(Pay.class);
//		sessionBuilder.addAnnotatedClass(Card.class);
		sessionBuilder.addAnnotatedClass(Order.class);
        sessionBuilder.addAnnotatedClass(OrderItems.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean("transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	@Autowired
	@Bean(name="categoryDao")
	public CategoryDao getCategoryDao(SessionFactory sessionFactory) 
	{
		return new CategoryDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="productsDao")
	public ProductsDao getProductDao(SessionFactory sessionFactory) 
	{
		return new ProductsDaoImpl(sessionFactory);

	}
	@Autowired
	@Bean(name="authenticationDao")
	public AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory) 
	{
		return new AuthenticationDaoImpl(sessionFactory);

	}

	@Autowired
	@Bean(name="supplierDao")
	public SupplierDao getSupplierDao(SessionFactory sessionFactory) 
	{
		return new SupplierDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="userDao")
	public UserDao getUserDao(SessionFactory sessionFactory) 
	{
		return new UserDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="payDao")
	public PayDao getPayDao(SessionFactory sessionFactory) 
	{
		return new PayDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="shippingDao")
	public ShippingDao getShippingDao(SessionFactory sessionFactory) 
	{
		return new ShippingDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean(name="cartDao")
	public CartDao getCartDao(SessionFactory sessionFactory) 
	{
		return new CartDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean(name="billingDao")
	public BillingDao getBillingDao(SessionFactory sessionFactory) 
	{
		return new BillingDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean(name="cardDao")
	public CardDao getCardDao(SessionFactory sessionFactory) 
	{
		return new CardDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean(name="cardItemsDao")
	public CartItemsDao getCardItemsDao(SessionFactory sessionFactory) 
	{
		return new CartItemsDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean(name="orderDao")
	public OrderDao getOrderDao(SessionFactory sessionFactory) 
	{
		return new OrderDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="orderItemsDao")
	public OrderItemsDao getOrderItemsDao(SessionFactory sessionFactory) 
	{
		return new OrderItemsDaoImpl(sessionFactory);
	}

	
//	@Autowired
//	@Bean(name="authenticationDao")
//	public AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory) {
//		return new AuthenticationDaoImpl(sessionFactory);
//	}

}