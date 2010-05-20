package local.tux.app.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.appfuse.model.Address;
import org.appfuse.model.User;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import local.tux.Constants;
import local.tux.HibernateUtil;
import local.tux.app.model.ShippingAddress;
import local.tux.app.model.ShoppingCart;
import local.tux.app.service.ShoppingCartManager;
import local.tux.app.service.UserReferenceObjectManager;
import local.tux.app.web.common.controller.TuxBaseFormController;

public class AddressFormController extends TuxBaseFormController {

	private String nextPage;
	private ShoppingCartManager shoppingCartManager;
	
	
	public void setNextPage(String nextPage){
		this.nextPage = nextPage;
	}
	public void setShoppingCartManager(ShoppingCartManager shoppingCartManager){
		this.shoppingCartManager = shoppingCartManager;
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		User user = getUserManager().getUserByUsername(request.getRemoteUser());
		ShippingAddress shippingAddress = (ShippingAddress) super.formBackingObject(request);
		shippingAddress.setUser(user);
		return shippingAddress;
	}
	
	@SuppressWarnings("unchecked")
	public Map referenceData(HttpServletRequest request, Object command,
			Errors error) throws Exception {
		Map map = new HashMap();
		User user = getUserManager().getUserByUsername(request.getRemoteUser());
		List<ShippingAddress> addresses = new ArrayList<ShippingAddress>(); //((UserReferenceObjectManager)lookUpManager).getObjectsByUser(user);
		map.put("addresses", addresses);
		return map;
	}
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
			Object command, BindException error) throws Exception {
		User user = getUserManager().getUserByUsername(request.getRemoteUser());
		ShoppingCart cart =  shoppingCartManager.getOpenCart(user);
	
		ShippingAddress address = (ShippingAddress)command;
		if (StringUtils.isBlank(request.getParameter(Constants.CANCEL_ACTION)) == false ) {
			return showForm(request, response, error);
		}else if (address.getSameShipping().booleanValue() == true){
			Address shippingAddress = (Address) HibernateUtil.clone(user.getAddress());
			address.setAddress(shippingAddress);
			address.setFirstName(user.getFirstName());
			address.setLastName(user.getLastName());
		}
		if (address.getUser().equals(user) == false){
			getUserManager().save(address.getUser());
		}
		address = (ShippingAddress) lookUpManager.save(address);
		cart.setShippingAddress(address);
		shoppingCartManager.save(cart);
		return new ModelAndView(nextPage);
		
	}
	
}
