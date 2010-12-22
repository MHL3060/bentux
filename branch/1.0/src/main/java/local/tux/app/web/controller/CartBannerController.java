package local.tux.app.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.Constants.CART_STATUS;
import local.tux.app.model.ShoppingCart;
import local.tux.app.service.ShoppingCartManager;

import org.apache.commons.lang.StringUtils;
import org.appfuse.model.User;
import org.appfuse.service.UserManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;





public class CartBannerController implements  Controller{

	private ShoppingCartManager cartManager;
	private UserManager userManager;
	public void setShoppingCartManager(ShoppingCartManager cartManager){
		this.cartManager = cartManager;
	}
	public void setUserManager(UserManager userManager){
		this.userManager = userManager;
	}
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String username = request.getRemoteUser();
		if (StringUtils.isBlank(username) == false){
			User user = userManager.getUserByUsername(username);
			
			Integer count = cartManager.getItemCount(user.getId(), CART_STATUS.OPEN);
			//Double total = cartManager.get
			mav.addObject("cart_item_count", count);
			mav.addObject("cart_sub_total", cartManager.getSubTotal(cartManager.getOpenCart(user)));
		}
		return mav;
		
	}


}
