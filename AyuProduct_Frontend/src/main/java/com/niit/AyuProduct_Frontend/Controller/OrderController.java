package com.niit.AyuProduct_Frontend.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.AyuProduct_Backend.Dao.BillingDao;
import com.niit.AyuProduct_Backend.Dao.CardDao;
import com.niit.AyuProduct_Backend.Dao.CartDao;
import com.niit.AyuProduct_Backend.Dao.CartItemsDao;
import com.niit.AyuProduct_Backend.Dao.OrderDao;
import com.niit.AyuProduct_Backend.Dao.OrderItemsDao;
import com.niit.AyuProduct_Backend.Dao.PayDao;
import com.niit.AyuProduct_Backend.Dao.ProductsDao;
import com.niit.AyuProduct_Backend.Dao.ShippingDao;
import com.niit.AyuProduct_Backend.Dao.UserDao;
import com.niit.AyuProduct_Backend.Model.Billing;
import com.niit.AyuProduct_Backend.Model.Card;
import com.niit.AyuProduct_Backend.Model.Cart;
import com.niit.AyuProduct_Backend.Model.CartItems;
import com.niit.AyuProduct_Backend.Model.Order;
import com.niit.AyuProduct_Backend.Model.OrderItems;
import com.niit.AyuProduct_Backend.Model.Pay;
import com.niit.AyuProduct_Backend.Model.Products;
import com.niit.AyuProduct_Backend.Model.Shipping;
import com.niit.AyuProduct_Backend.Model.User;


@Controller
public class OrderController {

//
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	@Autowired
	CartItems cartItem;
	@Autowired
	CartItemsDao cartItemsDao;
	@Autowired
	Card card;
	@Autowired
	CardDao cardDao;
	@Autowired
	Billing billing;
	@Autowired
	BillingDao billingDao;
	@Autowired
	Shipping shipping;
	@Autowired
	ShippingDao shippingDao;
	@Autowired
	Pay pay;
	@Autowired
	PayDao payDao;
	@Autowired
	Order order;
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderItems orderItems;
	@Autowired
	OrderItemsDao orderItemsDao;
	@Autowired
	Products product;
	@Autowired
	ProductsDao productDao;
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	@Autowired
	List<CartItems> cartItems;
	
//	@Autowired
//    private JavaMailSender mailSender;
	
	String o;
	

