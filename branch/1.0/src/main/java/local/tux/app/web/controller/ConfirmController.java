package local.tux.app.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.Constants;
import local.tux.app.model.ShippingAddress;
import local.tux.app.model.ShoppingCart;
import local.tux.app.service.ShoppingCartManager;

import org.appfuse.service.UserManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;



public class ConfirmController implements Controller {

	private ShoppingCartManager shoppingCartManager;
	private UserManager userManager;
	public void setShoppingCartManager(ShoppingCartManager shoppingCartManager){
		this.shoppingCartManager = shoppingCartManager;
	}
	public void setUserManager(UserManager userManager){
		this.userManager = userManager;
	}
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		ShoppingCart cart = shoppingCartManager.getOpenCart(userManager.getUserByUsername(request.getRemoteUser()));
		ShippingAddress address = (ShippingAddress) request.getSession().getAttribute(Constants.ADDRESS_SESSION);
		
		mav.addObject("cartItems", cart.getShoppingItems());
		mav.addObject("shippingAddress", address);
		return mav;
		
	}

}
