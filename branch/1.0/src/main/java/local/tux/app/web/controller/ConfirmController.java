package local.tux.app.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.Constants;
import local.tux.app.model.ShippingAddress;
import local.tux.app.model.ShoppingCart;
import local.tux.app.service.ShoppingCartManager;

import org.apache.commons.lang.StringUtils;
import org.appfuse.service.UserManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;



public class ConfirmController implements Controller {

	private ShoppingCartManager shoppingCartManager;
	private UserManager userManager;
	private String submitPage;
	private String editPage;
	public void setShoppingCartManager(ShoppingCartManager shoppingCartManager){
		this.shoppingCartManager = shoppingCartManager;
	}
	public void setUserManager(UserManager userManager){
		this.userManager = userManager;
	}
	public void setSubmitPage(String submitPage){
		this.submitPage = submitPage;
	}
	public void setEditPage(String editPage){
		this.editPage = editPage;
	}
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ModelAndView mav;
		if (StringUtils.isBlank(request.getParameter("submit")) == false){
			mav = new ModelAndView(submitPage);
			return mav;
		}else if (StringUtils.isBlank(request.getParameter("edit"))== false){
			mav = new ModelAndView(editPage);
			return mav;
		}else {
			mav = new ModelAndView();
			ShoppingCart cart = shoppingCartManager.getOpenCart(userManager.getUserByUsername(request.getRemoteUser()));
			ShippingAddress address = (ShippingAddress) request.getSession().getAttribute(Constants.ADDRESS_SESSION);
			mav.addObject("cartItems", cart.getShoppingItems());
			mav.addObject("shippingAddress", address);
			return mav;
		}
		
		
		
	}
	
	

}
