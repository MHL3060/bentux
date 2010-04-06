package local.tux.app.web.controller;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.appfuse.model.User;
import org.appfuse.service.UserManager;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.octo.captcha.service.CaptchaService;

import local.tux.Constants;
import local.tux.app.model.Subscription;
import local.tux.app.model.common.TuxBaseObject;
import local.tux.app.web.common.controller.TuxBaseFormController;

public class SubscriptionFormController extends TuxBaseFormController {
	
	private UserManager userManager;
	private CaptchaService captchaService;

	private Log log = LogFactory.getLog(SubscriptionFormController.class);
	
	public void setUserManager(UserManager userManager){
		this.userManager = userManager;
	}
	
	public void setCaptchaService(CaptchaService captchaService){
		this.captchaService = captchaService;
	}
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
			Object command, BindException error) throws Exception {
		
		TuxBaseObject baseObject = (TuxBaseObject)command;
		String className = command.getClass().getName();
		boolean isNew = (baseObject.getId() == null);
		Locale locale = request.getLocale();
		String sessionId = request.getSession().getId();
		
		Subscription sub = new Subscription();

		try {
			if (request.getParameter(Constants.DELETE_ACTION) != null){
				lookUpManager.remove(baseObject.getId());
				saveMessage(request, getText(className+".deleted", locale));
				return new ModelAndView(getSuccessView());
			}else {
				if (captchaService.validateResponseForID(sessionId, 
						((Subscription)baseObject).getValidation()).booleanValue()){
					
					lookUpManager.save((TuxBaseObject)command);
					
					User user = userManager.getUserByUsername(request.getRemoteUser());
					if (request.getRemoteUser() != null && sub.getEmail() != null && sub.getPhoneNumber() != null){
						sub.setUser(user);
						sub.setEmail(user.getEmail());	
						sub.setPhoneNumber(user.getPhoneNumber());
						((Subscription)baseObject).setEmail(userManager.getUserByUsername(request.getRemoteUser()).getEmail());
					}					
					String key = (isNew) ? className+ ".added" : className + ".updated";
					saveMessage(request, getText(key, locale));
					return showNewForm(request, response);
				}else {
					saveError(request, getText("captcha.not.match", locale));
					return showForm(request, response, error);
				}
			}
			
		}catch (Exception e){
			saveError(request, getText("captcha.not.match",locale));
			log.error(e);
		}
		return showForm(request, response, error);
	}
	
}
