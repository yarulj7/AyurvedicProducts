package com.niit.AyuProduct_Frontend.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.AyuProduct_Backend.Dao.CartDao;
import com.niit.AyuProduct_Backend.Dao.CartItemsDao;
import com.niit.AyuProduct_Backend.Dao.ProductsDao;
import com.niit.AyuProduct_Backend.Dao.UserDao;
import com.niit.AyuProduct_Backend.Model.Cart;
import com.niit.AyuProduct_Backend.Model.CartItems;
import com.niit.AyuProduct_Backend.Model.Products;
import com.niit.AyuProduct_Backend.Model.User;

@Controller
public class CartController
{
	@Autowired
	User user;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	Cart cart;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	CartItems cartItems;
	
	@Autowired
	CartItemsDao cartItemsDao;
	
	@Autowired
	Products products;
	
	@Autowired
	ProductsDao productsDao;
	
	@Autowired
	HttpSession session;
	
  @RequestMapping("/AddToCartC/{id}")
   public ModelAndView addTocart(@PathVariable("id") String id)
   {
	   User user1 = userDao.getUserEmail(user.getUser_ID());
	    if(user == null)
	    {
	    	return new ModelAndView("redirect:/");
	    }
	    else
	    {	
	    	System.out.println("Entered in the Add To Cart ");
	     cart=user1.getCart();
	     products=productsDao.getProducts(id);
	     cartItems = new CartItems();
	     cartItems.setCart(cart);
		 cartItems.setProducts(products);
		 cartItems.setPrice(products.getProduct_Price());
		 cartItemsDao.saveOrupdate(cartItems);
		 cart.setGrandtotal(cart.getGrandtotal() + products.getProduct_Price());
		 cart.setTotalItems(cart.getTotalItems() + 1);
		 cartDao.saveOrupdate(cart);
		 session.setAttribute("items", cart.getTotalItems());
		 session.setAttribute("gd", cart.getGrandtotal());
			return new ModelAndView("redirect:/All_Products");
	    }
   }
  @RequestMapping("/AddToCart/{ProductId}")
	public ModelAndView cartc(@PathVariable("ProductId") String id) {

	  System.out.println("Entered in the Add To Cart ");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			User u = userDao.getUserEmail(currusername);
			if (user == null) {
				System.out.println("\t User Is Null ");
				return new ModelAndView("redirect:/");
			} else {
//				u.setCart(cart);
				cart = u.getCart();
				products = productsDao.getProducts(id);
				CartItems cartItem = new CartItems();
				cartItem.setCart(cart);
				cartItem.setProducts(products);
				cartItem.setPrice(products.getProduct_Price());
				cartItemsDao.saveOrupdate(cartItem);
				
			
				
//				List <CartItems> cartiitems = cart.getCartItems();
//				cartiitems.add(cartItem);
//				cart.setCartItems(cartiitems);
//				cartItemsDao.saveOrupdate(cartItem);
				cart.setGrandtotal(cart.getGrandtotal() + products.getProduct_Price());
				cart.setTotalItems(cart.getTotalItems() + 1);
				cartDao.saveOrupdate(cart);
				session.setAttribute("items", cart.getTotalItems());
				session.setAttribute("gd", cart.getGrandtotal());
//			    cart.setCartItems(cartItem);
				return new ModelAndView("redirect:/");
				
			}
		} else {
			return new ModelAndView("redirect:/");
		}

	}


	@RequestMapping("/ViewYourCart")
	public String viewcart(Model model, HttpSession session) {
		System.out.println(1223);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			User u = userDao.getUserEmail(currusername);
		        Cart c=u.getCart();
		        System.out.println("\t Cart Intialized ");
//				List<CartItems> cartItems = cartItemsDao.getList(u.getCart().getCartId());
				List<CartItems> cartItems = cartItemsDao.getList(c.getCartId());
				System.out.println("List Of Cart Items Intialized");
				if(cartItems==null ||cartItems.isEmpty())
				{
					session.setAttribute("items",0);
					model.addAttribute("gtotal",0.0);
					model.addAttribute("msg", "no Items is added to cart");
					return "ViewYourCart";		
				}
				System.out.println("\t Sending the secound viewYour Cart");
				model.addAttribute("cartItems", cartItems);
				model.addAttribute("gtotal",c.getGrandtotal());
				session.setAttribute("items",c.getTotalItems());
			    session.setAttribute("cartId", c.getCartId());
				return "ViewYourCart";		
			
		}
		else
		{
			return "redirect:/";
		}
		
	}
	@RequestMapping(value="/Remove/{cart_Items_Id}")
	public String RemoveFromCart(@PathVariable("cart_Items_Id") String id)
	{
		cartItems=cartItemsDao.getCartItems(id);
		Cart c=cartItems.getCart();
		c.setGrandtotal(c.getGrandtotal()-cartItems.getPrice());
		c.setTotalItems(c.getTotalItems()-1);
		cartDao.saveOrupdate(c);
		CartItems cartiitems = cartItemsDao.getCartItems(cartItems.getCart_Items_Id());
		cartItemsDao.delete(cartiitems);
		return "redirect:/ViewYourCart";
	}
	
	@RequestMapping(value="/Removeall")
	public String RemoveallFromCart(Model model,HttpSession session)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			User u = userDao.getUserEmail(currusername);
		Cart c=cartDao.getCart(u.getCart().getCartId());
		List<CartItems> cartItems=cartItemsDao.getList(u.getCart().getCartId());
		for(CartItems g:cartItems)
		{
			CartItems cartiii=cartItemsDao.getCartItems(g.getCart_Items_Id());
		  cartItemsDao.delete(cartiii);
		}
		c.setGrandtotal(0.0);
		c.setTotalItems(0);
		cartDao.saveOrupdate(c);
		session.setAttribute("items",c.getTotalItems());
		return "redirect:/ViewYourCart";
	}

	return "redirect:/ViewYourCart";
	}
}
