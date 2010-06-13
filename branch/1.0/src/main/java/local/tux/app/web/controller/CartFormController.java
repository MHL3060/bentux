package local.tux.app.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.Errors;

import local.tux.Constants;
import local.tux.Constants.CART_STATUS;
import local.tux.app.model.common.LookUpBaseObject;
import local.tux.app.web.common.controller.TuxBaseFormController;

public class CartFormController extends TuxBaseFormController {

	public Map referenceData(HttpServletRequest request, Object command,
			Errors error) throws Exception {
		
		Map result = new HashMap();
		result.put("status", CART_STATUS.values());
		return result;
	}
}
