package local.tux.app.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.app.model.common.LookUpBaseObject;
import local.tux.app.service.LookUpNameGenericManager;

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
	private LookUpNameGenericManager lookUpManager;
	
	public void setLookUpManager(LookUpNameGenericManager lookUpManager) {
		this.lookUpManager = lookUpManager;
	}

	@SuppressWarnings("unchecked")
	public Map referenceData(HttpServletRequest request, Object command, Errors error) throws Exception {
		Map<String, List<LookUpBaseObject>> result = new HashMap<String, List<LookUpBaseObject>>();
		result.put("list", lookUpManager.getAll());
		return result;
	}
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException error) throws Exception {
		try {
			lookUpManager.save((LookUpBaseObject)command);
		}catch (Exception e){
			saveError(request, getText("object.exists",request.getLocale()));
			log.error(e);
		}
		return showForm(request, response, error);
	}
}
