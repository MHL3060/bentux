package local.tux.app.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.Constants.CART_STATUS;
import local.tux.app.model.ShoppingCart;
import local.tux.app.service.ShoppingCartManager;
import local.tux.app.web.common.controller.TuxBaseFormController;
import local.tux.app.web.common.controller.TuxBaseObjectsController;

import org.apache.commons.lang.StringUtils;
import org.appfuse.model.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SubmitOrderController extends TuxBaseObjectsController {

	/**
	 * TODO: implement this
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String username = request.getRemoteUser();
		if (StringUtils.isBlank(username)){
			throw new Exception("user is not found in  the system");
		}
		User user = userManager.getUserByUsername(request.getRemoteUser());
		//ShoppingCart cart = shoppingCartManager.getOpenCart(user);
		//cart.setStatus(CART_STATUS.SUBMITTED);
		//shoppingCartManager.save(cart);
		
		return new ModelAndView();
		
	}

}
