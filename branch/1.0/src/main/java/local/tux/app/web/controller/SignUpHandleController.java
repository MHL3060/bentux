package local.tux.app.web.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import local.tux.HibernateUtil;
import local.tux.PasswordGenerator;
import local.tux.SendHtmlMailService;
import local.tux.Constants.CART_STATUS;
import local.tux.app.model.ShippingAddress;
import local.tux.app.model.ShoppingCart;
import local.tux.app.model.ShoppingItem;
import local.tux.app.service.ShoppingCartManager;
import local.tux.app.service.cron.impl.MailQueue;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.app.VelocityEngine;
import org.appfuse.Constants;
import org.appfuse.model.Address;
import org.appfuse.model.User;
import org.appfuse.service.RoleManager;
import org.appfuse.service.UserExistsException;
import org.appfuse.service.UserManager;
import org.appfuse.webapp.controller.SignupController;
import org.appfuse.webapp.util.RequestUtil;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.AccessDeniedException;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.providers.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

public class SignUpHandleController extends SignupController{
	  
	 private SendHtmlMailService htmlMailService;
	private RoleManager roleManager;
	private String adminEmail;
     
	 public SignUpHandleController(){
		 super();
	 }
	 public void setHtmlMailService(SendHtmlMailService htmlMailService){
	         this.htmlMailService = htmlMailService;
	 }
	 
	 public void setRoleManager(RoleManager roleManager){
		 this.roleManager = roleManager;
	 }
	 public void setAdminEmail(String adminEmail){
		 this.adminEmail = adminEmail;
	 }
	 public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
				Object command, BindException error) throws Exception {
			 	
		User user = (User)command;
		Locale locale = request.getLocale();
		
		user.setEnabled(false);
		user.addRole(roleManager.getRole(org.appfuse.Constants.USER_ROLE));
		try {
			getUserManager().saveUser(user);
		}catch (AccessDeniedException ade){
			log.warn(ade.getMessage());
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}catch (UserExistsException e){
			error.rejectValue("username", "errors.existing.user", new Object[]{user.getUsername(), user.getEmail()}, "duplicate user");
			return showForm(request, response, error);
		}
		saveMessage(request, getText("user.registered", user.getUsername(), locale));
		//request.getSession().setAttribute(org.appfuse.Constants.REGISTERED, Boolean.TRUE);
		
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getConfirmPassword(), user.getAuthorities());
		
		auth.setDetails(user);
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		message.setSubject(getText("signup.email.subject", locale));
		message.setTo(adminEmail);
		try {
			sendUserMessage(user, getText("signup.email.message", locale), RequestUtil.getAppURL(request));
		} catch (MailException me) {
			
		}
		return new ModelAndView(getSuccessView());
	 }

     private void sendConfirmationEmail(Locale locale, UserManager cart) throws Exception {
             Map velocityparams = new HashMap();
             SimpleMailMessage mailMessage = new SimpleMailMessage();
           
             
             mailMessage.setFrom("automation@shopattrinity.com");
             mailMessage.setSubject(getText("email.subject", locale));
             htmlMailService.sendHtmlMessage(mailMessage, templateName,null, velocityparams);
                  
     }
	 
	 
}