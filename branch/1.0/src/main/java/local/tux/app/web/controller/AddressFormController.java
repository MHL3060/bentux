package local.tux.app.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.appfuse.model.Address;
import org.appfuse.model.User;
import org.appfuse.service.LookupManager;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import local.tux.Constants;
import local.tux.HibernateUtil;
import local.tux.app.model.ShippingAddress;
import local.tux.app.service.LookUpNameGenericManager;
import local.tux.app.service.UserReferenceObjectManager;
import local.tux.app.web.common.controller.TuxBaseFormController;

public class AddressFormController extends TuxBaseFormController {

	private String nextPage;
	

	public void setNextPage(String nextPage){
		this.nextPage = nextPage;
	}
	
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		ShippingAddress shippingAddress = (ShippingAddress) super.formBackingObject(request);
		if (StringUtils.isBlank(request.getRemoteUser())== false ) {
			shippingAddress.setUser(getUserManager().getUserByUsername(request.getRemoteUser()));
		}else {
			shippingAddress.setUser(new User());
		}
		return shippingAddress;
	}
	
	@SuppressWarnings("unchecked")
	public Map referenceData(HttpServletRequest request, Object command,
			Errors error) throws Exception {
		Map map = new HashMap();
		User user = getUserManager().getUserByUsername(request.getRemoteUser());
		List<ShippingAddress> addresses = ((UserReferenceObjectManager)lookUpManager).getObjectsByUser(user);
		map.put("addresses", addresses);
		return map;
	}
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
			Object command, BindException error) throws Exception {
		
		HttpSession session = request.getSession();
		ShippingAddress address = (ShippingAddress)command;
		if (address.getSameShipping().booleanValue() == true){
			Address shippingAddress = (Address) HibernateUtil.clone(address.getUser().getAddress());
			address.setAddress(shippingAddress);
		}
		lookUpManager.save(address);
		session.setAttribute(Constants.ADDRESS_SESSION, command);
		return new ModelAndView(nextPage);
		
	}
}
