package local.tux.app.web.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.PasswordGenerator;
import local.tux.SendHtmlMailService;

import org.apache.commons.lang.StringUtils;
import org.appfuse.model.User;
import org.appfuse.service.GenericManager;
import org.appfuse.webapp.controller.UserFormController;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;


public class UserformController extends UserFormController {
	
	public UserformController(){
		super();
	}
	private final int passwordLength = 8;
	private SendHtmlMailService htmlMailService;

	private String passwordEmailTemplate;
	private GenericManager<User, Long> nonVersionUserManager;
	
	public void setHtmlMailService(SendHtmlMailService htmlMailService){
		this.htmlMailService = htmlMailService;
	}
	public void setPasswordEmailTemplate(String passwordEmailTemplate){
		this.passwordEmailTemplate = passwordEmailTemplate;
	}
	public void setNonVersionUserManager(GenericManager<User, Long> nonVersionUserManager){
		this.nonVersionUserManager = nonVersionUserManager;
	}
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
			Object command, BindException error)throws Exception {
		
		ModelAndView mav;
		User user = (User)command;
		Long userId = user.getId();
		
		User persistedUser = nonVersionUserManager.get(userId);
		
		if (user.isEnabled()){
			String password = PasswordGenerator.get(passwordLength);
			user.setPassword(password);
			user.setConfirmPassword(password);
			sendPasswordEmail(user, request.getLocale());	
		}
		mav = super.onSubmit(request, response, user, error);
		
		return mav;
	}
	
	public ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response, 
			Object command, BindException errors) throws Exception {
		
		log.info("submitting form");
		
		return super.processFormSubmission(request, response, command, errors);
	}
	private void sendPasswordEmail(User user , Locale locale) throws Exception {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject(getText("user.password", locale));
		message.setTo(user.getEmail());
		message.setFrom(getText("from.email", locale));
		
		Map model = new HashMap();
		model.put("user", user);
		htmlMailService.sendHtmlMessage(message, passwordEmailTemplate, null, model);
		
	}
}
