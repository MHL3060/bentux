package local.tux.app.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.app.Constants;
import local.tux.app.model.common.LookUpBaseObject;
import local.tux.app.model.common.TuxBaseObject;
import local.tux.app.service.LookUpNameGenericManager;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.appfuse.webapp.controller.BaseFormController;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
/**
 * the class for adding/viewing look up reference object.
 * @author Ben Li
 *
 */
public class LookUpTableController extends BaseFormController {

	
	
	private final Log log = LogFactory.getLog(LookUpTableController.class);
	protected LookUpNameGenericManager lookUpManager;
	
	
	public void setLookUpManager(LookUpNameGenericManager lookUpManager) {
		this.lookUpManager = lookUpManager;
	}

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
		String className = command.getClass().getName();
		boolean isNew = (baseObject.getId() == null);
		Locale locale = request.getLocale();
		try {
			if (request.getParameter(Constants.DELETE_OBJECT) != null){
				lookUpManager.remove(baseObject.getId());
				saveMessage(request, getText(className+".deleted", locale));
				return new ModelAndView(getSuccessView());
			}else {
				lookUpManager.save((LookUpBaseObject)command);
				String key = (isNew) ? className+ ".added" : className + ".updated";
				saveMessage(request, getText(key, locale));
				return showNewForm(request, response);
			}
			
		}catch (Exception e){
			saveError(request, getText("object.exists",locale));
			log.error(e);
		}
		return showForm(request, response, error);
	}
}
