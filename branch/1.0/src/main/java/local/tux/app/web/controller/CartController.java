package local.tux.app.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.Constants;
import local.tux.app.model.Product;
import local.tux.app.model.ShoppingItem;
import local.tux.app.model.common.LookUpBaseObject;
import local.tux.app.model.common.TuxBaseObject;
import local.tux.app.service.LookUpNameGenericManager;
import local.tux.app.service.ShoppingItemManager;

import org.apache.commons.lang.StringUtils;
import org.appfuse.webapp.controller.BaseFormController;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;


public class CartController extends BaseFormController {

	private ShoppingItemManager shoppingItemManager;
	private LookUpNameGenericManager<Product, Long> productManager;
	public CartController(){
		setCommandClass(ShoppingItem.class);
		setCommandName("ShoppingItem");
	}
	public void setShoppingItemManager(ShoppingItemManager shoppingItemManager){
		this.shoppingItemManager = shoppingItemManager;
	}
	public void setProductManager(LookUpNameGenericManager<Product, Long> productManager){
		this.productManager = productManager;
	}
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");	
		if (!StringUtils.isBlank(id)) {
            return shoppingItemManager.get(new Long(id));
        }else {
        	return new ShoppingItem();
        }
	}
	@SuppressWarnings("unchecked")
	public Map referenceData(HttpServletRequest request, Object command,
			Errors error) throws Exception {
		
		Map<String, List<ShoppingItem>> result = new HashMap<String, List<ShoppingItem>>();
		result.put("list", shoppingItemManager.getAll());
		return result;
	}
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
			Object command, BindException error) throws Exception {
		
		TuxBaseObject baseObject = (TuxBaseObject)command;
		String className = command.getClass().getName();
		boolean isNew = (baseObject.getId() == null);
		Locale locale = request.getLocale();
		try {
			if (request.getParameter(Constants.DELETE_OBJECT) != null){
				shoppingItemManager.remove(baseObject.getId());
				saveMessage(request, getText(className+".deleted", locale));
				return new ModelAndView(getSuccessView());
			}else {
				shoppingItemManager.save((ShoppingItem)command);
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
