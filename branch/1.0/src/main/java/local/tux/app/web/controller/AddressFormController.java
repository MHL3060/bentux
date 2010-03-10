package local.tux.app.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.appfuse.model.User;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import local.tux.Constants;
import local.tux.app.model.ShippingAddress;
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
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
			Object command, BindException error) throws Exception {
		
		HttpSession session = request.getSession();
		session.setAttribute(Constants.ADDRESS_SESSION, command);
		return new ModelAndView(nextPage);
		
	}
}
