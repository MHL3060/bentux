package org.appfuse.webapp.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import local.tux.Constants;
import local.tux.HibernateUtil;
import local.tux.SendHtmlMailService;
import local.tux.Constants.CART_STATUS;
import local.tux.app.model.ShippingAddress;
import local.tux.app.model.ShoppingCart;
import local.tux.app.model.ShoppingItem;
import local.tux.app.service.ShoppingCartManager;
import local.tux.app.service.cron.impl.MailQueue;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.app.VelocityEngine;
import org.appfuse.model.Address;
import org.appfuse.service.UserManager;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

public class SignUpHandleController extends SignupController{
	  
	 private SendHtmlMailService htmlMailService;
     private String emailTmeplatePath;
     private UserManager userManager;
     
     private String nextPage;

     public void setNextPage(String nextpage){
    	 this.nextPage = nextPage;
     }
     public void setUserManager(UserManager userManager){
         this.userManager = userManager;
     }
     
	 public void setHtmlMailService(SendHtmlMailService htmlMailService){
	         this.htmlMailService = htmlMailService;
	 }
	 
	 public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
				Object command, BindException error) throws Exception {
			
		 	ModelAndView mav = new ModelAndView(nextPage);
            
		 	Map velocityParams = new HashMap();
			
		 	userManager.getUserByUsername(request.getRemoteUser());
		 	
		 	 if (userManager != null){
                 sendConfirmationEmail(request.getLocale(), userManager);
               //  cart.setStatus(CART_STATUS.SUBMITTED);
             //    shoppingCartManager.save(cart);
         
                 
         }else {
                 mav.addObject("emptyCart", Boolean.TRUE );
         }
         
         return mav;
			//return new ModelAndView(nextPage);
			
			
		 	// User Sign up
		 	// Click Confirm
		 	// Send email to admin (signupController)
		 	//		1. user detail
		 	//		2. admin has the right to disable the account. to disable the account, click here.
		 	// Send email to user (signupHandleController)
		 	//		1. confirmation,
		 	//		2. details
		 	//		3. new passwords generator
		 	// 		
			
		//	return showForm(request, response, error);
		}
		
	 
	
     
     private void sendConfirmationEmail(Locale locale, UserManager cart) throws Exception {
             Map velocityparams = new HashMap();
             velocityparams.put("cart", cart);
             SimpleMailMessage mailMessage = new SimpleMailMessage();
            // mailMessage.setTo(cart.getUser().getEmail());
             
             mailMessage.setFrom("automation@shopattrinity.com");
             mailMessage.setSubject(getText("email.subject", locale));
             htmlMailService.sendHtmlMessage(mailMessage, templateName,null, velocityparams);
                  
     }
	 
	 
}