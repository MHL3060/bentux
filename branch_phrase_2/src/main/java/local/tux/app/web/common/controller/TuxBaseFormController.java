package local.tux.app.web.common.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.Constants;
import local.tux.app.model.common.LookUpBaseObject;
import local.tux.app.model.common.TuxBaseObject;
import local.tux.app.service.LookUpNameGenericManager;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.appfuse.service.GenericManager;
import org.appfuse.webapp.controller.BaseFormController;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
/**
 * the class for adding/viewing look up reference object.
 * @author Ben Li
 *
 */
public class TuxBaseFormController extends BaseFormController {

	
	
	private final Log log = LogFactory.getLog(TuxBaseFormController.class);
	protected GenericManager lookUpManager;
	
	
	public void setLookUpManager(GenericManager lookUpManager) {
		this.lookUpManager = lookUpManager;
	}

	/** if you need captcha service. you can use 
	 *   validCaptcha = captchaService.validateResponseForID(sessionId, captchaFieldValue);
	 */
	@SuppressWarnings("unchecked")
	public Map referenceData(HttpServletRequest request, Object command,
			Errors error) throws Exception {
		
		Map<String, List<LookUpBaseObject>> result = new HashMap<String, List<LookUpBaseObject>>();
		result.put("list", lookUpManager.getAll());
		return result;
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
		
		if (!StringUtils.isBlank(id)) {
            return lookUpManager.get(new Long(id));
        }else {
        	
        	return getCommandClass().newInstance();
        }
	}
	/** 
	 * common class for handling data from the web form.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
			Object command, BindException error) throws Exception {
		
		TuxBaseObject baseObject = (TuxBaseObject)command;
		
		boolean isNew = (baseObject.getId() == null);
		Locale locale = request.getLocale();
		try {
			if (request.getParameter(getText("form.delete", locale).trim()) != null){
				return deleteAction(request, response, baseObject, error);
			}else if (request.getParameter(getText("form.edit", locale).trim()) != null){
				return editAction(request, response, baseObject, error);
			}else if (request.getParameter(getText("form.save",locale).trim()) != null ) {
				return saveAction(request, response, baseObject, error);
			}else if (request.getParameter(getText("form.cancel", locale).trim()) != null){
				return cancelAction(request, response, baseObject, error);
			}
			
		}catch (Exception e){
			saveError(request, getText("object.exists",locale));
			log.error(e);
		}
		return showForm(request, response, error);
	}
	
	/**
	 * the following actions is predefine for delete, save, edit and cancel if your form using the 
	 * <fmt:message key="form.${actionName}" />
	 * @param request
	 * @param response
	 * @param baseObject
	 * @param error
	 * @return
	 */
	protected ModelAndView cancelAction(HttpServletRequest request,
			HttpServletResponse response, TuxBaseObject baseObject,
			BindException error) {
		return new ModelAndView(getCancelView());
	}

	protected ModelAndView deleteAction(HttpServletRequest request, HttpServletResponse response, 
			TuxBaseObject baseObject, BindException error) throws Exception {
		String className = baseObject.getClass().getName();
		Locale locale = request.getLocale();
		lookUpManager.remove(baseObject.getId());
		saveMessage(request, getText(className+".deleted", locale));
		return new ModelAndView(getSuccessView());
		
	}
	protected ModelAndView editAction(HttpServletRequest request, HttpServletResponse response, 
			TuxBaseObject baseObject, BindException error) throws Exception {
		String className = baseObject.getClass().getName();
		boolean isNew = (baseObject.getId() == null);
		lookUpManager.save(baseObject);
		String key = (isNew) ? className+ ".added" : className + ".updated";
		saveMessage(request, getText(key, request.getLocale()));
		return showNewForm(request, response);
		
	}
	
	protected ModelAndView saveAction(HttpServletRequest request, HttpServletResponse response, 
			TuxBaseObject baseObject, BindException error) throws Exception {
		
		return editAction(request, response, baseObject, error);
	}
}
