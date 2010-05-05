package local.tux.app.web.controller;


import org.springframework.mail.SimpleMailMessage;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.Constants;
import local.tux.SendHtmlMailService;
import local.tux.Constants.CART_STATUS;
import local.tux.app.model.ShippingAddress;
import local.tux.app.model.ShoppingCart;
import local.tux.app.service.ShoppingCartManager;
import local.tux.app.web.common.controller.TuxBaseFormController;


import org.apache.commons.lang.StringUtils;
import org.appfuse.service.UserManager;
import org.springframework.web.servlet.ModelAndView;

public class ConfirmController extends TuxBaseFormController {

	private String submitPage;
	private String editPage;
		
	private ShoppingCartManager shoppingCartManager;
	private UserManager userManager;
	private SendHtmlMailService htmlMailService;
	private String emailTmeplatePath;
	
	public void setShoppingCartManager(ShoppingCartManager shoppingCartManager){
		this.shoppingCartManager = shoppingCartManager;
	}
	public void setUserManager(UserManager userManager){
		this.userManager = userManager;
	}
	public void setHtmlMailService(SendHtmlMailService htmlMailService){
		this.htmlMailService = htmlMailService;
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
			Map velocityParams = new HashMap();
			ShoppingCart cart = shoppingCartManager.getOpenCart(userManager.getUserByUsername(request.getRemoteUser()));
			if (cart != null){
				sendConfirmationEmail(request.getLocale(), cart);
				cart.setStatus(CART_STATUS.SUBMITTED);
				shoppingCartManager.save(cart);
			
				
			}else {
				mav.addObject("emptyCart", Boolean.TRUE );
			}
			
			return mav;
		}else if (StringUtils.isBlank(request.getParameter("edit"))== false){
			mav = new ModelAndView(editPage);
			return mav;
		}else {
			mav = new ModelAndView();
			ShoppingCart cart = shoppingCartManager.getOpenCart(userManager.getUserByUsername(request.getRemoteUser()));
			if (cart != null){
				ShippingAddress address = (ShippingAddress) request.getSession().getAttribute(Constants.ADDRESS_SESSION);
				mav.addObject("cartItems", cart.getShoppingItems());
				mav.addObject("shippingAddress", address);
			}else {
				mav.addObject("emptyCart", Boolean.TRUE );
			}
			return mav;
		}
	}

		
	private void sendConfirmationEmail(Locale locale, ShoppingCart cart) throws Exception {
		Map velocityparams = new HashMap();
		velocityparams.put("cart", cart);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(cart.getUser().getEmail());
		
		mailMessage.setFrom("automation@shopattrinity.com");
		mailMessage.setSubject(getText("email.subject", locale));
		htmlMailService.sendHtmlMessage(mailMessage, templateName,null, velocityparams);
		     
	}
}
