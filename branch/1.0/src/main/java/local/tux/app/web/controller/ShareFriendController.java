package local.tux.app.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.appfuse.model.User;
import org.appfuse.service.UserExistsException;
import org.appfuse.service.UserManager;
import org.appfuse.webapp.util.RequestUtil;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.octo.captcha.service.CaptchaService;

import local.tux.Constants;
import local.tux.SendHtmlMailService;
import local.tux.app.model.ShareFriend;
import local.tux.app.model.Subscription;
import local.tux.app.model.common.TuxBaseObject;
import local.tux.app.web.common.controller.TuxBaseFormController;

public class ShareFriendController extends TuxBaseFormController {
	private CaptchaService captchaService;	
    private SendHtmlMailService htmlMailService;
	private String emailTemplate;
	
///	public void setUserManager(UserManager userManager){
	//	this.userManager = userManager;
//	}
	
	 public void setCaptchaService(CaptchaService captchaService) {
			this.captchaService = captchaService;
	 }
	
	public void setHtmlMailService(SendHtmlMailService htmlMailService){
        this.htmlMailService = htmlMailService;
	}
	
	public void setEmailTemplate(String emailTemplate){
		 this.emailTemplate = emailTemplate;
	 }
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
			Object command, BindException error) throws Exception {

		Locale locale = request.getLocale();
		
		TuxBaseObject baseObject = (TuxBaseObject)command;
		String className = command.getClass().getName();
		boolean isNew = (baseObject.getId() == null);

		String sessionId = request.getSession().getId();
		String email =  request.getParameter("email");
		String name = request.getParameter("name");
		String suggestion = request.getParameter("suggestion");
		String friendEmail = request.getParameter("friendEmail");
    	
		ShareFriend sub = new ShareFriend();
				
				if (captchaService.validateResponseForID(sessionId, ((ShareFriend)baseObject).getValidation()).booleanValue()){
					//User user = userManager.getUserByUsername(request.getRemoteUser());
					sub.setEmail(email);
					sub.setName(name);
					sub.setFriendEmail(friendEmail);
					sub.setSuggestion(suggestion);
					
					lookUpManager.save((TuxBaseObject)command);
					
							
					String key = (isNew) ? className+ ".added" : className + ".updated";
								
					saveMessage(request, getText(key, locale));
					
                    sendConfirmationEmail(request.getLocale(), sub);
					return showNewForm(request, response);
				}else {
					saveError(request, getText("captcha.not.match", locale));
					return showForm(request, response, error);
				}
			
		}
	
    
    private void sendConfirmationEmail(Locale locale, ShareFriend sub) throws Exception {
            Map velocityparams = new HashMap();
            velocityparams.put("sub", sub);
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(sub.getEmail());
            
            mailMessage.setFrom(sub.getFriendEmail());
            mailMessage.setSubject(getText("sharefriend.email.subject", locale));
            htmlMailService.sendHtmlMessage(mailMessage, templateName,null, velocityparams);
                 
    }
}