	@RequestMapping("/Buyall")
	public String orderall(Model model,HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getUserEmail(currusername);
			cart = user.getCart();
			product=null;
			cartItems = cartItemsDao.getList(cart.getCartId());
			if(cartItems==null || cartItems.isEmpty())
			{
				return "redirect:/ViewYourCart";
			}
			else
			{
				billing = billingDao.get(user.getUser_ID());
				List<Shipping> shippingList = shippingDao.getAddByUser(user.getUser_ID());
				
				model.addAttribute("billing", billing);
				model.addAttribute("user", user);
				model.addAttribute("shippingList", shippingList);
				model.addAttribute("shipping", new Shipping());
				session.setAttribute("p", product);
			}
			return "AddressOrder";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/Buy/{p_id}/{ci_id}")
	public String order(@PathVariable("p_id") String id, Model model,HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getUserEmail(currusername);
			cart = user.getCart();
			cartItems=null;
			product = productDao.getProducts(id);
			billing = billingDao.get(user.getUser_ID());
			List<Shipping> shippingList = shippingDao.getAddByUser(user.getUser_ID());
			
			model.addAttribute("billing", billing);
			model.addAttribute("user", user);
			model.addAttribute("shippingList", shippingList);
			model.addAttribute("shipping", new Shipping());
			session.setAttribute("p", product);
			return "AddressOrder";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/orderConfirm")
	public String payment(@ModelAttribute("shippingAddress") Shipping sh, Model model) {
//		if(cartItems==null || cartItems.isEmpty())
//		{
//			System.out.println("sorry");
//		}
		sh.setUser(user);
		shipping = sh;
		model.addAttribute("billing", billing);
		model.addAttribute("shipping", shipping);
		model.addAttribute("prot", product);
		model.addAttribute("cartItems",cartItems);
		model.addAttribute("cart",cart);
		return "orderconfirm";
	}

	@RequestMapping("/previous")
	public String previous(Model model) {
		List<Shipping> shippingList = shippingDao.getAddByUser(user.getUser_ID());
		model.addAttribute("shippingList", shippingList);
		model.addAttribute("billing", billing);
		model.addAttribute("shippingAddress", shipping);
		model.addAttribute("product", product);
		
		return "AddressOrder";
	}

	@RequestMapping("/pay")
	public String pay(Model model) {
		List<Card> cards = cardDao.getCardByUser(user.getUser_ID());
		model.addAttribute("cards", cards);
		model.addAttribute("card", new Card());
		return "Payment";
	}

	@RequestMapping("/payment")
	public String payment(@RequestParam("payb") String str, @RequestParam("otp")String otp, @ModelAttribute("card")Card c, Model model) {
				
 		System.out.println(1324);
		int a;
		System.out.println(str);
				
		if (str.equalsIgnoreCase("Start Subscription")) {
			a = 2;
		} else {
			a = Integer.parseInt(str);
		}
		System.out.println(a);
		
		switch (a) {
		case 1:
				if(otp.equals(o))
				{
					pay.setPaying_way("COD");
					pay.setStatus("no");
				}
				else
				{
					return "redirect:/pay";
				}
			 
			break;
		case 2:
			pay.setPaying_way("card");
			pay.setStatus("yes");
			payDao.saveOrupdate(pay);
			cardDao.saveOrupdate(c);

			break;
		case 3:
			pay.setPaying_way("Internet Banking");
			pay.setStatus("yes");

		}

		return "redirect:/orderconfirmation";
	}

	@RequestMapping("/orderconfirmation")
	public String orderconformation(HttpSession session) {
		System.out.println(32);
		order.setBilling(billing);
		order.setShipping(shipping);
		order.setPay(pay);
		order.setUser(user);
		System.out.println(524);
		if (cartItems == null || cartItems.isEmpty()) 
		{
			order.setGrand_total(product.getProduct_Price());
			orderDao.saveOrupdate(order);
			orderItems.setOrder(order);
			orderItems.setProductId(product.getProductId());
			orderItemsDao.saveOrupdate(orderItems);
			cart.setGrandtotal(cart.getGrandtotal() - cartItem.getPrice());
			cart.setTotalItems(cart.getTotalItems() - 1);
			session.setAttribute("items", cart.getTotalItems());
			cartDao.saveOrupdate(cart);
//			cartItemDao.delete(cartItemDao.getListAll(cart.getCartId(),product.getProductId()).getCart_Items_Id());
			System.out.println(324);
		}
		else
		{ 
			System.out.println(656);
			order.setGrand_total(cart.getGrandtotal());
			orderDao.saveOrupdate(order);
			for(CartItems c:cartItems)
			{
				System.out.println(3444);
				orderItems.setOrder(order);
				orderItems.setProductId(c.getProducts().getProductId());
				System.out.println(3443);
				orderItemsDao.saveOrupdate(orderItems);
				CartItems cartiitems = cartItemsDao.getCartItems(c.getCart_Items_Id());
				cartItemsDao.delete(cartiitems);
			}
			cart.setGrandtotal(0.0);
			cart.setTotalItems(0);
			System.out.println(346);
			session.setAttribute("items", cart.getTotalItems());
			cartDao.saveOrupdate(cart);
		}
		cartItems=null;
		cartItem=null;
		product=null;
//		order=new Order();
		orderItems=new OrderItems();
		System.out.println(565);
		return "thankyou";
	}


//@RequestMapping(value="/SendMail")
//public void SendMail() {
//	System.out.println(21312);
//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//if (!(authentication instanceof AnonymousAuthenticationToken)) {
//	String currusername = authentication.getName();
//	user = userDao.getUserEmail(currusername);      
//	Otpganarater ot=new Otpganarater();
//	String o=ot.Otpga();
//	o=ot.Otpga();
//	String recipientAddress = user.getU_email();
//	String subject="OTP";
//String subject = request.getParameter("subject");
//String message = "your one time password is "+o+" ";
//
//// prints debug info
//System.out.println("To:" + recipientAddress);
//System.out.println("Subject: " + subject);
//System.out.println("Message: " + message);
//
//    
////System.out.println("OTP:"+ otp);
//// creates a simple e-mail object
//SimpleMailMessage email = new SimpleMailMessage();
//email.setTo(recipientAddress);
//email.setSubject(subject);
//email.setText(message);
////email.setSubject(otp);
//// sends the e-mail
//mailSender.send(email);
//
// 
//// forwards to the view named "Result"
////return "Result";
//}
}