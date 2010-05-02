package local.tux.app.web.controller;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import local.tux.Constants;
import local.tux.SendHtmlMailService;
import local.tux.Constants.CART_STATUS;
import local.tux.app.model.ShippingAddress;
import local.tux.app.model.ShoppingCart;
import local.tux.app.model.ShoppingItem;
import local.tux.app.service.ShoppingCartManager;
import local.tux.app.web.common.controller.TuxBaseFormController;


import org.apache.commons.lang.StringUtils;
import org.appfuse.model.User;
import org.apache.commons.lang.StringUtils;
import org.appfuse.service.UserManager;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

public class ConfirmController extends TuxBaseFormController {

	private String submitPage;
	private String editPage;
		
	private ShoppingCartManager shoppingCartManager;
	private UserManager userManager;
	private SendHtmlMailService htmlMailService;
	private String emailTmeplatePath;
	
	public void setEmailTemplatePath(String emailTmeplatePath){
		this.emailTmeplatePath = emailTmeplatePath;
	}
	public void setShoppingCartManager(ShoppingCartManager shoppingCartManager){
		this.shoppingCartManager = shoppingCartManager;
	}
	public void setUserManager(UserManager userManager){
		this.userManager = userManager;
	}
	public void setHtmlMailService(SendHtmlMailService mailService){
		this.htmlMailService = mailService;
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

		
	private void sendConfirmationEmail() {
		  //   htmlMailService.sendHtmlMessage(new SimpleMailMessage(), emailTmeplatePath, new HashMap());
		     
	}
}
