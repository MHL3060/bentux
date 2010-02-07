package local.tux.app.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.Constants;
import local.tux.TuxBaseObjectConverter;
import local.tux.Constants.Status;
import local.tux.app.model.Product;
import local.tux.app.model.ShoppingCart;
import local.tux.app.model.ShoppingItem;
import local.tux.app.model.common.LookUpBaseObject;
import local.tux.app.model.common.TuxBaseObject;
import local.tux.app.service.LookUpNameGenericManager;
import local.tux.app.service.ShoppingCartManager;
import local.tux.app.service.ShoppingItemManager;

import org.apache.commons.lang.StringUtils;
import org.appfuse.model.User;
import org.appfuse.service.UserManager;
import org.appfuse.webapp.controller.BaseFormController;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;


public class CartController extends BaseFormController {
	
	private final String ORIGINAL_ITEM = "originalItem";
	private ShoppingItemManager shoppingItemManager;
	private LookUpNameGenericManager<Product, Long> productManager;
	private ShoppingCartManager shoppingCartManager;
	private String nextWebPage;
	public CartController(){
		setCommandClass(ShoppingItem.class);
		setCommandName("shoppingItem");
	}
	public void setShoppingItemManager(ShoppingItemManager shoppingItemManager){
		this.shoppingItemManager = shoppingItemManager;
	}
	public void setShoppingCartManager(ShoppingCartManager shoppingCartManager){
		this.shoppingCartManager = shoppingCartManager;
	}
	public void setProductManager(LookUpNameGenericManager<Product, Long> productManager){
		this.productManager = productManager;
	}
	public void setNextWebPage(String nextWebPage){
		this.nextWebPage = nextWebPage;
	}
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
		super.initBinder(request, binder);
		TuxBaseObjectConverter converter = new TuxBaseObjectConverter(productManager);
		binder.registerCustomEditor(Product.class, converter);
		
	}
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");	
		if (!StringUtils.isBlank(id)) {
			ShoppingItem item = shoppingItemManager.get(new Long(id));
			request.getSession().setAttribute(ORIGINAL_ITEM, item.clone());
            return item;
        }else {
        	return new ShoppingItem();
        }
	}
	@SuppressWarnings("unchecked")
	public Map referenceData(HttpServletRequest request, Object command,
			Errors error) throws Exception {
		
		Map result = new HashMap();
		if (!StringUtils.isBlank(request.getRemoteUser())){
			User user = getUserManager().getUserByUsername(request.getRemoteUser());
			ShoppingCart cart = shoppingCartManager.getOpenCart(user);
			if(cart != null) {
				result.put("shoppingItems", cart.getShoppingItems());
				if (StringUtils.isBlank(request.getParameter(Constants.EDIT_ACTION)) == false){
					result.put(Constants.ACTION_PARAM, Constants.EDIT_ACTION);
				}
				
			}
			
		}
		
		return result;
	}
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
			Object command, BindException error) throws Exception {
		
		ShoppingItem shoppingItem = (ShoppingItem)command;
		String className = command.getClass().getName();
		boolean isNew = (shoppingItem.getId() == null);
		Locale locale = request.getLocale();
		try {
			if (StringUtils.isBlank(request.getParameter(Constants.DELETE_ACTION)) == false){
				shoppingItemManager.remove(shoppingItem.getId());
				saveMessage(request, getText(className+".deleted", locale));
				return showForm(request, response, error);
			}else if (StringUtils.isBlank(request.getParameter(Constants.SAVE_ACTION))==false ){
				shoppingItemManager.save(shoppingItem, (ShoppingItem)request.getSession().getAttribute(ORIGINAL_ITEM));
				String key = (isNew) ? className+ ".added" : className + ".updated";
				saveMessage(request, getText(key, locale));
				return showForm(request, response, error);
			}else if (StringUtils.isBlank(request.getParameter(Constants.CHECK_OUT))==false ){
				ShoppingCart shoppingCart = shoppingItem.getShoppingCart();
				shoppingCart.setStatus(Status.SUBMITTED);
				shoppingCartManager.save(shoppingCart);
				saveMessage(request, getText("order.checkout", locale));
				return  new ModelAndView(nextWebPage); 
			}
			
		}catch (Exception e){
			//saveError(request, getText("object.exists",locale));
			log.error(e);
		}
		return showForm(request, response, error);
	}
	
	
	
	
}
